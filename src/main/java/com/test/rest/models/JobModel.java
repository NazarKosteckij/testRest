package com.test.rest.models;

import com.test.rest.models.enums.device.UpdateFrequency;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Nazar on 30.12.2015.
 */
@Entity
@Table(name="job")
public class JobModel implements BaseModel{

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column
    private String name;

    @OneToOne
    private DeviceMethodModel method;

    @Column
    private UpdateFrequency frequency;

    @Column
    private Date lastExecution;


    public DeviceMethodModel getMethodModel() {
        return method;
    }

    public void setMethodModel(DeviceMethodModel methodModel) {
        this.method = methodModel;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeviceMethodModel getMethod() {
        return method;
    }

    public void setMethod(DeviceMethodModel method) {
        this.method = method;
    }
}
