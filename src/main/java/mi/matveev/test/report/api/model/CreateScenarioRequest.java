package mi.matveev.test.report.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScenarioRequest {
    private String name;
    private String tags;
    private String path;

    public CreateScenarioRequest(String name, String tags, String path) {
        this.name = name;
        this.tags = tags;
        this.path = path;
    }
}
