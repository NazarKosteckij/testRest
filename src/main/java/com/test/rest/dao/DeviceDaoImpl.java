package com.test.rest.dao;

import com.test.rest.models.DeviceModel;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */

@Transactional
public class DeviceDaoImpl extends AbstractDaoImpl<DeviceModel> implements DeviceDao {

    @Override
    public List<DeviceModel> getAll() {

        List<DeviceModel> devices = null;
        Session session = getSession();
        session.beginTransaction();

        devices = session.createQuery(" from com.test.rest.models.DeviceModel  Device").list();

        closeSession(session);

        return devices;
    }

    @Override
    public DeviceModel read(Integer id) {
        Session session = getSession();
        session.beginTransaction();
        DeviceModel deviceModel = (DeviceModel) getSession().get(DeviceModel.class, id);
        closeSession(session);
        return deviceModel;
    }

    @Override
    public List<DeviceModel> getAllOfUser(int userId) {
        List<DeviceModel> devices = null;
        Session session = getSession();
        session.beginTransaction();

        devices = getSession()
                .createQuery("from com.test.rest.models.DeviceModel  Device where Device.owner = :userId ")
                .setInteger("userId", userId)
                .list();
        closeSession(session);
        return devices;
    }

    @Override
    public DeviceModel getUsersDevice(int userId, int deviceId) {
        Session session = getSession();
        session.beginTransaction();
        DeviceModel device = (DeviceModel) session
                .createQuery("from com.test.rest.models.DeviceModel  Device where Device.owner = :userId and Device.id = :deviceId")
                .setInteger("userId", userId)
                .setInteger("deviceId", deviceId)
                .list()
                .get(0);
       closeSession(session);
        return device;
    }
}
