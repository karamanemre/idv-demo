package com.idv.demo.exception;

import com.idv.demo.models.dtos.ErrorMessage;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage handleNotFoundException(EntityNotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getReason());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorMessage handleAccessDeniedException(AccessDeniedException ex) {
        return new ErrorMessage(HttpStatus.FORBIDDEN.value(), ex.getReason());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorMessage handleBadRequestException(BadRequestException ex) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getReason());
    }


    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return validationErrors;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnexpectedException.class)
    public ErrorMessage handleUnexpectedException(UnexpectedException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getReason());
    }
}
