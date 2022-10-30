package mi.matveev.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CucumberGlue {
    @Before
    public void testStarted() {
        log.info("TEST STARTED");
    }

    @After
    public void testFinished() {
        log.info("TEST FINISHED");
    }
}
