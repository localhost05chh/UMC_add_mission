package com.example.umc_mission_set.repository;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.enums.MissionStatus;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SelectMissionRepository extends JpaRepository<memberSelectMission, Long> {

    Optional<memberSelectMission> findAllByMember(Optional<Member> member);

    Optional<memberSelectMission> findAllByStatus(MissionStatus status);

    Page<memberSelectMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

    memberSelectMission findByMemberAndMission(Member member, Mission mission);

}
