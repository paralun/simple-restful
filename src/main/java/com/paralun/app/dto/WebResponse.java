package com.paralun.app.dto;

import lombok.Data;

@Data
public class WebResponse<T> {
    private int code;
    private String message;
    private T data;
}
