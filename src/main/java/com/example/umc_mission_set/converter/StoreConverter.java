package com.example.umc_mission_set.converter;

import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Region;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.domain.Store;
import com.example.umc_mission_set.web.dto.reviewDTO.ReviewRequestDTO;
import com.example.umc_mission_set.web.dto.reviewDTO.ReviewResponseDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreRequestDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreResponseDTO;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO joinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.joinDto request, Region region) {

        return Store.builder()
                .name(request.getName())
                .location(request.getLocation())
                .region(region)
                .build();
    }

    public static ReviewResponseDTO.ResultDTO ResultDTO(Review Review) {
        return ReviewResponseDTO.ResultDTO.builder()
                .reviewId(Review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.joinDto request) {

        return Review.builder()
                .body(request.getBody())
                .rating(request.getRating())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .storeName(mission.getStore().getName())
                .name(mission.getName())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
