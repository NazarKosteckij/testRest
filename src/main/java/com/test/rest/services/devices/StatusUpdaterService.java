package com.test.rest.services.devices;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.rest.constants.requests.RequestReturnTypes;
import com.test.rest.dao.DeviceMethodDao;
import com.test.rest.models.BaseModel;
import com.test.rest.models.DeviceMethodModel;
import com.test.rest.models.Job;
import com.test.rest.services.Observable;
import com.test.rest.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Nazar on 19.12.2015.
 */
public class StatusUpdaterService implements Observable, Runnable{

    private List<ServiceObserver> serviceObservers;

    @Autowired
    protected DeviceMethodDao deviceMethodDao;

    JobService jobService;

    public StatusUpdaterService(){
        serviceObservers = new Vector<ServiceObserver>();
    }

    public void run() {
        List<Job> jobs = new ArrayList<Job>();
        Job jobStub = new Job();
        jobStub.setMethodModel(deviceMethodDao.read(2));
        for (Job job: jobs){
            DeviceMethodModel methodModel = job.getMethodModel();
            doUpdate(methodModel);
        }
        System.out.print("Date "  + new Date().toString() + "\n");
        try {
            this.updateStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus() throws IOException, UnirestException {
        List<DeviceMethodModel> requests = deviceMethodDao.getAll();

        for (DeviceMethodModel requestModel: requests){
            doUpdate(requestModel);
        }
    }

    public void setDeviceMethodDao(DeviceMethodDao deviceMethodDao) {
        this.deviceMethodDao = deviceMethodDao;
    }

    private void doUpdate(DeviceMethodModel methodModel){

        if(methodModel.getReturnType().equals(RequestReturnTypes.JSON)) {
            String endpoint = methodModel.getDevice().getLocationUrl();
            String path = methodModel.getPath();
            String targetField = methodModel.getTargetField();
            String value = "";
            //get current value
            //TODO: Handle exception com.mashape.unirest.http.exceptions.UnirestException as "failed: connect timed out"
            try {
                value = Unirest.get(endpoint + path).asJson().getBody().getObject().get(targetField).toString();
            } catch (com.mashape.unirest.http.exceptions.UnirestException e){
                value = "No connection";
            }
            methodModel.setCurrentValue(value);
        }
        deviceMethodDao.update(methodModel);
    }

    public DeviceMethodDao getDeviceMethodDao() {
        return deviceMethodDao;
    }

    @Override
    public void addObserver(ServiceObserver serviceObserver) {
        serviceObservers.add(serviceObserver);
    }

    @Override
    public void deleteObserver(ServiceObserver serviceObserver) {
        serviceObservers.remove(serviceObserver);
    }

    @Override
    public void notifyObservers(BaseModel baseModel) {
        for(ServiceObserver serviceObserver: serviceObservers){
            serviceObserver.update(baseModel);
        }
    }
}
