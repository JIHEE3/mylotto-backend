package com.lolo.mylotto.dto.requests;

import jakarta.validation.constraints.Max;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendedNumberReqDTO {
    @Max(value = 10)
    @Builder.Default
    private Integer count = 1;
}
