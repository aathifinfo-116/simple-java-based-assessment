package com.java.simple.java.based.assessment.service.impl;

import com.java.simple.java.based.assessment.common.CommonResponse;
import com.java.simple.java.based.assessment.dto.ErrorResponse;
import com.java.simple.java.based.assessment.dto.MessageResponse;
import com.java.simple.java.based.assessment.service.HelloWorldService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public CommonResponse getGreetingForFirstHalfOfAlphabet(String name) {
        // Check null or empty name input
        if (name == null || name.isEmpty()) {
            return new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input"));
        }
        char firstLetter = name.trim().toLowerCase().charAt(0);
            // Check valid name input, where the first letter is in the first half of the alphabet (A-M or a-m)
        if (firstLetter >= 'a' && firstLetter <= 'm') {
            return new CommonResponse(HttpStatus.OK, new MessageResponse("Hello " + name));
        } else {
            return new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input"));
        }
    }
}
