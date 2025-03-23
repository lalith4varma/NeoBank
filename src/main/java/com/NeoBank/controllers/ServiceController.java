package com.NeoBank.controllers;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.NeoBank.dto.DepositDTO;
import com.NeoBank.dto.FundTransferDTO;
import com.NeoBank.model.CustomerModel;
import com.NeoBank.services.BankServiceImpl;
import com.NeoBank.services.CustomerDetails;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home/services")
public class ServiceController {
	
	private CustomerDetails details;
	private BankServiceImpl services;
	
	public ServiceController(CustomerDetails details, BankServiceImpl services) {
		this.details = details;
		this.services = services;
	}
	
	@GetMapping("/")
	public String serviceMainPage(Model model) {
		model.addAttribute("balance", services.getBalance(details.getAcctNum()));
		model.addAttribute("editInfo", details.getDetails());
		model.addAttribute("deposit", new DepositDTO());
		model.addAttribute("transaction", services.getTransactions(details.getAcctNum()));
		model.addAttribute("transfer", new FundTransferDTO());
		
		return "Services";
	}
	
	@PostMapping("/processAccountInfo")
	public String accountInfoProcessing(@ModelAttribute("editInfo") CustomerModel cust) {
		services.editInfo(details.getAcctNum(), cust.getName(),cust.getAddress(),cust.getContact());
		details.updateName(cust);
		
		return "redirect:/home/services/";
	}
	
	@PostMapping("/processDeposit")
	public String depositProcessing(@ModelAttribute("deposit") DepositDTO deposit) {
		System.out.println("Deposit Amount = " + deposit.getAmount());
		services.deposit(deposit.getAmount(), deposit.getAcctNum());
		return "redirect:/home/services/";
	}
	
	@PostMapping("/processTransfer")
	public String transferProcessing(@Valid @ModelAttribute("transfer") FundTransferDTO fundTransfer, BindingResult res, RedirectAttributes redirectAttributes) {
		
		try {
			
			if(res.hasErrors()) {
				
				redirectAttributes.addFlashAttribute("failedMessage", "Incorrect recipient account number");
				return "redirect:/home/services/";
			}
			
			services.transfer(fundTransfer.getAmount(), fundTransfer.getSourceAcct(), fundTransfer.getDestinationAcct());
			
		} catch (UsernameNotFoundException e) {
			redirectAttributes.addFlashAttribute("failedMessage", "Recipient account number does not exist");
			return "redirect:/home/services/";
		} catch (RuntimeException e) {
			redirectAttributes.addFlashAttribute("failedMessage", "Self-transfer is not allowed");
			return "redirect:/home/services/";
		}

		return "redirect:/home/services/";
	}
}
