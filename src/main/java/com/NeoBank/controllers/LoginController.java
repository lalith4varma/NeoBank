package com.NeoBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.NeoBank.dto.LoginDTO;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@GetMapping("/")
	public String login(@ModelAttribute("creds") LoginDTO loginDto) {
		return "Login";
	}
	
	
	
	// This line of code is no longer necessary. Spring Security will intercept the login page processing.
//	@PostMapping("/processLogin")
//	public String loginProcessing(@ModelAttribute("creds") LoginDTO loginDto) {
//		
//		return "redirect:/home/";
//	}

}
