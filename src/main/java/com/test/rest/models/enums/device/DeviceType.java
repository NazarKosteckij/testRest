package com.test.rest.models.enums.device;

/**
 * Created by Назар on 22.12.2015.
 */
public enum DeviceType {
    Arduino("Arduino"),
    Raspberry("Raspberry"),
    Other("Other");

    private String type;

    public String toString(){
        return this.type;
    }

    DeviceType(String type){
        if (type.equals("Arduino")||type.equals("Raspberry")) {

        } else {
            type = "Other";
        }

        this.type = type;
    }
}
