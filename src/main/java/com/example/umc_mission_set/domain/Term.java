package com.example.umc_mission_set.domain;

import com.example.umc_mission_set.domain.common.BaseEntity;
import com.example.umc_mission_set.domain.enums.EssentialTerm;
import com.example.umc_mission_set.domain.mapping.memberTermAgree;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 100)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private EssentialTerm isEssential;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<memberTermAgree> termAgreeList = new ArrayList<>();
}
