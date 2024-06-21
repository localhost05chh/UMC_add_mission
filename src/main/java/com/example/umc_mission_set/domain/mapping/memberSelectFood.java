package com.example.umc_mission_set.domain.mapping;

import com.example.umc_mission_set.domain.Food;
import com.example.umc_mission_set.domain.Member;
import com.example.umc_mission_set.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class memberSelectFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setMember(Member member) {
        if (this.member != null) {
            member.getMemberSelectFoodList().remove(this);
        }
        this.member = member;
        member.getMemberSelectFoodList().add(this);
    }

    public void setFood(Food food) {
        this.food = food;
    }

}