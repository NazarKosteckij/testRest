package com.test.rest.services;

import com.test.rest.dao.UserDao;
import com.test.rest.services.users.UserService;
import com.test.rest.services.users.UserServiceImpl;
import com.test.rest.utils.StringUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by ����� on 20.12.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    UserServiceImpl userService;


    @Before
    public void setUp() throws Exception {
        Mockito.when(userService.getAll()).thenCallRealMethod();
    }

    @Test
    public void testGetUser() {
        assertTrue(true);
    }
}
