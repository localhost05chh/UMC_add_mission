package com.example.umc_mission_set.repository;

import com.example.umc_mission_set.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
