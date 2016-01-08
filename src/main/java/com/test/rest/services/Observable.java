package com.test.rest.services;

import com.test.rest.models.BaseModel;

/**
 * Created by Nazar on 03.01.2016.
 */
public interface Observable {
    void addObserver(ServiceObserver serviceObserver);
    void deleteObserver(ServiceObserver serviceObserver);
    void notifyObservers(BaseModel baseModel);
}
