package com.test.rest.utils.mappers;

import com.test.rest.dto.BaseDto;
import com.test.rest.models.BaseModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class for easier mapping of {@link BaseDto} and {@link BaseModel}
 * Define mapping of all field single objects
 * Created by Nazar on 28.12.2015.
 */
public abstract class AbstractMapper<DTO extends BaseDto, BO extends BaseModel> implements Mapper <DTO, BO> {
    /**
     * Converts {@link DTO} to {@link BO}
     * @param bo {@link BO}
     * @return {@link DTO}
     */
    @Override
    public abstract DTO businessObjFromDto(BO bo);

    /**
     * Converts {@link DTO} to {@link BO}
     * @param dto {@link DTO}
     * @return {@link BO}
     */
    @Override
    public abstract BO businessObjToDto(DTO dto);

    /**
     * Converts list of {@link DTO} to {@link BO}
     * @param boList  list of {@link BO}
     * @return list of {@link DTO}
     */
    @Override
    public List<DTO> businessObjListToDtoList(List<BO> boList) {
        List<DTO> dtoList = new LinkedList<DTO>();
        for (BO bo: boList){
            dtoList.add(this.businessObjFromDto(bo));
        }
        return dtoList;
    }

    /**
     * Converts list of {@link DTO} to {@link BO}
     * @param dtoList list of {@link DTO}
     * @return list of {@link BO}
     */
    @Override
    public List<BO> dtoListToBusinessObjList(List<DTO> dtoList) {
        List<BO> boList = new LinkedList<BO>();
        for (DTO dto: dtoList){
            boList.add(this.businessObjToDto(dto));
        }
        return boList;
    }
}

