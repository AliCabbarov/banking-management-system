package exception;

import enums.ExceptionEnums;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    String message;
    LocalDateTime exceptionTime;

    public ApplicationException(ExceptionEnums exception) {
        super(exception.getMessage());
        this.message = exception.getMessage();
        this.exceptionTime = exception.getExceptionTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
