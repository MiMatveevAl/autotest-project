package mi.matveev.test.report.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mi.matveev.test.report.api.model.CreateRunRequest;
import mi.matveev.test.report.api.model.CreateScenarioRequest;
import mi.matveev.test.report.api.model.CreateStepRequest;
import mi.matveev.test.report.config.TestReportConfig;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.function.Supplier;

public class TestReportServiceClient {
    private static TestReportClient client;
    private static boolean configured = false;
    private static boolean ioError = false;

    public static synchronized void init() {
        if (!configured) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(TestReportConfig.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            client = retrofit.create(TestReportClient.class);
            configured = true;
        }
    }

    public static String createRun(CreateRunRequest body) {
        return send(() -> client.createRun(body));
    }

    public static void finishRun(String runId, String status) {
        send(() -> client.finishRun(runId, status));
    }


    public static String createScenario(String runId, CreateScenarioRequest body) {
        return send(() -> client.createScenario(runId, body));
    }

    public static void finishScenario(String scenarioId, String status) {
        send(() -> client.finishScenario(scenarioId, status));
    }


    public static String createStep(String scenarioId, CreateStepRequest body) {
        return send(() -> client.createStep(scenarioId, body));
    }

    public static void finishStep(String stepId, String status) {
        send(() -> client.finishStep(stepId, status));
    }


    private static <T> T send(Supplier<Call<T>> request) {
        if (!configured || ioError) {
            return null;
        }

        try {
            return request.get().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            ioError = true;
            return null;
        }
    }
}
