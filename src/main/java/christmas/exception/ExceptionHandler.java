package christmas.exception;

public class ExceptionHandler{
    private static final String ENTER_AGAIN_MESSAGE = "다시 입력해 주세요.";

    public static void printExceptionWithReEnterMessage(String exceptionMessage){
        System.out.println(exceptionMessage + " " + ENTER_AGAIN_MESSAGE);
    }
}
