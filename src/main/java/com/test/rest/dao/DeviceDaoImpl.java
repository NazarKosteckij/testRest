package com.test.rest.dao;

import com.test.rest.models.DeviceModel;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */

@Transactional
public class DeviceDaoImpl extends HibernateDaoSupport implements DeviceDao {

    @Override
    public void create(DeviceModel device) {
        Session session = getSession();
        session.beginTransaction();
        session.save(device);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<DeviceModel> getAll() {

        List<DeviceModel> devices = null;
        Session session = getSession();
        session.beginTransaction();

        devices = session.createQuery(" from com.test.rest.models.DeviceModel  Device").list();

        session.flush();
        session.getTransaction().commit();
        session.close();
        return devices;
    }

    @Override
    public DeviceModel read(Integer id) {
        return (DeviceModel) getSession().get(DeviceModel.class, id);
    }

    @Override
    public void update(DeviceModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(DeviceModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
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
        session.flush();
        session.getTransaction().commit();
        session.close();

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
        session.flush();
        session.getTransaction().commit();
        session.close();
        return device;
    }
}
