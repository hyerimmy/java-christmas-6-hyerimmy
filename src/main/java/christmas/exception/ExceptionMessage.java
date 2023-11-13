package christmas.exception;

public enum ExceptionMessage {
    NUMBER_FORMAT_EXCEPTION("숫자 형식이 아닙니다."),
    NULL_INPUT_EXCEPTION("빈 값입니다."),
    INVALID_ORDER_EXCEPTION("유효하지 않은 주문입니다."),
    INVALID_DATE_EXCEPTION("유효하지 않은 날짜입니다.");

    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return EXCEPTION_PREFIX + " " + this.message;
    }
}
