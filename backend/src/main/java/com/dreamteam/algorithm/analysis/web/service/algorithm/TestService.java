package com.dreamteam.algorithm.analysis.web.service.algorithm;

import com.dreamteam.algorithm.analysis.model.dto.TestResultDto;
import com.dreamteam.algorithm.analysis.model.test.EncryptionTest;
import com.dreamteam.algorithm.analysis.model.test.Test;
import com.dreamteam.algorithm.analysis.web.service.algorithm.result.storage.ResultStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dreamteam.algorithm.analysis.config.GlobalStaticConstants.modelMapper;

@Service
@RequiredArgsConstructor
public class TestService {
    private final ExecutionService testService;
    private final ResultStorage resultStorage;

    public TestResultDto testAlgorithm(Test test) {
        var result = switch (test) {
            case EncryptionTest<?> t -> testService.testEncryption(t);
            default -> throw new IllegalStateException("Unexpected value: " + test);
        };
        return modelMapper.map(resultStorage.addResult(result), TestResultDto.class);
    }

    public TestResultDto getTestResultById(String id) {
        return modelMapper.map(resultStorage.getResultById(id), TestResultDto.class);
    }

    public List<TestResultDto> getTestResults() {
        return resultStorage.getResults().stream()
                .map(result -> modelMapper.map(result, TestResultDto.class))
                .toList();
    }
}
