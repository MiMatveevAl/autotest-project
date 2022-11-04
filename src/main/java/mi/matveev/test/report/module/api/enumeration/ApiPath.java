package mi.matveev.test.report.module.api.enumeration;

public enum ApiPath {
    CREATE_RUN("/run");

    public final String path;

    ApiPath(String path) {
        this.path = path;
    }
}
