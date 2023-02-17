package com.viettelpost.scrape.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {
    int status;
    boolean error;
    String message;
    Object data;
    Object data2;
    List<String> messages;

    public BaseResponse(HttpStatus status) {
        this.status = status.value();
    }

    public BaseResponse(HttpStatus status, boolean error, String message) {
        this.status = status.value();
        this.error = error;
        this.message = message;
    }

    public BaseResponse(int status, boolean error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public BaseResponse(int status, boolean error, String message, Object data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int status, boolean error, List<String> messages, Object data) {
        this.status = status;
        this.error = error;
        this.messages = messages;
        this.data = data;
    }

    public BaseResponse() {
        message = "";
        error = false;
        status = 200;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}

