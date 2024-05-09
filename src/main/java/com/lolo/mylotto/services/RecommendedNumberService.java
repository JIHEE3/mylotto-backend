package com.lolo.mylotto.services;

import com.lolo.mylotto.dto.requests.RecommendedNumberReqDTO;
import com.lolo.mylotto.dto.responses.RecommendedNumberResDTO;

import java.util.List;

public interface RecommendedNumberService {
    List<RecommendedNumberResDTO> recommendedNumbers(RecommendedNumberReqDTO recommendedNumberReqDTO); // TODO 로그인한 사용자 처리 하기 (reqDTO 만들어서 넘기는 걸로...?)
}
