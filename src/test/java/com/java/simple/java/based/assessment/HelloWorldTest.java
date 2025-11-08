package com.java.simple.java.based.assessment;

import com.java.simple.java.based.assessment.common.CommonConstants;
import com.java.simple.java.based.assessment.common.CommonResponse;
import com.java.simple.java.based.assessment.controller.HelloWorldController;
import com.java.simple.java.based.assessment.dto.ErrorResponse;
import com.java.simple.java.based.assessment.dto.MessageResponse;
import com.java.simple.java.based.assessment.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class HelloWorldTest {

    @InjectMocks
    private HelloWorldController helloWorldController;

    @Mock
    private HelloWorldService helloWorldService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    /**
     * Test case for valid name input, where the first letter is in the first half of the alphabet (A-M or a-m).
     * Expected Behavior:
     * - The API should return HTTP 200 OK.
     * @author aathif thahir
     */
    @Test
    void shouldReturnOk_WhenNameStartsWithAtoM() throws Exception {
        // Given
        String name = "Alice";

        // Mock the calls
        when(helloWorldService.getGreetingForFirstHalfOfAlphabet(name))
                .thenReturn(new CommonResponse(HttpStatus.OK, new MessageResponse("Hello " + name)));

        // Act
        ResultActions resultActions = mockMvc.perform(get(CommonConstants.END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name));

        // Assert
        resultActions.andExpect(status().isOk());
    }

    /**
     * Test case for invalid name input, where the first letter is in the second half of the alphabet (N-Z or n-z).
     * Expected Behavior:
     * - The API should return HTTP 400 Bad Request.
     * @author aathif thahir
     */
    @Test
    void shouldReturnBadRequest_WhenNameStartsWithNtoZ() throws Exception {
        // Given
        String name = "zebra";

        // Mock the calls
        when(helloWorldService.getGreetingForFirstHalfOfAlphabet(name))
                .thenReturn(new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input")));

        // Act
        ResultActions resultActions = mockMvc.perform(get(CommonConstants.END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name));

        // Assert
        resultActions.andExpect(status().isBadRequest());
    }

    /**
     * Test case for empty name input.
     * Expected Behavior:
     * - The name parameter is empty.
     * - The API should return HTTP 400 Bad Request.
     * @author aathif thahir
     */
    @Test
    void shouldReturnBadRequest_WhenNameIsEmpty() throws Exception {
        // Given
        String name = "";

        // Mock the calls
        when(helloWorldService.getGreetingForFirstHalfOfAlphabet(name))
                .thenReturn(new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input")));

        // Act
        ResultActions resultActions = mockMvc.perform(get(CommonConstants.END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name));

        // Assert
        resultActions.andExpect(status().isBadRequest());
    }


    /**
     * Test case for null name input.
     * Expected Behavior:
     * - The name parameter is null.
     * - The API should return HTTP 400 Bad Request.
     * @author aathif thahir
     */
    @Test
    void shouldReturnBadRequest_WhenNameIsNull() throws Exception {
        // Given
        String name = null;

        // Mock the calls
        when(helloWorldService.getGreetingForFirstHalfOfAlphabet(name))
                .thenReturn(new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input")));

        // Act
        ResultActions resultActions = mockMvc.perform(get(CommonConstants.END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name));

        // Assert
        resultActions.andExpect(status().isBadRequest());
    }

    /**
     * Test case for special character name input.
     * Expected Behavior:
     * - The name parameter is null.
     * - The API should return HTTP 400 Bad Request.
     * @author aathif thahir
     */
    @Test
    void shouldReturnBadRequest_WhenNameStartsWithSpecialCharacter() throws Exception {
        // Given
        String name = "@Hello";

        // Mock the calls
        when(helloWorldService.getGreetingForFirstHalfOfAlphabet(name))
                .thenReturn(new CommonResponse(HttpStatus.BAD_REQUEST, new ErrorResponse("Invalid Input")));

        // Act
        ResultActions resultActions = mockMvc.perform(get(CommonConstants.END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", name));

        // Assert
        resultActions.andExpect(status().isBadRequest());
    }

}
