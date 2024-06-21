package com.example.umc_mission_set.domain;

import com.example.umc_mission_set.domain.common.BaseEntity;
import com.example.umc_mission_set.domain.enums.NoticeType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Receive extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private NoticeType dType;

    private Boolean isReceive;
}
