package enums;

import java.time.LocalDateTime;

public enum ExceptionEnums {
    NOT_FOUND_EXCEPTION("not found",LocalDateTime.now()),
    LACK_OF_FUNDS("Luck of funds",LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("invalid option",LocalDateTime.now()),
    WRONG_FORMAT_EXCEPTION("wrong format ",LocalDateTime.now()),
    SAME_EMAIL_EXCEPTION("Same email ",LocalDateTime.now()),
    BLOCKED_CUSTOMER_EXCEPTION("Customer Blocked",LocalDateTime.now()),
    WRONG_MONEY_EXCEPTION("Wrong money",LocalDateTime.now()),
    LOW_BALANCE_EXCEPTION("Low balance",LocalDateTime.now()),
    LOW_BALANCE_IN_ATM_EXCEPTION("Low balance int atm",LocalDateTime.now());
    private final String message;
    private final LocalDateTime exceptionTime;

    ExceptionEnums(String message, LocalDateTime exceptionTime) {
        this.message = message;
        this.exceptionTime = exceptionTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
