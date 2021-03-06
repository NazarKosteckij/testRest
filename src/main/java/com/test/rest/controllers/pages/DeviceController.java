package com.test.rest.controllers.pages;

import com.test.rest.contstants.users.UserRoles;
import com.test.rest.dto.UserDto;
import com.test.rest.services.devices.DeviceService;
import com.test.rest.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Locale;

/**
 * Created by Nazar on 19.12.2015.
 */
@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @SuppressWarnings("SpringMVCViewInspection")
    @Secured(value = UserRoles.ROLE_USER)
    @RequestMapping(value = "/mydevices", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response, Locale locale,ModelMap model, Principal principal ) {

        String name = principal.getName();
        model.addAttribute("username", name);
        UserDto user = userService.getByEmail(name);
        model.addAttribute("devices",  deviceService.readAllUserDevices(user.getId()));

        return "devices";
    }

    // TODO have some problems with it without login
    @SuppressWarnings("SpringMVCViewInspection")
    @Secured(value = UserRoles.ROLE_USER)
    @RequestMapping(value = "/mydevices/{deviceId}", method = RequestMethod.GET)
    public String showDeviceDetails(@PathVariable Integer deviceId, HttpServletRequest request, HttpServletResponse response, Locale locale,ModelMap model, Principal principal ) {
        model.addAttribute("methods",  deviceService.read(deviceId).getDeviceMethodModels());
        return "methods";
    }
}
