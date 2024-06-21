package com.example.umc_mission_set.converter;

import com.example.umc_mission_set.web.dto.tempDTO.TempResponseDTO;
public class TempConverter {

    public static TempResponseDTO.TempTestDTO toTempTestDTO() {
        return TempResponseDTO.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponseDTO.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponseDTO.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
