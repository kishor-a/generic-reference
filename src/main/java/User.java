import lombok.Builder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@FieldDependency.List({
        @FieldDependency(
                field = "school",
                dependentField = "profession",
                dependentFieldExpectedValue = "TEACHER",
                message = "school is mandatory for teacher"
        ),
        @FieldDependency(
                field = "computer",
                dependentField = "profession",
                dependentFieldExpectedValue = "ENGINEER",
                message = "computer is mandatory for engineer"
        )
})
@Builder
public class User {

    @NotNull
    private String name;
    private int age;
    @Size(min=3)
    private List<String> hobbies;
    private String pin;
    private String address;

    private String profession;
    private String school;
    private String computer;
}
