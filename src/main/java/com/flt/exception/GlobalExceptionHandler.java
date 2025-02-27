package com.flt.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public String handleCustomException(CustomException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
