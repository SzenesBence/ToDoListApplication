package hu.nye.spring.core.controller;

import hu.nye.spring.core.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionHanderController {
    @ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "User not found in our database.")
    @ExceptionHandler(UserNotFoundException.class)
    public void UserNotFoundExceptionHandler(){
    }
}

