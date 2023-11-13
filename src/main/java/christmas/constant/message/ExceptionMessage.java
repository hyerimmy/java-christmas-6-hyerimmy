package christmas.constant.message;

public enum ExceptionMessage {
    NUMBER_FORMAT_EXCEPTION("숫자 형식이 아닙니다."),
    INVALID_DATE_EXCEPTION("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return String.format(EXCEPTION_FORMAT, this.message);
    }
}
