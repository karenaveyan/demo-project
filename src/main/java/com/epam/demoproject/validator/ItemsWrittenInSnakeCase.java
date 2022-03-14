package com.epam.demoproject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = ItemConstraintValidator.class)
@Target({ FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemsWrittenInSnakeCase {
    String message() default "Items must be written in snake_case.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
