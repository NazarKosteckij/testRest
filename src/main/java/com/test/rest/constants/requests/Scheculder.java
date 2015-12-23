package com.test.rest.constants.requests;

import com.test.rest.services.devices.StatusUpdaterService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Nazar on 20.12.2015.
 */

@Component
public class Scheculder {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    StatusUpdaterService statusUpdaterService;
    public void run() {

        try {

            String dateParam = new Date().toString();
            statusUpdaterService.updateStatus();
            System.out.println(dateParam);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
