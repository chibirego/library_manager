package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Log;
import com.example.entity.Library;
import com.example.service.LibraryService;
import com.example.service.LogService;
import com.example.service.LoginUser;
import com.example.form.LibraryForm;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	private final LibraryService libraryService;
	private final LogService logService;
	
	@Autowired
	public LibraryController(LibraryService libraryService, LogService logService) {
		this.libraryService = libraryService;
		this.logService = logService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Library> libraries = this.libraryService.findAll();
		model.addAttribute("libraries", libraries);
		return "library/index";
	}
	
	@GetMapping("/borrow")
	public String borrowingForm(@RequestParam("id") Integer id, Model model, @ModelAttribute("libraryForm") LibraryForm libraryForm) {
		Library library = this.libraryService.findById(id);
		libraryForm.setName(library.getName());
		libraryForm.setId(library.getId());
		
		model.addAttribute("id", id);
		model.addAttribute("library", library);
		
		return "library/borrowingForm";
	}
	
	@PostMapping("/borrow")
	public String borrow(@RequestParam("id") Integer id, @RequestParam("return_due_date") String returnDueDate, @AuthenticationPrincipal LoginUser loginUser) {
		Library library = this.libraryService.findById(id);
		library.setUserId(library.getUserId());
		
		Log log = this.logService.findById(id);
		return "redirect:/library";
	}
	
	// 商品編集ページ
	//@GetMapping("henshu/{id}")
	//public String henshuPage(@PathVariable("id") Integer id, Model model, @ModelAttribute("itemForm") ItemForm itemForm) {
	//	Item item = this.itemService.findById(id);
	//	itemForm.setName(item.getName());
	//	itemForm.setPrice(item.getPrice());
		
	//	itemForm.setCategoryId(item.getCategoryId());
		
	//	List<Category> categories = this.categoryService.findAll();
		
	//	model.addAttribute("id", id);
		
	//	model.addAttribute("categories", categories);
		
	//	return "item/henshuPage";
	//}
}
