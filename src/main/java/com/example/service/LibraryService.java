package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.form.LibraryForm;
import com.example.repository.LibraryRepository;

@Service
public class LibraryService {
	private final LibraryRepository libraryRepository;
	
	@Autowired
	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
	
	public List<Library> findAll() {
		return this.libraryRepository.findAll();
	}
	
	public Library findById(Integer id) {
		Optional<Library> optionalLibrary = this.libraryRepository.findById(id);
		Library library = optionalLibrary.get();
		return library;
	}
	
	//データ保存用のメソッド
	public Library save(LibraryForm libraryForm) {
		Library library = new Library();
		library.setName(libraryForm.getName());
		library.setId(libraryForm.getId());
		return this.libraryRepository.save(library);
	}
	
}
