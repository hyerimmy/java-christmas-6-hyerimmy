package christmas.view;

import christmas.constant.message.InputMessage;
import christmas.utils.Utils;

import java.util.List;

import static christmas.validation.Validator.validateDate;

public class InputView {
    public static int takeDateOfVisit() {
        System.out.println(InputMessage.ENTER_DATE_OF_VISIT);
        return inputDateOfVisit();
    }

    private static int inputDateOfVisit() {
        int inputNumber = Utils.readNumber();
        try{
            validateDate(inputNumber);
            return inputNumber;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputDateOfVisit();
        }
    }

    public static List<String> takeMenus() {
        System.out.println(InputMessage.ENTER_MENU_AND_NUMBER_TO_ORDER);
        return inputMenus();
    }

    private static List<String> inputMenus() {
        List<String> inputStrings = Utils.readStringList();
        try{
//            validateMenus(inputStrings);
            return inputStrings;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMenus();
        }
    }
}
