package com.example.umc_mission_set.service.storeService;


import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.domain.Store;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);

}
