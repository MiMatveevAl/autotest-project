package mi.matveev.test.report.handler.impl;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.plugin.event.TestRunStarted;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.api.model.CreateRunRequest;
import mi.matveev.test.report.config.TestReportConfig;
import mi.matveev.test.report.handler.TestReportEventHandler;

public class TestRunStartedEventHandler implements TestReportEventHandler<TestRunStarted> {
    @Override
    public void handle(TestRunStarted event) {
        String tags = null;
        try {
            tags = Class.forName(TestReportConfig.getRunClass()).getDeclaredAnnotation(CucumberOptions.class).tags();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        CreateRunRequest run = new CreateRunRequest(
                TestReportConfig.getRunName(),
                tags,
                TestReportConfig.getRunProject()
        );

        String runId = TestReportServiceClient.createRun(run);
        TestReportInfoCollector.setRunId(runId);
        System.out.println("Test report: Created run with id - " + runId);
    }
}
