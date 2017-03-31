package fitness.backend.utils.validation.general;

import java.lang.annotation.*;

@Target( {ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckAtLeastOneNotNullValidator.class)
@Documented
public @interface CheckAtLeastOneNotNull {

    String message() default "At least one of the";

    String[] fieldNames();



    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}