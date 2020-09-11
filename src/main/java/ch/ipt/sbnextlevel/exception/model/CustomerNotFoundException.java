package ch.ipt.sbnextlevel.exception.model;

public class CustomerNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 3213029314765724987L;
    private ErrorResponse errorResponse;

    public CustomerNotFoundException(String userMessage, String devMessage) {
        this.errorResponse = new ErrorResponse(userMessage, devMessage);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}