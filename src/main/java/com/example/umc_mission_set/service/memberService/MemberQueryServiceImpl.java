package com.example.umc_mission_set.service.memberService;

import com.example.umc_mission_set.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission_set.apiPayload.exception.GeneralException;
import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.domain.enums.MissionStatus;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import com.example.umc_mission_set.repository.MemberRepository;
import com.example.umc_mission_set.repository.ReviewRepository;
import com.example.umc_mission_set.repository.SelectMissionRepository;
import com.example.umc_mission_set.service.memberService.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final SelectMissionRepository selectMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return reviewPage;
    }

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findAllByMember(memberRepository.findById(id));
    }

    @Override
    public Page<memberSelectMission> getMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Page<memberSelectMission> missionPage = selectMissionRepository.findAllByMemberAndStatus(member, MissionStatus.PROGRESS, PageRequest.of(page, 10));

        return missionPage;
    }

    @Override
    public Optional<memberSelectMission> findMission(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return selectMissionRepository.findAllByMember(member);
    }


}