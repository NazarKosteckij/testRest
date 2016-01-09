package com.test.rest.controllers.pages;

import com.test.rest.contstants.users.UserRoles;
import com.test.rest.exception.TokenException;
import com.test.rest.services.TokenService;
import com.test.rest.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Locale;

@Controller
public class RevertStringController {
	
	@Autowired
	private TokenService rsa;
	@Secured(value = UserRoles.ROLE_USER)
	@RequestMapping(value = "/revert", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws NoSuchAlgorithmException, NoSuchProviderException {
		String key = rsa.getPublicKey();
		model.addAttribute("authKey", key);
		return "revertString";
	}
	
	@RequestMapping(value="/string/{string}", method= RequestMethod.POST)
	public String crunchifyREST(@RequestHeader("KEY") String key, @PathVariable String string, HttpServletResponse response, Model model) throws TokenException {
		String reverted = StringUtil.revertString(string);
		
		System.out.print("token in headers: " + key +" POST \n");
		
		if(rsa.isValid(key))
			model.addAttribute("revertedString", reverted);
		else
			throw new TokenException();
		
		return "getRevertedString";
	}
}
