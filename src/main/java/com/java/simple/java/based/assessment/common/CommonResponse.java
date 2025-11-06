package com.java.simple.java.based.assessment.common;

import org.springframework.http.HttpStatus;

/**
 * This class represents a standard response structure for HTTP requests.
 * It includes fields for the HTTP status, and any data returned.
 * It is commonly used in REST APIs to provide a consistent response format.
 *
 * @author aathif thahir
 */
public class CommonResponse {
    private HttpStatus status;
    private Object data;

    public CommonResponse() {
    }

    /**
     * Constructs a CommonResponse with the specified status, message, and data.
     *
     * @param status The HTTP status code of the response.
     * @param data The data to be returned in the response.
     */
    public CommonResponse(HttpStatus status, Object data) {
        this.status = status;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}