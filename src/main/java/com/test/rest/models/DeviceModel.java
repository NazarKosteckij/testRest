package com.test.rest.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nazar on 18.12.2015.
 */
@Table(name="devices")
@Entity
public class DeviceModel {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="locationUrl")
    private String locationUrl;

    @Column(name="type")
    private String type;

    @Column(name = "isAlive")
    private  Boolean isAlive;

    @ManyToOne
    private UserModel owner;

    @OneToMany(mappedBy = "device")
    private List<GetStatusRequestModel> getStatusRequestModels;

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<GetStatusRequestModel> getGetStatusRequestModels() {
        return getStatusRequestModels;
    }

    public void setGetStatusRequestModels(List<GetStatusRequestModel> getStatusRequestModels) {
        this.getStatusRequestModels = getStatusRequestModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public DeviceModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

}
