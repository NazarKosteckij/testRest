package com.test.rest.dao;

import com.test.rest.models.BaseModel;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Nazar on 09.01.2016.
 */
public abstract class AbstractDaoImpl<T extends BaseModel> extends HibernateDaoSupport implements Dao<T> {

    @Override
    public abstract List<T> getAll();

    @Override
    public abstract T read(Integer id);

    public void create(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.save(o);

        closeSession(session);
    }

    @Override
    public void update(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);

        closeSession(session);
    }

    @Override
    public void delete(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);

        closeSession(session);
    }

    protected final void closeSession(Session session){
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
