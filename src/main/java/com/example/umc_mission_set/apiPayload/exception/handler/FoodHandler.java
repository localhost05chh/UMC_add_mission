package com.example.umc_mission_set.apiPayload.exception.handler;

import com.example.umc_mission_set.apiPayload.code.BaseErrorCode;
import com.example.umc_mission_set.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {

    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
