package com.example.userservice.exception;
import com.example.userservice.ui.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerExceptionHandler {
    private final ErrorResponseModel errorResponseModel;

    @Autowired
    public UserControllerExceptionHandler(ErrorResponseModel errorResponseModel) {
        this.errorResponseModel = errorResponseModel;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(UserNotFoundException e)
    {
        errorResponseModel.setErrorMessage(e.getMessage());
        errorResponseModel.setErrorTime(System.currentTimeMillis());
        errorResponseModel.setErrorCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseModel> handleUserListEmptyException(EmptyListException e)
    {
        errorResponseModel.setErrorMessage(e.getMessage());
        errorResponseModel.setErrorTime(System.currentTimeMillis());
        errorResponseModel.setErrorCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);
    }
}