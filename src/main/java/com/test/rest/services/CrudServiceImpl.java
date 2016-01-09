package com.test.rest.services;

import com.test.rest.dao.Dao;
import com.test.rest.models.BaseModel;

import java.util.List;

/**
 * Created by Nazar on 09.01.2016.
 */
public abstract class CrudServiceImpl<Model extends BaseModel, D extends Dao<Model>> implements CrudService<Model>{

    protected abstract D getDao();

    @Override
    public List<Model> getAll() {
        return getDao().getAll();
    }

    @Override
    public void create(Model obj) {
        getDao().create(obj);
    }

    @Override
    public Model read(Integer id) {
        return getDao().read(id);
    }

    @Override
    public void update(Model obj) {
        getDao().update(obj);
    }

    @Override
    public void delete(Model obj) {
        getDao().delete(obj);
    }
}
