package christmas.view;

import christmas.constant.message.InputMessage;
import christmas.utils.Utils;

import java.util.List;

public class InputView {
    public static int inputReservationDate() {
        System.out.println(InputMessage.ENTER_RESERVATION_DATE);
        return Utils.readNumber();
    }

    public static List<String> inputMenus() {
        System.out.println(InputMessage.ENTER_MENU_AND_NUMBER_TO_ORDER);
        return Utils.readStringList();
    }
}
