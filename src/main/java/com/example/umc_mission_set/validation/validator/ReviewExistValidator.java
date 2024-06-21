package com.example.umc_mission_set.validation.validator;

import com.example.umc_mission_set.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.service.memberService.MemberQueryService;
import com.example.umc_mission_set.validation.annotation.ExistReview;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewExistValidator implements ConstraintValidator<ExistReview, Long> {

    private final MemberQueryService memberQueryService;

    @Override
    public void initialize(ExistReview constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Review> target = memberQueryService.findReview(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}