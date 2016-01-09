package com.test.rest.dao;

import com.test.rest.models.JobModel;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nazar on 03.01.2016.
 */

public class JobDaoImpl extends AbstractDaoImpl<JobModel> implements JobDao {

    @Override
    public List<JobModel> getAll() {
        Session session = getSession();
        session.beginTransaction();
        List<JobModel> jobs = session.createQuery(" from com.test.rest.models.JobModel  Device").list();
        closeSession(session);
        return jobs;
    }

    @Override
    public JobModel read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        JobModel jobModel = (JobModel) session.get(JobModel.class, id);
        closeSession(session);
        return jobModel;
    }

}
