package com.example.umc_mission_set.web.controller;

import com.example.umc_mission_set.converter.MissionConverter;
import com.example.umc_mission_set.converter.StoreConverter;
import com.example.umc_mission_set.domain.Mission;
import com.example.umc_mission_set.domain.Store;
import com.example.umc_mission_set.service.storeService.StoreCommandService;
import com.example.umc_mission_set.service.storeService.StoreQueryService;
import com.example.umc_mission_set.validation.annotation.CheckPage;
import com.example.umc_mission_set.validation.annotation.ExistStore;
import com.example.umc_mission_set.web.dto.missionDTO.MissionRequestDTO;
import com.example.umc_mission_set.web.dto.missionDTO.MissionResponseDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreRequestDTO;
import com.example.umc_mission_set.web.dto.storeDTO.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.joinDto request) {
        Store newStore = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.joinResultDTO(newStore));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.ResultDTO> joinMission(@RequestBody @Valid MissionRequestDTO.JoinDTO request, @PathVariable Long storeId) {
        Mission newMission = storeCommandService.joinMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(newMission));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId , @CheckPage @RequestParam(name = "page") Integer page) {
        storeQueryService.getReviewList(storeId, page);
        return null;
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page) {
        storeQueryService.getMissionList(storeId, page);
        return null;
    }
}
