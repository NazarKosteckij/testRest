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
        getSession().save(o);
        getSession().flush();
    }

    @Override
    public List<GetStatusRequestModel> getAll() {
        List<GetStatusRequestModel> requests = getSession().createQuery(" from com.test.rest.models.GetStatusRequestModel  request").list();
        return requests;
    }

    @Override
    public GetStatusRequestModel read(Integer id) {
        return (GetStatusRequestModel) getSession().get(GetStatusRequestModel.class, id);
    }

    @Override
    public void update(GetStatusRequestModel o) {
        Session session = getSession();
        session.update(o);
        session.flush();
    }

    @Override
    public void delete(GetStatusRequestModel o) {
        Session session = getSession();
        session.delete(o);
        session.flush();
    }
}
