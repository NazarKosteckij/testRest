package com.test.rest.dao;

import com.test.rest.models.UserModel;

import java.util.List;

/**
 * Created by Назар on 19.12.2015.
 */
public interface Dao<clazz> {

    public void create(clazz o);

    public List<clazz> getAll();

    public clazz read(Integer id);

    public void update(clazz o);

    public void delete(clazz o);

}
