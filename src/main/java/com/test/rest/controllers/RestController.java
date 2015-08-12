package com.test.rest.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.rest.exception.TokenException;
import com.test.rest.services.TokenService;
import com.test.rest.utils.StringUtil;

@Controller
@RequestMapping("/")
public class RestController {
	
	@Autowired
	protected TokenService rsa;


	@RequestMapping(value="/string/{string}", method= RequestMethod.POST)
	public String crunchifyREST(@RequestHeader("KEY") String key, @PathVariable String string, HttpServletResponse response, Model model) throws TokenException {
		String reverted = StringUtil.revertString(string);
		
		System.out.print("token in headers: " + key +" POST \n");
		
		if(rsa.isValid(key))
			model.addAttribute("revertedString", reverted);
		else
			throw new TokenException();
		
		return "revertedString";
	}
}
