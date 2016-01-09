package com.test.rest.services.devices;

import com.test.rest.dao.JobDao;
import com.test.rest.models.JobModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 30.12.2015.
 */
public class JobServiceImpl   implements JobService{
    @Autowired
    JobDao jobDao;

    @Override
    public List<JobModel> getAll() {
        return new ArrayList<JobModel>();
    }

    @Override
    public void create(JobModel jobModel) {

    }

    @Override
    public JobModel read(Integer id) {
        return null;
    }

    @Override
    public void update(JobModel jobModel) {

    }

    @Override
    public void delete(JobModel jobModel) {

    }
}
