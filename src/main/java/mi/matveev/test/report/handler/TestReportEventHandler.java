package mi.matveev.test.report.handler;

public interface TestReportEventHandler<T> {
    void handle(T event);
}
