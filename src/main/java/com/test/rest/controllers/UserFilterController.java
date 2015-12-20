package com.test.rest.controllers;

import com.test.rest.models.UserModel;
import com.test.rest.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nkostets on 9/14/2015.
 */

@Controller
@RequestMapping("/users")
public class UserFilterController {

    @Autowired
    UserService userService;
    
    //TODO change com.test.rest.models.UserModel onto com.test.rest.dto.UserDto
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<UserModel> getAll(){

        return userService.getAll();
    }
}
