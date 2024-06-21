package com.example.umc_mission_set.service.storeService;

import com.example.umc_mission_set.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission_set.apiPayload.exception.GeneralException;
import com.example.umc_mission_set.converter.MissionConverter;
import com.example.umc_mission_set.converter.StoreConverter;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Region;
import com.example.umc_mission_set.domain.Store;
import com.example.umc_mission_set.repository.MissionRepository;
import com.example.umc_mission_set.repository.RegionRepository;
import com.example.umc_mission_set.repository.StoreRepository;
import com.example.umc_mission_set.web.dto.missionDTO.MissionRequestDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.joinDto request) {

        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDTO request, Long storeId) {

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);

        return missionRepository.save(mission);
    }
}
