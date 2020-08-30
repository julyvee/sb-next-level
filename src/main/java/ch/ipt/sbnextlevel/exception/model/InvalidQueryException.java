package ch.ipt.sbnextlevel.exception.model;

public class InvalidQueryException extends Exception {

    // TODO: Create a constructor that builds a custom error response
    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}