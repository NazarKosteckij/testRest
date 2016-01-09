package com.test.rest.services;

import com.test.rest.models.BaseModel;

/**
 * Created by Nazar on 03.01.2016.
 */
public interface ServiceObserver<T extends BaseModel> {
    void update(T model);
}
