package com.example.umc_mission_set.web.dto.memberDTO;

import com.example.umc_mission_set.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class joinDto {
        @NotBlank
        String name;
        @NotNull
        String nickname;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 20)
        String address;
        @ExistCategories
        List<Long> selectFoodList;
    }
}
