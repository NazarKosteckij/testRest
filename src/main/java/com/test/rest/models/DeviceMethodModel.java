package com.test.rest.models;

import com.test.rest.constants.requests.RequestReturnTypes;

import javax.persistence.*;

/**
 * Created by Nazar on 19.12.2015.
 */
@Table(name="requests")
@Entity
public class DeviceMethodModel implements BaseModel{

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "returnType")
    private String returnType = RequestReturnTypes.JSON;

    @Column(name = "currentValue")
    private String currentValue = RequestReturnTypes.JSON;

    @Column(name = "targetField")
    private String targetField = RequestReturnTypes.JSON;

    @ManyToOne
    private DeviceModel device;

    @Column(name = "units")
    private String units;

    public DeviceMethodModel() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DeviceModel device) {
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTargetField() {
        return targetField;
    }

    public void setTargetField(String targetField) {
        this.targetField = targetField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
