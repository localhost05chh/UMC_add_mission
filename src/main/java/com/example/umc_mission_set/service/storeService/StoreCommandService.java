package com.example.umc_mission_set.service.storeService;

import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Store;
import com.example.umc_mission_set.web.dto.missionDTO.MissionRequestDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.joinDto request);

    Mission joinMission(MissionRequestDTO.JoinDTO request, Long storeId);
}
