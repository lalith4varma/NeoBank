package com.NeoBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomepageController {
	
	@GetMapping("/")
	public String home() {
		return "Homepage";
	}
	
	@GetMapping("/aboutus")
	public String aboutUs() {
		return "AboutUs";
	}
	
	@GetMapping("/contactus")
	public String contactUs() {
		return "ContactUs";
	}
}
