package mi.matveev.test.report.config;

import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestReportConfig {
    private static String baseUrl;
    private static String runName;
    private static String runClass;
    private static String runProject;

    static {
        try {
            Properties prop = new Properties();
            InputStream inputStream = TestReportConfig.class.getClassLoader()
                    .getResourceAsStream("test-report.properties");
            prop.load(inputStream);

            baseUrl = prop.getProperty("baseUrl");
            runName = prop.getProperty("run.name");
            runClass = prop.getProperty("run.class");
            runProject = prop.getProperty("run.project");
        } catch (IOException e) {
            baseUrl = null;
            runName = null;
            runClass = null;
            runProject = null;

            System.out.println("An error occurred while initializing the test report configuration");
            e.printStackTrace();
        }
    }

    public static boolean isConfigured() {
        return StringUtils.isNotBlank(baseUrl) &&
                StringUtils.isNotBlank(runName) &&
                StringUtils.isNotBlank(runClass) &&
                StringUtils.isNotBlank(runProject);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getRunName() {
        return runName;
    }

    public static String getRunClass() {
        return runClass;
    }

    public static String getRunProject() {
        return runProject;
    }
}
