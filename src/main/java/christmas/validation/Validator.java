package christmas.validation;

import java.time.YearMonth;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;
import static christmas.constant.message.ExceptionMessage.INVALID_DATE_EXCEPTION;

public class Validator {
    public static void validateDate(int day){
        int endDayOfMonth = YearMonth.of(YEAR, MONTH).atEndOfMonth().getDayOfMonth();
        if(day >= 1 && day <= endDayOfMonth)
            return;
        throw new IllegalArgumentException(INVALID_DATE_EXCEPTION.getMessage());
    }

//    public static void validateMenus(List<String> menus){
//        int endDayOfMonth = YearMonth.of(YEAR, MONTH).atEndOfMonth().getDayOfMonth();
//        if(day >= 1 && day <= endDayOfMonth)
//            return;
//        throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
//    }
}
