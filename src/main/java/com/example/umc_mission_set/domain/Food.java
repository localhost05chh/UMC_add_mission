package com.example.umc_mission_set.domain;

import com.example.umc_mission_set.domain.mapping.memberSelectFood;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<memberSelectFood> memberSelectFoodList = new ArrayList<>();
}
