package com.example.umc_mission_set.repository;

import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

}
