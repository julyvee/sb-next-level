package ch.ipt.sbnextlevel.exception.model;

public class InvalidQueryException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -132517762686755407L;
    private ErrorResponse errorResponse;

    public InvalidQueryException(String userMessage, String devMessage) {
        this.errorResponse = new ErrorResponse(userMessage, devMessage);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}