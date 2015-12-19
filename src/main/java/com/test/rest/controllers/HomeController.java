package com.test.rest.controllers;

import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.rest.dao.DeviceDao;
import com.test.rest.dao.UserDao;
import com.test.rest.models.DeviceModel;
import com.test.rest.models.UserModel;
import com.test.rest.services.StatusUpdaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws NoSuchProviderException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/error403", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response)  {
		response.setStatus(403);
		return "error403";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login()  {
		return "login";
	}
}
