package com.java.simple.java.based.assessment.controller;

import com.java.simple.java.based.assessment.common.CommonResponse;
import com.java.simple.java.based.assessment.service.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWorldController {

    // Define service classes
    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    /**
     * This method get name If the first letter of the name parameter is in the first half of the English alphabet (A–M or a–m)
     * @param name required variable to get expected outcome
     * @return A {@link ResponseEntity} with a {@link CommonResponse} and status of the operation.
     */
    @GetMapping("/hello-world")
    public ResponseEntity<CommonResponse> getNameByFirstLetterName(@RequestParam(value = "name", required = false) String name) {
        CommonResponse response = helloWorldService.getGreetingForFirstHalfOfAlphabet(name);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
