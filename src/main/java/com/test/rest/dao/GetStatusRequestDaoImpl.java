package com.test.rest.dao;

import com.test.rest.models.GetStatusRequestModel;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */

public class GetStatusRequestDaoImpl extends HibernateDaoSupport implements GetStatusRequestDao {
    @Override
    public void create(GetStatusRequestModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.save(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<GetStatusRequestModel> getAll() {
        Session session = getSession();
        session.beginTransaction();

        List<GetStatusRequestModel> requests = session.createQuery(" from com.test.rest.models.GetStatusRequestModel  request").list();

        session.flush();
        session.getTransaction().commit();
        session.close();

        return requests;
    }

    @Override
    public GetStatusRequestModel read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        GetStatusRequestModel  requestModel = (GetStatusRequestModel) session
                .get(GetStatusRequestModel.class, id);
        session.flush();
        session.getTransaction().commit();
        session.close();

        return requestModel;
    }

    @Override
    public void update(GetStatusRequestModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);
        session.flush();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(GetStatusRequestModel o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
