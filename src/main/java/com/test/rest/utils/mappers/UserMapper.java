package com.test.rest.utils.mappers;

import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;

import java.util.List;

/**
 * Created by nkostets on 9/14/2015.
 */
public interface UserMapper extends Mapper<UserDto, UserModel>{
    public UserModel createUserFromDto(UserDto user);
    public UserDto userToDto(UserModel user);
    public List<UserModel> dtoListToUserList(List<UserDto> users);
    public List<UserDto> userListToDtoList(List<UserModel> users);
}
