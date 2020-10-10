package com.paralun.app.controller;

import com.paralun.app.dto.WebResponse;
import com.paralun.app.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public WebResponse<String> validationHandler(ConstraintViolationException ex) {
        WebResponse<String> web = new WebResponse<>();
        web.setCode(400);
        web.setMessage("Bad Request");
        web.setData(ex.getMessage());

        return web;
    }

    @ExceptionHandler(value = NotFoundException.class)
    public WebResponse<String> notFoundHandler(NotFoundException ex) {
        WebResponse<String> web = new WebResponse<>();
        web.setCode(404);
        web.setMessage("Data not Found");
        web.setData("Not Found");

        return web;
    }
}
