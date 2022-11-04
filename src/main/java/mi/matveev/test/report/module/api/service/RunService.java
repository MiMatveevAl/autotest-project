package mi.matveev.test.report.module.api.service;

import io.cucumber.junit.CucumberOptions;
import mi.matveev.test.report.module.api.enumeration.ApiPath;
import mi.matveev.test.report.module.config.ReportConfig;

import java.util.Map;

public class RunService extends AbstractService {
    public static String createRun() {
        String tags;
        try {
            tags = Class.forName(ReportConfig.runClass()).getDeclaredAnnotationsByType(CucumberOptions.class)[0].tags();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Map<String, String> body = Map.of(
                "name", ReportConfig.runName(),
                "tags", tags,
                "project", ReportConfig.project() != null ? ReportConfig.project() : ""
        );

        return post(ApiPath.CREATE_RUN, body);
    }
}
