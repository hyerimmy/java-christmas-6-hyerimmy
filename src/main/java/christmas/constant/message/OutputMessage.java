package christmas.constant.message;

import static christmas.constant.SystemSetting.MONTH;

public class OutputMessage {
    public static final String WELCOME_MESSAGE
            = "안녕하세요! 우테코 식당 " + MONTH + "월 이벤트 플래너입니다.";
    public static final String EVENT_BENEFITS_PREVIEW_MESSAGE
            = MONTH + "월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    /* Divider */
    public static final String CHRISTMAS_THEME_DIVIDER = "~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~";


    /*  Header Message   */
    public static final String ORDERED_MENU_HEADER = "주문 메뉴";
    public static final String TOTAL_AMOUNT_BEFORE_DISCOUNT_HEADER = "할인 전 총주문 금액";
    public static final String GIVEAWAY_MENU_HEADER = "증정 메뉴";
    public static final String BENEFIT_LIST_HEADER = "혜택 내역";
    public static final String TOTAL_BENEFIT_AMOUNT_HEADER = "총혜택 금액";
    public static final String TOTAL_AMOUNT_AFTER_DISCOUNT_HEADER = "할인 후 예상 결제 금액";
    public static final String EVENT_BADGE_HEADER = MONTH + "월 이벤트 배지";
}
