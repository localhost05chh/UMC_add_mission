package com.example.umc_mission_set.apiPayload.exception.handler;

import com.example.umc_mission_set.apiPayload.code.BaseErrorCode;
import com.example.umc_mission_set.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
