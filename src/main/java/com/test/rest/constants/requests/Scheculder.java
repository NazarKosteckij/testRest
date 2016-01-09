package com.test.rest.constants.requests;

import com.test.rest.services.devices.StatusUpdaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nazar on 20.12.2015.
 */

@Component
public class Scheculder {

    @Autowired
    StatusUpdaterService statusUpdaterService;

    public void run() {

        statusUpdaterService.run();

    }
}
