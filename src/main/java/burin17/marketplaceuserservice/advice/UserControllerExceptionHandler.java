package burin17.marketplaceuserservice.advice;

import burin17.marketplaceuserservice.controller.UserController;
import burin17.marketplaceuserservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "burin17.marketplaceuserservice.controller",
        basePackageClasses = UserController.class)
public class UserControllerExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundExceptionHandler(UserNotFoundException exception) {
        return exception.getMessage();
    }
}
