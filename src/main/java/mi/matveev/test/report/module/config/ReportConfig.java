package mi.matveev.test.report.module.config;

import mi.matveev.test.report.module.api.enumeration.ConfigVariable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReportConfig {
    private static String url;
    private static String runName;
    private static String runClass;
    private static String project = null;

    public static void init() {
        try {
            Properties prop = new Properties();
            InputStream is = ReportConfig.class.getClassLoader().getResourceAsStream(ConfigVariable.CONFIG_NAME.value);
            prop.load(is);

            url = prop.getProperty(ConfigVariable.URL.value);
            runName = prop.getProperty(ConfigVariable.RUN_NAME.value);
            runClass = prop.getProperty(ConfigVariable.RUN_CLASS.value);
            project = prop.getProperty(ConfigVariable.PROJECT.value);
        } catch (IOException e) {
            url = null;
            runName = null;
            runClass = null;

            System.out.println("An error occurred while initializing the test report configuration");
            e.printStackTrace();
        }
    }

    public static boolean isConfigured() {
        return url != null && !url.isEmpty() &&
                runName != null && !runName.isEmpty() &&
                runClass != null && !runClass.isEmpty();
    }

    public static String url() {
        return url;
    }

    public static String runName() {
        return runName;
    }

    public static String runClass() {
        return runClass;
    }

    public static String project() {
        return project;
    }
}
