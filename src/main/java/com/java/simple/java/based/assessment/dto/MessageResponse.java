package com.java.simple.java.based.assessment.dto;

/**
 * This class represents a response containing a message.
 * The {@code message} field contains the message that will be sent as part of the response.

 * @author Aathif Thahir
 */
public class MessageResponse {
    private String message;

    /**
     * Constructs a MessageResponse with the specified message.
     *
     * @param message The message to be returned in the response.
     */
    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
