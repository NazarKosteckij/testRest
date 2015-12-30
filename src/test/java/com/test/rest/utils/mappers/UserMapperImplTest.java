package com.test.rest.utils.mappers;

import com.test.rest.contstants.users.UserGender;
import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;
import com.test.rest.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Назар on 26.12.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Mappers-test-context.xml")
public class UserMapperImplTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testUserToDto() throws Exception {
        UserModel userModel = getUser();
        UserDto userDto = userMapper.userToDto(userModel);
        this.assertUsersEquals(userDto,userModel);
    }

    @Test
    public void testCreateUserFromDto() throws Exception {
        UserDto userDto = getUserDto();
        UserModel userModel = userMapper.createUserFromDto(userDto);
        assertUsersEquals(userDto, userModel);
    }

    @Test
    public void testUserListToDtoList() throws Exception {
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        List<UserModel> userModelList;

        userDtoList.add(getUserDto());
        userDtoList.add(getUserDto());

        userModelList = userMapper.dtoListToUserList(userDtoList);

        assertEquals("size of arrays", userDtoList.size(), userModelList.size());

        for(int i = 0; i < userDtoList.size(); i++){
            assertUsersEquals(userDtoList.get(i), userModelList.get(i));
        }
    }

    @Test
    public void testDtoListToUserList() throws Exception {
        List<UserDto> userDtoList;
        List<UserModel> userModelList = new ArrayList<UserModel>();

        userModelList.add(getUser());
        userModelList.add(getUser());

        userDtoList = userMapper.businessObjListToDtoList(userModelList);

        assertEquals("size of arrays", userDtoList.size(), userModelList.size());

        for(int i = 0; i < userDtoList.size(); i++){
            assertUsersEquals(userDtoList.get(i), userModelList.get(i));
        }
    }

    private void assertUsersEquals(UserDto userDto, UserModel userModel){
        assertEquals("user email",userDto.getEmail(), userModel.getEmail());
        assertEquals("user name", userDto.getFirstName(), userModel.getFirstName());
        assertEquals("user last name", userDto.getLastName(), userModel.getLastName());
        assertEquals("user role", userDto.getRole(), userModel.getRole());
        assertEquals("user status", userDto.getStatus(), userModel.getStatus());
        assertEquals("user id", userDto.getId(), userModel.getId());
        assertEquals("user birth date", userDto.getBirthdate(), userModel.getBirthdate().toString());
    }

    private UserModel getUser(){
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setLastName("last-name");
        userModel.setFirstName("name");
        userModel.setEmail("email");
        userModel.setPhone("+3829588658");
        userModel.setGender(UserGender.GENDER_FEMALE);
        userModel.setPassword(MD5.getMD5("pwd"));
        userModel.setStatus(UserStatuses.STATUS_CONFIRMED);
        userModel.setBirthdate(new Date(2015-01-01));
        return userModel;
    }
    
    private UserDto getUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setLastName("last-name");
        userDto.setFirstName("name");
        userDto.setEmail("email");
        userDto.setPhone("+3829588658");
        userDto.setGender(UserGender.GENDER_FEMALE);
        userDto.setPassword(MD5.getMD5("pwd"));
        userDto.setStatus(UserStatuses.STATUS_CONFIRMED);
        userDto.setBirthdate("2015-01-01");
        return userDto;
    }
}