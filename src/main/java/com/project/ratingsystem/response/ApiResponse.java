package com.project.ratingsystem.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    public T data;
    private String message;
    private boolean success;


    public ApiResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
}
