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
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Created by Nazar on 20.12.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetUser() {
        assertTrue(true);
    }
}
