package mi.matveev.test.report.module;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import mi.matveev.test.report.module.collector.RunCollector;
import mi.matveev.test.report.module.config.ReportConfig;

public class TestReport implements EventListener {
    public TestReport() {
        ReportConfig.init();
        if (ReportConfig.isConfigured()) {
            RunCollector.init();
        }
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        if (!ReportConfig.isConfigured()) {
            return;
        }
    }
}
