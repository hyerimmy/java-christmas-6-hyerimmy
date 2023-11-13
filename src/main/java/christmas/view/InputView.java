package christmas.view;

import christmas.constant.message.InputMessage;
import christmas.utils.Utils;

import java.util.List;

import static christmas.utils.FormattedPrinter.printlnExceptionWithReEnterMessage;

public class InputView {
    public static void printEnterDateOfVisit() {
        System.out.println(InputMessage.ENTER_DATE_OF_VISIT);
    }

    public static int inputDateOfVisit() {
        try{
            return Utils.readNumber();
        } catch (IllegalArgumentException e){
            printlnExceptionWithReEnterMessage(e.getMessage());
            return inputDateOfVisit();
        }
    }

    public static void printEnterMenuAndNumberToOrder() {
        System.out.println(InputMessage.ENTER_MENU_AND_NUMBER_TO_ORDER);
    }

    public static List<String> inputOrders() {
        try{
            return Utils.readStringList();
        } catch (IllegalArgumentException e){
            printlnExceptionWithReEnterMessage(e.getMessage());
            return inputOrders();
        }
    }
}
