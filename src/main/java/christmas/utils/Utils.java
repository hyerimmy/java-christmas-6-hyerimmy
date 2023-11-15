package christmas.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

import static christmas.constant.SystemSetting.KOR_MONEY_FORMAT;
import static christmas.constant.SystemSetting.KOR_MONEY_UNIT;
import static christmas.constant.message.ExceptionMessage.NULL_INPUT_EXCEPTION;
import static christmas.constant.message.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;


public class Utils {
    public static int readNumber() {
        return parseInt(Console.readLine());
    }

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static List<String> readStringList() {
        return parseStringList(Console.readLine());
    }

    private static List<String> parseStringList(String string) {
        List<String> stringList = Stream.of(string.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        if (stringList.size() == 0)
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION.getMessage());
        return stringList;
    }

    public static String getFormattedKorMoney(long amount) {
        return KOR_MONEY_FORMAT.format(amount) + KOR_MONEY_UNIT;
    }

    public static String getFormattedKorDiscountMoney(long amount) {
        if (amount == 0)
            return amount + KOR_MONEY_UNIT;
        return "-" + KOR_MONEY_FORMAT.format(amount) + KOR_MONEY_UNIT;
    }
}
