package com.test.rest.services.devices;

import com.test.rest.dao.DeviceDao;
import com.test.rest.models.DeviceModel;
import com.test.rest.models.GetStatusRequestModel;
import com.test.rest.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Назар on 20.12.2015.
 */
@Service
public class DeviceService implements CrudService<DeviceModel>{

    @Autowired
    private DeviceDao deviceDao;



    @Override
    public List<DeviceModel> getAll() {
        List<DeviceModel> deviceModels =  deviceDao.getAll();
        for (DeviceModel model : deviceModels) {
            model.setOwner(null);
            for(GetStatusRequestModel requestModel : model.getGetStatusRequestModels()) {
                requestModel.setDevice(null);
            }
        }
        return deviceModels;
    }

    @Override
    public void create(DeviceModel obj) {
        deviceDao.create(obj);
    }

    @Override
    public DeviceModel read(Integer id) {
        DeviceModel model =  deviceDao.read(id);
        model.setOwner(null);
        for(GetStatusRequestModel requestModel : model.getGetStatusRequestModels()) {
            requestModel.setDevice(null);
        }
        return model;
    }


    public DeviceModel readUserDevice(Integer  userId, Integer deviceId) {
        DeviceModel deviceModel =  deviceDao.getUsersDevice(userId, deviceId);
        deviceModel.setOwner(null);
        for(GetStatusRequestModel requestModel : deviceModel.getGetStatusRequestModels()) {
            requestModel.setDevice(null);
        }
        return deviceModel;
    }
    public List<DeviceModel> readAllUserDevices(Integer  userId) {
        List<DeviceModel> deviceModels =  deviceDao.getAllOfUser(userId);
        for (DeviceModel model : deviceModels) {
            model.setOwner(null);
            for(GetStatusRequestModel requestModel : model.getGetStatusRequestModels()) {
                requestModel.setDevice(null);
            }
        }
        return deviceModels;
    }

    @Override
    public void update(DeviceModel obj) {
        if (obj!=null)
            if (obj.getId()!= 0)
                deviceDao.update(obj);
    }

    @Override
    public void delete(DeviceModel obj) {
        if (obj!=null)
            if (obj.getId()!= 0)
                deviceDao.delete(obj);
    }
}
