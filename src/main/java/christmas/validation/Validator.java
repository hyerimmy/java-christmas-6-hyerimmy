package christmas.validation;

import christmas.model.menu.Menu;

import java.time.YearMonth;
import java.util.List;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;
import static christmas.exception.ExceptionMessage.INVALID_DATE_EXCEPTION;

public class Validator {
    public static void validateDate(int day){
        int endDayOfMonth = YearMonth.of(YEAR, MONTH).atEndOfMonth().getDayOfMonth();
        if(day >= 1 && day <= endDayOfMonth)
            return;
        throw new IllegalArgumentException(INVALID_DATE_EXCEPTION.getMessage());
    }

    public static void validateMenus(List<String> menus){
        for(String menu : menus){
            String[] M = menu.split("-");
            Menu.isMenu(M[0]);
        }
    }
}
