package com.test.rest.services.devices;

import com.test.rest.dao.DeviceDao;
import com.test.rest.models.BaseModel;
import com.test.rest.models.DeviceMethodModel;
import com.test.rest.models.DeviceModel;
import com.test.rest.services.CrudService;
import com.test.rest.services.Observable;
import com.test.rest.services.ServiceObserver;
import com.test.rest.services.observers.DeviceObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

/**
 * Created by Nazar on 20.12.2015.
 */
@Service
public class DeviceService implements CrudService<DeviceModel>, Observable {

    @Autowired
    protected DeviceDao deviceDao;

    protected List<ServiceObserver> serviceObservers;

    public DeviceService() {
        serviceObservers = new Vector<ServiceObserver>();
        serviceObservers.add(new DeviceObserver());
    }

    @Override
    public List<DeviceModel> getAll() {
        List<DeviceModel> deviceModels =  deviceDao.getAll();
        for (DeviceModel model : deviceModels) {
            model.setOwner(null);
            for(DeviceMethodModel requestModel : model.getDeviceMethodModels()) {
                requestModel.setDevice(null);
            }
        }
        return deviceModels;
    }

    @Override
    public void create(DeviceModel obj) {
        notifyObservers(obj);
        deviceDao.create(obj);
    }

    @Override
    public DeviceModel read(Integer id) {
        DeviceModel model =  deviceDao.read(id);
        model.setOwner(null);
        for(DeviceMethodModel requestModel : model.getDeviceMethodModels()) {
            requestModel.setDevice(null);
        }
        return model;
    }


    public DeviceModel readUserDevice(Integer  userId, Integer deviceId) {
        DeviceModel deviceModel =  deviceDao.getUsersDevice(userId, deviceId);
        deviceModel.setOwner(null);
        for(DeviceMethodModel requestModel : deviceModel.getDeviceMethodModels()) {
            requestModel.setDevice(null);
        }
        return deviceModel;
    }

    public List<DeviceModel> readAllUserDevices(Integer  userId) {
        List<DeviceModel> deviceModels =  deviceDao.getAllOfUser(userId);
        for (DeviceModel model : deviceModels) {
            model.setOwner(null);
            for(DeviceMethodModel requestModel : model.getDeviceMethodModels()) {
                requestModel.setDevice(null);
            }
        }
        return deviceModels;
    }

    @Override
    public void update(DeviceModel obj) {
        if (obj!=null)
            if (obj.getId()!= 0) {
                deviceDao.update(obj);
            } else throw new IllegalArgumentException("User id should be a positive digit");
    }

    @Override
    public void delete(DeviceModel obj) {
        if (obj!=null)
            if (obj.getId()!= 0) {
                deviceDao.delete(obj);
                notifyObservers(obj);
            }
    }

    @Override
    public void addObserver(ServiceObserver serviceObserver) {
        this.serviceObservers.add(serviceObserver);
    }

    @Override
    public void deleteObserver(ServiceObserver serviceObserver) {
        this.serviceObservers.remove(serviceObserver);
    }

    @Override
    public void notifyObservers(BaseModel baseModel) {
        for (ServiceObserver serviceObserver: serviceObservers) {
            serviceObserver.update(baseModel);
        }
    }
}
