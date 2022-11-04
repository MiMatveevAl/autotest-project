package mi.matveev.test.report.module.api.service;

import mi.matveev.test.report.module.api.enumeration.ApiPath;
import mi.matveev.test.report.module.config.ReportConfig;

import java.util.Map;

public class RunService extends AbstractService {
    public static String createRun() {
        Map<String, String> body = Map.of(
                "name", ReportConfig.runName(),
                // TODO: добавить получение тэгов
                "tags", "@aaaaaaaaa"
        );

        return post(ApiPath.CREATE_RUN, body);
    }
}
