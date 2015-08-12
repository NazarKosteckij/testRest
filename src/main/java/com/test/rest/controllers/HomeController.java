package com.test.rest.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.rest.dao.UserDao;
import com.test.rest.dao.UserDaoIpml;
import com.test.rest.models.UserModel;
import com.test.rest.services.TokenService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	

	@Autowired
	private TokenService rsa;
	
	@Autowired
	private UserDao dao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 */
	@ExceptionHandler
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws NoSuchAlgorithmException, NoSuchProviderException {
		String key = rsa.getPublicKey();
		model.addAttribute("authKey", key);
		UserModel user = new UserModel();
		dao.create(user);
		return "home";
	}
	
}
