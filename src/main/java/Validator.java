import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class Validator {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user());

        violations.forEach(x-> System.out.println(x.getPropertyPath().toString() +" : "+x.getMessage()));
    }
    private static User user(){
        return User.builder()
                //.name("Rthgt")
                .age(12)
                .pin("500")
                .address("Wirt fleeb, Grouw")
                .hobbies(Arrays.asList("",""))
                .profession(Profession.ENGINEER.toString())
                .build();
    }
}
