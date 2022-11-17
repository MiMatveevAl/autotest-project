package mi.matveev.test.report.handler.impl;

import io.cucumber.plugin.event.TestCaseFinished;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.handler.TestReportEventHandler;

public class TestCaseFinishedEventHandler implements TestReportEventHandler<TestCaseFinished> {
    @Override
    public void handle(TestCaseFinished event) {
        String scenarioId = TestReportInfoCollector.getScenarioId();
        String scenarioStatus = event.getResult().getStatus().name();

        TestReportServiceClient.finishScenario(scenarioId, scenarioStatus);
    }
}
