package com.example.umc_mission_set.web.dto.reviewDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class joinDto {
        @NotNull
        String body;
        @NotNull
        Float rating;
    }
}
