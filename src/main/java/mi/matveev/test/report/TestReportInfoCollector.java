package mi.matveev.test.report;

public class TestReportInfoCollector {
    private static String currentRunId;
    private static final ThreadLocal<String> currentScenarioId;
    private static final ThreadLocal<String> currentStepId;

    static {
        currentScenarioId = new ThreadLocal<>();
        currentStepId = new ThreadLocal<>();
    }

    public static synchronized void setRunId(String runId) {
        currentRunId = runId;
    }

    public static synchronized String getRunId() {
        return currentRunId;
    }

    public static void setScenarioId(String scenarioId) {
        currentScenarioId.set(scenarioId);
    }

    public static String getScenarioId() {
        return currentScenarioId.get();
    }

    public static void setStepId(String stepId) {
        currentStepId.set(stepId);
    }

    public static String getStepId() {
        return currentStepId.get();
    }
}
