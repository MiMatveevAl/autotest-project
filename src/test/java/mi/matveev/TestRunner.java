package mi.matveev;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "pretty",
                "mi.matveev.test.report.module.TestReport"
        },
        glue = {
                "cucumber.api.spring",
                "mi.matveev.steps",
                "mi.matveev.glue"
        },
        tags = "@all"
)
public class TestRunner {
}
