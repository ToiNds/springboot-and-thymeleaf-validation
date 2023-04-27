package com.toindph26899.springbootandthymeleaf.validation;

import com.toindph26899.springbootandthymeleaf.validation.impl.PriceValidationConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PriceValidationConstraint.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceValidation {

    String message() default "Sell price khong duoc nho hon Origin price";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
