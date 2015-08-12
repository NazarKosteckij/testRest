package com.test.rest.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/register")
public class ReginsterController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		model.addAttribute("captcha", "1110 + 1");
		request.getSession().putValue("captcha", "1111");
		
		return "register";
	}
	
	@RequestMapping(value = "/captcha/{captcha}", method = RequestMethod.POST)
	public @ResponseBody String captcha(@PathVariable String captcha, HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		Boolean b = request.getSession().getAttribute("camptca").equals(captcha);
		return b.toString();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String doRegister(){
		
		return "register";
	}
}
