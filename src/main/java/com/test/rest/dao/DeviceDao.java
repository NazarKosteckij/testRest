package com.test.rest.dao;

import com.test.rest.models.DeviceModel;

import java.util.List;

/**
 * Created by Назар on 19.12.2015.
 */
public interface DeviceDao extends Dao<DeviceModel> {
    public List<DeviceModel> getAllOfUser(int userId);
    public DeviceModel getUsersDevice(int userId, int deviceId);
}
