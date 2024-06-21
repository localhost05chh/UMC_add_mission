package com.example.umc_mission_set.service.memberService;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import com.example.umc_mission_set.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.joinDto request);

    memberSelectMission selectMission(Long missionId, Long memberId);

    void changeMissionStatus(Long memberId, Long missionId);
}
