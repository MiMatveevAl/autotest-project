package mi.matveev.test.report.module.collector;

import mi.matveev.test.report.module.api.service.RunService;

public class RunCollector {
    private static String runId;

    public static void init() {
        runId = RunService.createRun();
    }
}
