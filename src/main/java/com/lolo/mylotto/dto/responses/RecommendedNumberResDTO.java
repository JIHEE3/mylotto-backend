package com.lolo.mylotto.dto.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecommendedNumberResDTO {
    private int no;
    private List<Integer> numbers;
}
