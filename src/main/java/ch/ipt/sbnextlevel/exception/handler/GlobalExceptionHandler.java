package ch.ipt.sbnextlevel.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ch.ipt.sbnextlevel.exception.model.CustomerNotFoundException;
import ch.ipt.sbnextlevel.exception.model.ErrorResponse;
import ch.ipt.sbnextlevel.exception.model.InvalidQueryException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ InvalidQueryException.class })
    public ResponseEntity<ErrorResponse> handleInvalidQueryException(InvalidQueryException e) {
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ CustomerNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), HttpStatus.NOT_FOUND);
    }

}