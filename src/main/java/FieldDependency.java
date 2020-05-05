import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldDependencyValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldDependency {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    String dependentField();

    String dependentFieldExpectedValue();

    String message() default "Dependency does not match";

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldDependency[] value();
    }

}
