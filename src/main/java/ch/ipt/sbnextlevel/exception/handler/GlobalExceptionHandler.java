package ch.ipt.sbnextlevel.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ch.ipt.sbnextlevel.exception.model.InvalidQueryException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    // public ResponseEntity<ErrorResponse>
    // handleInvalidQueryException(InvalidQueryException e) {
    public ResponseEntity<String> handleInvalidQueryException(InvalidQueryException e) {
        // return new ResponseEntity<ErrorResponse>(e.getErrorResponse(),
        // HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>("Query invalid", HttpStatus.BAD_REQUEST);
    }

    // TODO: Create and handle other Exceptions, e.g. Resource not found

}