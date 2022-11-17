package mi.matveev.test.report.handler.impl;

import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseStarted;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.api.model.CreateScenarioRequest;
import mi.matveev.test.report.handler.TestReportEventHandler;

public class TestCaseStartedEventHandler implements TestReportEventHandler<TestCaseStarted> {
    @Override
    public void handle(TestCaseStarted event) {
        TestCase testCase = event.getTestCase();

        String runId = TestReportInfoCollector.getRunId();
        CreateScenarioRequest scenario = new CreateScenarioRequest(
                testCase.getName(),
                String.join(",", testCase.getTags()),
                testCase.getUri().toString()
        );

        String scenarioId = TestReportServiceClient.createScenario(runId, scenario);
        TestReportInfoCollector.setScenarioId(scenarioId);
    }
}
