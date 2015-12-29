package com.test.rest.services.devices;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.rest.constants.requests.RequestReturnTypes;
import com.test.rest.dao.DeviceMethodDao;
import com.test.rest.models.DeviceMethodModel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */
public class StatusUpdaterService   {

    private DeviceMethodDao deviceMethodDao;

    public StatusUpdaterService(){
        System.out.print("======= Created new StatusUpdaterService ========== \n");
    }

    public void run() {
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
            if(requestModel.getReturnType().equals(RequestReturnTypes.JSON)) {
                String endpoint = requestModel.getDevice().getLocationUrl();
                String path = requestModel.getPath();
                String targetField = requestModel.getTargetField();
                String value = "";
                //get current value
                //TODO: Handle exception com.mashape.unirest.http.exceptions.UnirestException as "failed: connect timed out"
                try {
                    value = Unirest.get(endpoint + path).asJson().getBody().getObject().get(targetField).toString();
                } catch (com.mashape.unirest.http.exceptions.UnirestException e){
                    value = "No connection";
                }
                requestModel.setCurrentValue(value);
            }
            deviceMethodDao.update(requestModel);
        }
    }

    public void setDeviceMethodDao(DeviceMethodDao deviceMethodDao) {
        this.deviceMethodDao = deviceMethodDao;
    }

    public DeviceMethodDao getDeviceMethodDao() {
        return deviceMethodDao;
    }
}
