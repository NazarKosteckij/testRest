package com.test.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.rest.services.ConfirmRegistrationService;

@Controller
@RequestMapping("/confirmation")
public class ConfirmRegistrationController {
	
	@Autowired
	ConfirmRegistrationService confirmRegistrationService;
	
	@RequestMapping("/{token}")
	public String confirm(@PathVariable("token") String token, @RequestParam("email") String email, Model model) {
		confirmRegistrationService.confirmRegistration(email, token);
		model.addAttribute("status", "Registration completed");
		return "confirm";
	}
}
