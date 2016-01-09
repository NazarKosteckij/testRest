package com.test.rest.models;

import com.test.rest.models.enums.device.UpdateFrequency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

/**
 * Created by Nazar on 30.12.2015.
 */
@Entity
public class JobModel implements BaseModel{

    @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    private DeviceMethodModel methodModel;

    private UpdateFrequency frequency;

    private Date lastExecution;


    public DeviceMethodModel getMethodModel() {
        return methodModel;
    }

    public void setMethodModel(DeviceMethodModel methodModel) {
        this.methodModel = methodModel;
    }

    public UpdateFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(UpdateFrequency frequency) {
        this.frequency = frequency;
    }

    public Date getLastExecution() {
        return lastExecution;
    }

    public void setLastExecution(Date lastExecution) {
        this.lastExecution = lastExecution;
    }
}
