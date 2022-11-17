package mi.matveev.test.report.handler.impl;

import io.cucumber.plugin.event.TestStepFinished;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.handler.TestReportEventHandler;

public class TestStepFinishedEventHandler implements TestReportEventHandler<TestStepFinished> {
    @Override
    public void handle(TestStepFinished event) {
        String stepId = TestReportInfoCollector.getStepId();
        String status = event.getResult().getStatus().name();

        TestReportServiceClient.finishStep(stepId, status);
    }
}
