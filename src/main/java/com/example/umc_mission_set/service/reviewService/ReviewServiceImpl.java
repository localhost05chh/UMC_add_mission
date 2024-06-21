package com.example.umc_mission_set.service.reviewService;

import com.example.umc_mission_set.converter.StoreConverter;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.repository.MemberRepository;
import com.example.umc_mission_set.repository.ReviewRepository;
import com.example.umc_mission_set.repository.StoreRepository;
import com.example.umc_mission_set.web.dto.reviewDTO.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.joinDto request, Long memberId, Long storeId) {


        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}
