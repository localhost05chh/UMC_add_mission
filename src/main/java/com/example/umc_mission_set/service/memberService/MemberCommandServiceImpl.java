package com.example.umc_mission_set.service.memberService;

import com.example.umc_mission_set.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission_set.apiPayload.exception.GeneralException;
import com.example.umc_mission_set.apiPayload.exception.handler.FoodHandler;
import com.example.umc_mission_set.converter.MemberConverter;
import com.example.umc_mission_set.converter.MissionConverter;
import com.example.umc_mission_set.converter.SelectFoodConverter;
import com.example.umc_mission_set.domain.Food;
import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.enums.MissionStatus;
import com.example.umc_mission_set.domain.mapping.memberSelectFood;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import com.example.umc_mission_set.repository.FoodRepository;
import com.example.umc_mission_set.repository.MemberRepository;
import com.example.umc_mission_set.repository.MissionRepository;
import com.example.umc_mission_set.repository.SelectMissionRepository;
import com.example.umc_mission_set.web.dto.memberDTO.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodRepository foodRepository;

    private final MissionRepository missionRepository;

    private final SelectMissionRepository selectMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.joinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<Food> foodList = request.getSelectFoodList().stream()
                .map(food -> foodRepository.findById(food).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).collect(Collectors.toList());

        List<memberSelectFood> selectFoodList = SelectFoodConverter.toSelectFoodList(foodList);

        selectFoodList.forEach(selectFood -> {selectFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public memberSelectMission selectMission(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        memberSelectMission selectMission = MissionConverter.toMission(mission, member);

        return selectMissionRepository.save(selectMission);
    }

    @Override
    @Transactional
    public void changeMissionStatus(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        memberSelectMission selectMission = selectMissionRepository.findByMemberAndMission(member, mission);

        selectMission.setStatus(MissionStatus.SUCCESS);
        selectMissionRepository.save(selectMission);
    }
}
