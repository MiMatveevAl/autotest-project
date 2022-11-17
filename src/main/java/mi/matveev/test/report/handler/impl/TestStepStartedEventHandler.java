package mi.matveev.test.report.handler.impl;

import io.cucumber.plugin.event.DataTableArgument;
import io.cucumber.plugin.event.HookTestStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.StepArgument;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.TestStepStarted;
import mi.matveev.test.report.TestReportInfoCollector;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.api.model.CreateStepRequest;
import mi.matveev.test.report.handler.TestReportEventHandler;

import java.util.List;
import java.util.stream.Collectors;

public class TestStepStartedEventHandler implements TestReportEventHandler<TestStepStarted> {
    @Override
    public void handle(TestStepStarted event) {
        TestStep testStep = event.getTestStep();

        CreateStepRequest step = isHook(testStep)
                ? fromHook((HookTestStep) testStep)
                : fromPickle((PickleStepTestStep) testStep);
        String scenarioId = TestReportInfoCollector.getScenarioId();

        String stepId = TestReportServiceClient.createStep(scenarioId, step);
        TestReportInfoCollector.setStepId(stepId);
    }

    private boolean isHook(TestStep step) {
        return step instanceof HookTestStep;
    }

    private CreateStepRequest fromHook(HookTestStep step) {
        return new CreateStepRequest(
                step.getHookType().name(),
                null,
                step.getHookType().name()
        );
    }

    private CreateStepRequest fromPickle(PickleStepTestStep step) {
        return new CreateStepRequest(
                step.getStep().getText(),
                argumentToString(step.getStep().getArgument()),
                "STEP"
        );
    }

    private String argumentToString(StepArgument argument) {
        if (argument == null) {
            return null;
        }
        List<String> lines = ((DataTableArgument) argument).cells()
                .stream()
                .map(line -> String.join(" | ", line))
                .collect(Collectors.toList());

        return String.join("\n", lines);
    }
}
