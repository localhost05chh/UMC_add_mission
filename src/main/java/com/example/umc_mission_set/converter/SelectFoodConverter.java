package com.example.umc_mission_set.converter;

import com.example.umc_mission_set.domain.Food;
import com.example.umc_mission_set.domain.mapping.memberSelectFood;
import java.util.List;
import java.util.stream.Collectors;

public class SelectFoodConverter {


    public static List<memberSelectFood> toSelectFoodList(List<Food> foodList) {

        return foodList.stream()
                .map(food ->
                        memberSelectFood.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}
