package com.example.umc_mission_set.domain.mapping;

import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.common.BaseEntity;
import com.example.umc_mission_set.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class memberSelectMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'PROGRESS'")
    private MissionStatus status;

    private Integer missionNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
