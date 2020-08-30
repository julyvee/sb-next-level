package ch.ipt.sbnextlevel.exception.model;

public class InvalidQueryException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -132517762686755407L;
    // TODO: Create a constructor that builds a custom error response
    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}