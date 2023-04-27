package com.toindph26899.springbootandthymeleaf.validation.impl;

import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.validation.PriceValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.lang.reflect.Field;

public class PriceValidationConstraint implements ConstraintValidator<PriceValidation, Double> {

    @Override
    public void initialize(PriceValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
//        if(value == null) {
//            return true;
//        }
//
//        ConstraintValidatorContextImpl constraintValidatorContext =
//                context.unwrap(ConstraintValidatorContextImpl.class);
//        ProductRequest productRequest =
//                (ProductRequest) constraintValidatorContext.getRootBean();
        return true;
    }
}
