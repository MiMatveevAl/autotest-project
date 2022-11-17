package mi.matveev.test.report.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRunRequest {
    private String name;
    private String tags;
    private String project;

    public CreateRunRequest(String name, String tags, String project) {
        this.name = name;
        this.tags = tags;
        this.project = project;
    }
}
