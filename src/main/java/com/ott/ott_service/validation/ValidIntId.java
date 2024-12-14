package com.ott.ott_service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@Min(value = 1, message = "ID must be greater than or equal to 1.")
@Max(value = Integer.MAX_VALUE, message = "ID must be less than or equal to the maximum int value.")
public @interface ValidIntId {
    String message() default "Invalid ID value.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
