package com.test.rest.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.rest.dto.UserDto;
import com.test.rest.services.UserService;
import com.test.rest.utils.VerifyCaptcha;
import com.test.rest.utils.mappers.UserMapper;



@Controller
@RequestMapping(value = "/register")
public class ReginsterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "register";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public @ResponseBody UserDto doRegister(HttpServletRequest request, HttpServletResponse response,  @RequestBody UserDto user) throws IOException{
		String gRecaptchaResponse = request.getHeader("g-recaptcha-response");
	    
		if (VerifyCaptcha.verify(gRecaptchaResponse)){
	    	userService.addUser(UserMapper.creaUserFromDto(user));
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
