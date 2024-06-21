package com.example.umc_mission_set.service.reviewService;


import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.web.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewService {

    Review createReview(ReviewRequestDTO.joinDto request, Long memberId, Long storeId);
}
