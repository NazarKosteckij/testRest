package com.test.rest.services.devices;

import com.test.rest.models.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 30.12.2015.
 */
public class JobServiceImpl implements JobService{
    @Override
    public List<Job> getAll() {
        return new ArrayList<Job>();
    }

    @Override
    public void create(Job job) {

    }

    @Override
    public Job read(Integer id) {
        return null;
    }

    @Override
    public void update(Job job) {

    }

    @Override
    public void delete(Job job) {

    }
}
