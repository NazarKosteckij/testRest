package com.test.rest.controllers.pages;

import com.test.rest.dto.UserDto;
import com.test.rest.exception.ConfirmationRegistrationException;
import com.test.rest.services.users.UserService;
import com.test.rest.utils.recaptcha.VerifyCaptchaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;


@Controller
@RequestMapping(value = "/register")
public class ReginsterController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private VerifyCaptchaImpl verifyCaptcha;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws ConfirmationRegistrationException {
		return "register";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public @ResponseBody UserDto doRegister(HttpServletRequest request, HttpServletResponse response,  @RequestBody UserDto user) throws IOException{
		String gRecaptchaResponse = request.getHeader("g-recaptcha-response");
	    
		if (verifyCaptcha.verify(gRecaptchaResponse)){
	    	userService.addUser(user);
	    } else {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    }
	    
		return user;
		
	}
	@RequestMapping(value="/checEmail", method=RequestMethod.POST)
	public @ResponseBody String checEmail(@RequestParam String email, HttpServletResponse response){
		if(userService.checkEmailExisting(email)){
			response.setStatus(200);
			return "{\"status\":\"ok\"}";
		} else {
			response.setStatus(406);
			return "{\"status\":\"error\"}";
		}
	}
}
