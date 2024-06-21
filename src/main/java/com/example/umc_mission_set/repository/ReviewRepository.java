package com.example.umc_mission_set.repository;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Review;
import com.example.umc_mission_set.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Page<Review> findAllByMember(Member member, PageRequest pageRequest);

    Optional<Review> findAllByMember(Optional<Member> member);
}
