package com.test.rest.dao;

import com.test.rest.models.DeviceMethodModel;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */
@Transactional
public class DeviceMethodDaoImpl extends HibernateDaoSupport implements DeviceMethodDao {
    @Override
    public void create(DeviceMethodModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.save(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<DeviceMethodModel> getAll() {
        Session session = getSession();
        session.beginTransaction();

        List<DeviceMethodModel> requests = session.createQuery(" from com.test.rest.models.DeviceMethodModel  request").list();

        session.flush();
        session.getTransaction().commit();
        session.close();

        return requests;
    }

    @Override
    public DeviceMethodModel read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        DeviceMethodModel requestModel = (DeviceMethodModel) session
                .get(DeviceMethodModel.class, id);
        session.flush();
        session.getTransaction().commit();
        session.close();

        return requestModel;
    }

    @Override
    public void update(DeviceMethodModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);
        session.flush();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(DeviceMethodModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
