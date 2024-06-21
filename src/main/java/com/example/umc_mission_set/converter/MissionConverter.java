package com.example.umc_mission_set.converter;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Store;
import com.example.umc_mission_set.domain.enums.MissionStatus;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import com.example.umc_mission_set.web.dto.missionDTO.MissionRequestDTO;
import com.example.umc_mission_set.web.dto.missionDTO.MissionResponseDTO;
import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.ResultDTO toResultDTO(Mission mission) {
        return MissionResponseDTO.ResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinDTO request, Store store){
        return Mission.builder()
                .name(request.getName())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.ResultDTO toResultDTO(memberSelectMission selectMission){
        return MissionResponseDTO.ResultDTO.builder()
                .missionId(selectMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //    Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)
    public static memberSelectMission toMission(Mission mission, Member member){
        return memberSelectMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.PROGRESS)
                .build();
    }

    public static memberSelectMission toChangeMissionStatus(memberSelectMission selectMission) {
        return memberSelectMission.builder()
                .member(selectMission.getMember())
                .mission(selectMission.getMission())
                .status(MissionStatus.SUCCESS)
                .build();
    }
}
