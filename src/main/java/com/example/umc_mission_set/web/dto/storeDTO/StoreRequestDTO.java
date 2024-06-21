package com.example.umc_mission_set.web.dto.storeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class joinDto {
        @NotBlank
        String name;
        @NotNull
        String location;
        @NotNull
        Long regionId;
    }
}
