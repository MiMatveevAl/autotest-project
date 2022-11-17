package mi.matveev.test.report.api.client;

import mi.matveev.test.report.api.model.CreateRunRequest;
import mi.matveev.test.report.api.model.CreateScenarioRequest;
import mi.matveev.test.report.api.model.CreateStepRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TestReportClient {
    @POST("/run")
    Call<String> createRun(@Body CreateRunRequest body);

    @PUT("/run/{runId}")
    Call<Void> finishRun(@Path("runId") String runId, @Query("status") String status);

    @POST("/scenario")
    Call<String> createScenario(@Query("runId") String runId, @Body CreateScenarioRequest body);

    @PUT("/scenario/{scenarioId}")
    Call<Void> finishScenario(@Path("scenarioId") String scenarioId, @Query("status") String status);


    @POST("/step")
    Call<String> createStep(@Query("scenarioId") String scenarioId, @Body CreateStepRequest body);

    @PUT("/step/{stepId}")
    Call<Void> finishStep(@Path("stepId") String stepId, @Query("status") String status);
}
