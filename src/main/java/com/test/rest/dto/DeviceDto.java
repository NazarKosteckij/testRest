package com.test.rest.dto;

import com.test.rest.models.enums.device.DeviceType;

/**
 * Created by Назар on 26.12.2015.
 */
public class DeviceDto implements BaseDto{
    private int id;

    private String name;

    private String locationUrl;

    private DeviceType type;

    private Boolean isAlive;

    public DeviceDto() {
    }

    private Integer ownerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
