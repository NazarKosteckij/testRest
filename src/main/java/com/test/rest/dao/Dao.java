package com.test.rest.dao;

import com.test.rest.models.BaseModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nazar on 19.12.2015.
 */
@Transactional
public interface Dao<clazz extends BaseModel> {

    public void create(clazz o);

    public List<clazz> getAll();

    public clazz read(Integer id);

    public void update(clazz o);

    public void delete(clazz o);

}
