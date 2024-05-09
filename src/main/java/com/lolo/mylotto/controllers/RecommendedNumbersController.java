package com.lolo.mylotto.controllers;

import com.lolo.mylotto.dto.requests.RecommendedNumberReqDTO;
import com.lolo.mylotto.dto.responses.RecommendedNumberResDTO;
import com.lolo.mylotto.services.RecommendedNumberService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/recommend") // TODO api를 전역으로 빼기
public class RecommendedNumbersController {
    private final RecommendedNumberService recommendedNumberService;

    @GetMapping("/numbers")
    public List<RecommendedNumberResDTO> getRecommendedNumber(
            @Validated RecommendedNumberReqDTO recommendedNumberReqDTO) {

        return recommendedNumberService.recommendedNumbers(recommendedNumberReqDTO);
    };
}
