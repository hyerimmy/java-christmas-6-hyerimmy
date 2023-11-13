package christmas.constant;

import java.text.DecimalFormat;

public class SystemSetting {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;

    public static final int MAXIMUM_NUMBER_OF_ORDER = 20;
    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,##0");
    public static final String ORDER_INPUT_REGEX = "^[가-힣]+-[0-9]+$";
}
