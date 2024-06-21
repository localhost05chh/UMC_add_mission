package com.example.umc_mission_set.web.dto.missionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDTO{
        @NotNull
        String name;
        @NotNull
        Integer point;
        @NotNull
        LocalDateTime deadline;
    }
}
