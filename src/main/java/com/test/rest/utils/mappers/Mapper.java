package com.test.rest.utils.mappers;

import com.test.rest.dto.BaseDto;
import com.test.rest.models.BaseModel;

import java.util.List;

/**
 * Created by Nazar on 28.12.2015.
 */
public interface Mapper<DTO extends BaseDto, BO extends BaseModel> {
    public DTO businessObjFromDto(BO bo);
    public BO businessObjToDto(DTO dto);
    public List<DTO> businessObjListToDtoList(List<BO> bo);
    public List<BO> dtoListToBusinessObjList(List<DTO> dto);

}
