package com.example.umc_mission_set.converter;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.enums.Gender;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import com.example.umc_mission_set.web.dto.memberDTO.MemberRequestDTO;
import com.example.umc_mission_set.web.dto.memberDTO.MemberResponseDTO;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.joinDto request) {

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .nickname(request.getNickname())
                .memberSelectFoodList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(memberSelectMission selectMission) {
        Mission mission = selectMission.getMission();
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .memberName(selectMission.getMember().getNickname())
                .name(mission.getName())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<memberSelectMission> missionList) {
        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
