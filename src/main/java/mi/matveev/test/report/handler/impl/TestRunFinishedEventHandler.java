package mi.matveev.test.report.handler.impl;

import io.cucumber.plugin.event.TestRunFinished;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.handler.TestReportEventHandler;

public class TestRunFinishedEventHandler implements TestReportEventHandler<TestRunFinished> {
    @Override
    public void handle(TestRunFinished event) {
        String runId = TestReportInfoCollector.getRunId();
        String status = event.getResult().getStatus().name();

        TestReportServiceClient.finishRun(runId, status);
    }
}
