package christmas.utils;

public class FormattedPrinter {
    private static final String ENTER_AGAIN_MESSAGE = "다시 입력해 주세요.";
    private static final String HEADER_FORMAT = "<%s>";


    public static void printlnExceptionWithReEnterMessage(String exceptionMessage) {
        System.out.println(exceptionMessage + " " + ENTER_AGAIN_MESSAGE);
    }

    public static void printlnHeaderMessage(String headerMessage) {
        System.out.printf((HEADER_FORMAT) + "%n", headerMessage);
    }
}
