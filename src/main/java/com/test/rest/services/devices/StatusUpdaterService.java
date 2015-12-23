package com.test.rest.services.devices;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.rest.constants.requests.RequestReturnTypes;
import com.test.rest.constants.requests.RequestTypes;
import com.test.rest.dao.GetStatusRequestDao;
import com.test.rest.models.GetStatusRequestModel;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.xml.ws.ServiceMode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nazar on 19.12.2015.
 */
@Service
public class StatusUpdaterService extends TimerTask implements ItemReader {

    @Autowired
    GetStatusRequestDao getStatusRequestDao;

    public StatusUpdaterService(){
        System.out.print("======= Created new StatusUpdaterService ========== \n");

        Timer timer = new Timer();
        timer.schedule(this, 1000*60);

    }

    @Override
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
        List<GetStatusRequestModel> requests = getStatusRequestDao.getAll();

        for (GetStatusRequestModel requestModel: requests){
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
            getStatusRequestDao.update(requestModel);
        }
    }

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        this.run();
        return null;
    }
}
