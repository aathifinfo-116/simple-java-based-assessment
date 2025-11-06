package com.java.simple.java.based.assessment.dto;

/**
 * This class represents a response containing an error message.
 * It includes a field for any invalid input returned when a request fails due to invalid input or other errors.
 * The {@code error} field contains the error message that explains the cause of the failure.
 *
 * @author Aathif Thahir
 */
public class ErrorResponse {
    private String error;

    /**
     * Constructs an ErrorResponse with the specified error data.
     *
     * @param error The data to be returned in the response.
     */
    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                '}';
    }
}
