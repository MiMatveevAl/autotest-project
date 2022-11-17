package mi.matveev.test.report;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;
import mi.matveev.test.report.api.client.TestReportServiceClient;
import mi.matveev.test.report.config.TestReportConfig;
import mi.matveev.test.report.handler.TestReportEventHandler;
import mi.matveev.test.report.handler.impl.TestCaseFinishedEventHandler;
import mi.matveev.test.report.handler.impl.TestCaseStartedEventHandler;
import mi.matveev.test.report.handler.impl.TestRunFinishedEventHandler;
import mi.matveev.test.report.handler.impl.TestRunStartedEventHandler;
import mi.matveev.test.report.handler.impl.TestStepFinishedEventHandler;
import mi.matveev.test.report.handler.impl.TestStepStartedEventHandler;

public class TestReport implements EventListener {
    private final TestReportEventHandler<TestRunStarted> testRunStartedHandler;
    private final TestReportEventHandler<TestRunFinished> testRunFinishedHandler;

    private final TestReportEventHandler<TestCaseStarted> testCaseStartedHandler;
    private final TestReportEventHandler<TestCaseFinished> testCaseFinishedHandler;

    private final TestReportEventHandler<TestStepStarted> testStepStartedHandler;
    private final TestReportEventHandler<TestStepFinished> testStepFinishedHandler;

    public TestReport() {
        this.testRunStartedHandler = new TestRunStartedEventHandler();
        this.testRunFinishedHandler = new TestRunFinishedEventHandler();

        this.testCaseStartedHandler = new TestCaseStartedEventHandler();
        this.testCaseFinishedHandler = new TestCaseFinishedEventHandler();

        this.testStepStartedHandler = new TestStepStartedEventHandler();
        this.testStepFinishedHandler = new TestStepFinishedEventHandler();
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        if (TestReportConfig.isConfigured()) {
            initClient();
            initHandlers(publisher);
        }
    }

    private void initClient() {
        TestReportServiceClient.init();
    }

    private void initHandlers(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, testRunStartedHandler::handle);
        publisher.registerHandlerFor(TestRunFinished.class, testRunFinishedHandler::handle);

        publisher.registerHandlerFor(TestCaseStarted.class, testCaseStartedHandler::handle);
        publisher.registerHandlerFor(TestCaseFinished.class, testCaseFinishedHandler::handle);

        publisher.registerHandlerFor(TestStepStarted.class, testStepStartedHandler::handle);
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinishedHandler::handle);
    }
}
