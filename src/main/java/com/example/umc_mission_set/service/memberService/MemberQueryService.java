package com.example.umc_mission_set.service.memberService;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.domain.mapping.memberSelectMission;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);

    Optional<Review> findReview(Long id);

    Page<memberSelectMission> getMissionList(Long memberId, Integer page);

    Optional<memberSelectMission> findMission(Long id);
}
