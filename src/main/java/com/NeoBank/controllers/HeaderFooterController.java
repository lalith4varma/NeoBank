package com.NeoBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.NeoBank.services.CustomerDetails;

@Controller
public class HeaderFooterController {
	
	private CustomerDetails details;
	
	public HeaderFooterController(CustomerDetails details) {
		this.details = details;
	}
	
	@GetMapping("/header")
    public String getHeader(Model model) {
		
		model.addAttribute("custName", details.getDetails());
		model.addAttribute("acctNum", details.getAcctNum());
		
        return "Header";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "Footer";
    }

}
