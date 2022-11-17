package mi.matveev.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CommonSteps {
    @And("^Log - '(.+)'$")
    public void logIt(String text) {
        log.info(text);
    }

    @And("^Log map - '(.+)':$")
    public void logIts(String text, Map<String, String> params) {
        log.info(text);
        params.forEach((key, value) -> log.info("key - {}, value - {}", key, value));
    }

    @And("^Log dataTable - '(.+)':$")
    public void logIns2(String text, DataTable table) {
        log.info(text);
    }
}
