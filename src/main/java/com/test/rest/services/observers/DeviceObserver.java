package com.test.rest.services.observers;

import com.test.rest.models.DeviceModel;
import com.test.rest.services.EmailService;
import com.test.rest.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nazar on 03.01.2016.
 */
public class DeviceObserver implements ServiceObserver<DeviceModel> {
    @Autowired
    EmailService emailService;


    @Override
    public void update(DeviceModel model) {
        if(!model.getIsAlive()){
            // TODO: 08.01.2016 add handling for this event
            System.out.print("No connection !!! ERROR !!! \n");
        }
    }
}
