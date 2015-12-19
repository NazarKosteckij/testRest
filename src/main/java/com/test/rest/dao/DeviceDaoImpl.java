package com.test.rest.dao;

import com.test.rest.models.DeviceModel;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Назар on 19.12.2015.
 */
public class DeviceDaoImpl extends HibernateDaoSupport implements DeviceDao {

    @Override
    public void create(DeviceModel device) {
        getSession().save(device);
        getSession().flush();
    }

    @Override
    public List<DeviceModel> getAll() {
        List<DeviceModel> devices = getSession().createQuery(" from com.test.rest.models.DeviceModel  Device").list();
        return devices;
    }

    @Override
    public DeviceModel read(Integer id) {
        return (DeviceModel) getSession().get(DeviceModel.class, id);
    }

    @Override
    public void update(DeviceModel o) {
        Session session = getSession();
        session.update(o);
        session.flush();
    }

    @Override
    public void delete(DeviceModel o) {
        Session session = getSession();
        session.delete(o);
        session.flush();
    }
}
