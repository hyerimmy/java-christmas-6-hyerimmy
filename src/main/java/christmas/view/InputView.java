package christmas.view;

import christmas.constant.message.InputMessage;
import christmas.utils.Utils;

import java.util.List;

public class InputView {
    public static int inputDateOfVisit() {
        System.out.println(InputMessage.ENTER_DATE_OF_VISIT);
        return Utils.readNumber();
    }

    public static List<String> inputMenus() {
        System.out.println(InputMessage.ENTER_MENU_AND_NUMBER_TO_ORDER);
        return Utils.readStringList();
    }
}
