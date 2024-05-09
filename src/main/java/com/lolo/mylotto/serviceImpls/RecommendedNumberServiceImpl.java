package com.lolo.mylotto.serviceImpls;

import com.lolo.mylotto.dto.requests.RecommendedNumberReqDTO;
import com.lolo.mylotto.dto.responses.RecommendedNumberResDTO;
import com.lolo.mylotto.services.RecommendedNumberService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

//@RequiredArgsConstructor
@Service
public class RecommendedNumberServiceImpl implements RecommendedNumberService {
    private static Integer LOTTO_LENGTH = 6;
    private static Integer LOTTO_MAX_NUMBER = 45;

    @Override
    public List<RecommendedNumberResDTO> recommendedNumbers(
            RecommendedNumberReqDTO recommendedNumberReqDTO) {
        Set<RecommendedNumberResDTO> recommendedNumberResDTOList = new HashSet<>();
        Random random = new Random();

        while (recommendedNumberResDTOList.size() < recommendedNumberReqDTO.getCount()) {
            Set<Integer> lotto = new HashSet<>();

            while (lotto.size() < LOTTO_LENGTH) {
                int randomNumber = random.nextInt(LOTTO_MAX_NUMBER) + 1;
                lotto.add(randomNumber);
            }
            RecommendedNumberResDTO recommendedNumberResDTO = RecommendedNumberResDTO.builder()
                                                                                    .numbers(lotto.stream()
                                                                                            .sorted()
                                                                                            .toList())
                                                                                    .build();
            recommendedNumberResDTOList.add(recommendedNumberResDTO);
        }

        AtomicInteger no = new AtomicInteger(1);
        List<RecommendedNumberResDTO> resultList = recommendedNumberResDTOList.stream().toList();
        resultList.forEach(x -> x.setNo(no.getAndIncrement()));
        return resultList;
    }
}
