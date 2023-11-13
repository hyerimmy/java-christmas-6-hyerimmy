package christmas.constant.message;

import static christmas.constant.SystemSetting.MONTH;

public class InputMessage {
    public static final String ENTER_DATE_OF_VISIT =
            String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",MONTH);
    public static final String ENTER_MENU_AND_NUMBER_TO_ORDER =
            "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
}
