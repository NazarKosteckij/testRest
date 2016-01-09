package integration;

import com.test.rest.models.JobModel;
import com.test.rest.models.enums.device.UpdateFrequency;
import com.test.rest.services.devices.JobService;
import org.hibernate.bytecode.buildtime.ExecutionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Nazar on 09.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:JobServiceTest-context.xml")
public class JobServiceImplTest {

    @Autowired
    JobService jobService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testContext() throws Exception {
        if (jobService == null)
            throw new ExecutionException("job service empty");

    }

    @Test
    public void testAdding() throws Exception {
        JobModel jobModel = new JobModel();
        jobModel.setName("test");
        //jobModel.setLastExecution(new Date(Calendar.getInstance().getTime().getTime()));
        jobModel.setFrequency(UpdateFrequency.FIFTEEN_MINUTES);
        jobService.create(jobModel);

    }
}