package com.example.umc_mission_set.validation.validator;

import com.example.umc_mission_set.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission_set.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
@Component
public class PageNegativeValidator implements ConstraintValidator<CheckPage, Integer> {


    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        boolean isValid = page >= 0;
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NEGATIVE_VALUE.toString()).addConstraintViolation();
        }

        return isValid;
    }

}

