package ch.ipt.sbnextlevel.exception.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    String userMessage;
    String devMessage;
    HttpStatus httpStatus;

    public ErrorResponse(String userMessage, String devMessage, HttpStatus httpStatus) {
        this.userMessage = userMessage;
        this.devMessage = devMessage;
        this.httpStatus = httpStatus;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}