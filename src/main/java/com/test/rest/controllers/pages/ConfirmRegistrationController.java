package com.test.rest.controllers.pages;

import com.test.rest.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/confirmation")
public class ConfirmRegistrationController {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String confirm( Model model, HttpServletResponse response) {
		model.addAttribute("status", "Your registration is completed");
		return "confirm";
	}

	@RequestMapping("/{token}")
	public String confirmToken(@PathVariable("token") String token, Model model, HttpServletResponse response) {
		userService.confirmRegistration(token);
		response.setHeader("Location", "/confirmation");
		model.addAttribute("status", "success");
		return "redirect:/confirmation";
	}
}
