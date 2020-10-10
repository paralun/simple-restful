package com.paralun.app.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {

    private Validator validator;

    public ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object obj) {
        Set<ConstraintViolation<Object>> result = validator.validate(obj);
        if(result.size() != 0) {
            throw new ConstraintViolationException(result);
        }
    }
}
