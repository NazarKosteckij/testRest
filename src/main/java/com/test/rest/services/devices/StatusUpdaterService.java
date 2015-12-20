package com.test.rest.services.devices;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.rest.constants.requests.RequestReturnTypes;
import com.test.rest.constants.requests.RequestTypes;
import com.test.rest.dao.GetStatusRequestDao;
import com.test.rest.models.GetStatusRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.xml.ws.ServiceMode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */
@Service
public class StatusUpdaterService {

    @Autowired
    GetStatusRequestDao getStatusRequestDao;

    public void updateStatus() throws IOException, UnirestException {
        List<GetStatusRequestModel> requests = getStatusRequestDao.getAll();

        for (GetStatusRequestModel requestModel: requests){
            if(requestModel.getReturnType().equals(RequestReturnTypes.JSON)) {
                String endpoint = requestModel.getDevice().getLocationUrl();
                String path = requestModel.getPath();
                String targetField = requestModel.getTargetField();
                //get current value
                requestModel.setCurrentValue(Unirest.get(endpoint + path).asJson().getBody().getObject().get(targetField).toString());
            }
            getStatusRequestDao.update(requestModel);
        }
    }
}
