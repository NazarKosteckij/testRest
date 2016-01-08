package com.test.rest.services.devices;

import com.test.rest.dao.DeviceDao;
import com.test.rest.models.DeviceModel;
import com.test.rest.services.ServiceObserver;
import com.test.rest.services.observers.DeviceObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Nazar on 07.01.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DeviceService.class)
public class DeviceServiceTest {
    @Mock
    DeviceService deviceService;

    @Mock
    DeviceDao deviceDao;

    @Before
    public void setUp() throws Exception {
        deviceService.deviceDao = deviceDao;
        deviceService.serviceObservers = new ArrayList<ServiceObserver>();
        deviceService.serviceObservers.add(new DeviceObserver());

        doNothing().when(deviceDao).update(any(DeviceModel.class));
        doCallRealMethod().when(deviceService).update(any(DeviceModel.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateMethodException() throws Exception {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setId(0);
        deviceService.update(deviceModel);
    }

    @Test
    public void testUpdate() throws Exception {
        doCallRealMethod().when(deviceService).notifyObservers(any(DeviceModel.class));
        DeviceModel deviceModel = mock(DeviceModel.class);

        when(deviceModel.getId()).thenReturn(1);
        when(deviceModel.getIsAlive()).thenReturn(false).thenReturn(true);

        deviceService.update(deviceModel);
        deviceService.update(deviceModel);
    }
}