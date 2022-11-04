package mi.matveev.test.report.module.api.enumeration;

public enum ConfigVariable {
    CONFIG_NAME("test-report.properties"),

    URL("url"),
    RUN_NAME("run.name");

    public final String value;

    ConfigVariable(String value) {
        this.value = value;
    }
}
