package com.test.rest.dao;

import com.test.rest.models.Job;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Nazar on 03.01.2016.
 */
public class JobDaoImpl extends HibernateDaoSupport implements JobDao {
    @Override
    public void create(Job o) {
        Session session = getSession();
        session.beginTransaction();
        session.save(o);
        closeSession(session);
    }

    @Override
    public List<Job> getAll() {
        return null;
    }

    @Override
    public Job read(Integer id) {
        return null;
    }

    @Override
    public void update(Job o) {

    }

    @Override
    public void delete(Job o) {

    }

    private final void closeSession(Session session){
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
