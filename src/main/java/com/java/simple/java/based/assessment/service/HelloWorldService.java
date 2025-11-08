package com.java.simple.java.based.assessment.service;

import com.java.simple.java.based.assessment.common.CommonResponse;
import org.springframework.http.ResponseEntity;

public interface HelloWorldService {
    /**
     * This method get name If the first letter of the name parameter is in the first half of the English alphabet (A–M or a–m)
     * @param name required variable to get expected outcome
     * @return A {@link ResponseEntity} with a {@link CommonResponse} and status of the operation.
     */
    CommonResponse getGreetingForFirstHalfOfAlphabet(String name);
}
