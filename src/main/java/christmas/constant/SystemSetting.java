package christmas.constant;

import java.text.DecimalFormat;

public class SystemSetting {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;

    public static final int MAXIMUM_NUMBER_OF_ORDER = 20;
    public static final DecimalFormat KOR_MONEY_FORMAT = new DecimalFormat("###,##0");

    public static final String DELIMITER = ": ";
    public static final String COMMAS = ",";
    public static final String MINUS_SIGN = "-";
    public static final String KOR_MONEY_UNIT = "원";
    public static final String KOR_COUNTING_UNIT = "개";
    public static final String ORDER_INPUT_REGEX = "^[가-힣]+-[0-9]+$";

    public static final String MERRY_CHRISTMAS_ART = """
            *˚ *˚ ˛★Event will be continued ★*•*˛  。
             。。* ˚ *˚  ★in January 2024!★ 。˛ ˚ ˚˛  
              。  • * ˚*˚ ˛ _Π_____*。˚ ˛˛  °  •˛•*
              ˛*˚ ˛˛  •˛•*/_______/~＼。˚  ˚* ˚ • ˛ *
            ˚ ˛。 • ˚ ˚ •˛｜ 田 田  ｜ 0｜ • ° •˛ ˚ ˛˚˛
             ╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮
               
            """;
}
