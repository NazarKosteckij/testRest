package com.test.rest.dao;

import com.test.rest.models.DeviceMethodModel;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */
@Transactional
public class DeviceMethodDaoImpl extends AbstractDaoImpl<DeviceMethodModel> implements DeviceMethodDao {

    @Override
    public List<DeviceMethodModel> getAll() {
        Session session = getSession();
        session.beginTransaction();

        List<DeviceMethodModel> requests = session.createQuery(" from com.test.rest.models.DeviceMethodModel  request").list();

        closeSession(session);

        return requests;
    }

    @Override
    public DeviceMethodModel read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        DeviceMethodModel requestModel = (DeviceMethodModel) session
                .get(DeviceMethodModel.class, id);

        closeSession(session);

        return requestModel;
    }
}
