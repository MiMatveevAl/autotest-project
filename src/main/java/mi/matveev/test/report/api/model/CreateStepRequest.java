package mi.matveev.test.report.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStepRequest {
    private String name;
    private String argument;
    private String type;

    public CreateStepRequest(String name, String argument, String type) {
        this.name = name;
        this.argument = argument;
        this.type = type;
    }
}
