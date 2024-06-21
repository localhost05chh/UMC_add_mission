package com.example.umc_mission_set.repository;

import com.example.umc_mission_set.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
