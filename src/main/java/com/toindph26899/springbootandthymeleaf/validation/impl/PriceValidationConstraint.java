package com.toindph26899.springbootandthymeleaf.validation.impl;

import com.toindph26899.springbootandthymeleaf.entities.Product;
import com.toindph26899.springbootandthymeleaf.validation.PriceValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidationConstraint implements ConstraintValidator<PriceValidation, Object> {

    String message;

    @Override
    public void initialize(PriceValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Product product = (Product) value;
        Double sellPrice = product.getSellPrice();
        Double originPrice = product.getOriginPrice();

        if (sellPrice <= originPrice) {
            return false;
        } else {
            return true;
        }
    }
}
