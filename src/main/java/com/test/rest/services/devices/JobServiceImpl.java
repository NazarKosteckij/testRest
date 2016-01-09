package com.test.rest.services.devices;

import com.test.rest.dao.JobDao;
import com.test.rest.models.JobModel;
import com.test.rest.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nazar on 30.12.2015.
 */
public class JobServiceImpl extends CrudServiceImpl<JobModel,JobDao> implements JobService{

    @Autowired
    JobDao jobDao;

    @Override
    protected JobDao getDao() {
        return this.jobDao;
    }
}
