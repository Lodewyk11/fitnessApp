package fitness.backend.utils.validation.general;

import java.lang.reflect.Field;

public class CheckAtLeastOneNotNullValidator implements ConstraintValidator<CheckAtLeastOneNotNull, Object> {

    private String[] fieldNames;

    public void initialize(CheckAtLeastOneNotNull constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
        if (object == null)
            return true;

        try {

            for (String fieldName : fieldNames) {
                Field field = object.getClass().getField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);

                if (fieldValue != null)
                    return true;
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

}
