package fitness.backend.utils.validation.idnumber;


import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdNumberValidator.class)
@Documented
public @interface SaIdNumber {

    String message() default "The provided ID is not a valid South African ID number.";



    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
