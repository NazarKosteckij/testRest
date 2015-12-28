package com.test.rest.controllers.api.devices;

import com.test.rest.contstants.users.UserRoles;
import com.test.rest.dto.UserDto;
import com.test.rest.models.DeviceModel;
import com.test.rest.services.devices.DeviceService;
import com.test.rest.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nazar on 19.12.2015.
 */
@Controller
public class DeviceApis {
    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    /**
     *
     * @return List of all {@link DeviceModel}
     */
    @Secured(value = UserRoles.ROLE_ADMIN)
    @RequestMapping("/devices/")
    public @ResponseBody List<DeviceModel> getDevices(){
        return deviceService.getAll();
    }

    /**
     *
     * @param id
     * @return {@link DeviceModel}
     */
    @RequestMapping("/devices/{id}")
    public @ResponseBody DeviceModel getSingleDevice(@PathVariable int id){
        return deviceService.read(id);
    }

    /**
     * Shows all devices of user
     * @param userId
     * @return
     */
    @RequestMapping("/users/{userId}/devices/")
    public @ResponseBody List<DeviceModel>  getAllUsersDevices(@PathVariable int userId){
        return deviceService.readAllUserDevices(userId);
    }


    @RequestMapping("/users/{userId}/devices/{deviceId}")
    public @ResponseBody  DeviceModel getUserSingleDevice(@PathVariable int userId, @PathVariable int deviceId){
        return deviceService.readUserDevice(userId, deviceId);
    }
}
