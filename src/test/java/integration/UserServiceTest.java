package integration;

import com.test.rest.contstants.users.UserGender;
import com.test.rest.dto.UserDto;
import com.test.rest.services.users.UserService;
import com.test.rest.utils.MD5;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nazar on 20.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:UserServiceTest-context.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    UserDto userFromSqlScript;

    @Before
    public void setUp() throws Exception {
        userFromSqlScript = userService.getByEmail("silver_925@ukr.net");
    }

    @Test
     public void testContext() {
        assertNotNull(userService);
    }

    @Test
    public void testAddUser() {
        UserDto userDto = new UserDto();
        userDto.setLastName("as");
        userDto.setEmail("s12a@3sa.sa");
        userDto.setGender(UserGender.GENDER_FEMALE);
        userDto.setPassword(MD5.getMD5("pwd"));
        userService.addUser(userDto);
        UserDto userDtoOutput = userService.getByEmail(userDto.getEmail());

        assertEquals(userDto.hashCode(),userDtoOutput.hashCode());

        userService.deleteUser(userDtoOutput);
    }
}
