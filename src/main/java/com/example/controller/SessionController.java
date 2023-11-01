package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	private HttpSession session;
	
	@Autowired
	public SessionController(HttpSession session) {
		this.session = session;
	}

    @PostMapping("/set")
    @ResponseBody
    public String set(@RequestParam("name") String name, @RequestParam("bloodType") String bloodType) {
        // Sessionへの保存
        this.session.setAttribute("name", name);
        this.session.setAttribute("bloodType", bloodType);
        return "保存しました";
    }
}