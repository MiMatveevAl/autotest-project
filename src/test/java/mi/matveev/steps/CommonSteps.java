package mi.matveev.steps;

import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonSteps {
    @And("^Log - '(.+)'$")
    public void logIt(String text) {
        log.info(text);
    }
}
