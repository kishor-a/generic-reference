import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class FieldDependencyValidator implements ConstraintValidator<FieldDependency, Object> {

    private String field;
    private String dependentField;
    private String dependentFieldExpectedValue;

    @Override
    public void initialize(FieldDependency constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.dependentField = constraintAnnotation.dependentField();
        this.dependentFieldExpectedValue = constraintAnnotation.dependentFieldExpectedValue();

    }

    @SneakyThrows
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Class<?> clazz = object.getClass();

        Field fieldField = clazz.getDeclaredField(field);
        fieldField.setAccessible(true);
        Object fieldValue = fieldField.get(object);

        Field dependentFieldField = clazz.getDeclaredField(dependentField);
        dependentFieldField.setAccessible(true);
        Object dependentFieldValue = dependentFieldField.get(object);

        if(dependentFieldExpectedValue.equals(dependentFieldValue)){
            return fieldValue != null;
        }
        return true;
    }
}
