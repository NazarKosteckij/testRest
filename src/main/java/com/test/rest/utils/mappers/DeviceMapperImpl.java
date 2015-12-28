package com.test.rest.utils.mappers;

import com.test.rest.dto.DeviceDto;
import com.test.rest.models.DeviceModel;

/**
 * Created by Nazar on 28.12.2015.
 */
public class DeviceMapperImpl extends AbstractMapper<DeviceDto, DeviceModel> implements DeviceMapper {

    @Override
    public DeviceDto businessObjFromDto(DeviceModel obj) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(obj.getId());
        deviceDto.setName(obj.getName());
        deviceDto.setLocationUrl(obj.getLocationUrl());
        deviceDto.setType(obj.getType());
        deviceDto.setAlive(obj.getIsAlive());
        deviceDto.setOwnerId(obj.getOwner().getId());
        return deviceDto;
    }

    @Override
    public DeviceModel businessObjToDto(DeviceDto obj) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setId(obj.getId());
        deviceModel.setName(obj.getName());
        deviceModel.setLocationUrl(obj.getLocationUrl());
        deviceModel.setType(obj.getType());
        deviceModel.setIsAlive(obj.getAlive());
        return deviceModel;
    }
}
