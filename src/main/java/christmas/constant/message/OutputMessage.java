package christmas.constant.message;

public class OutputMessage {
    public static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_BENEFIT_PREVIEW_MESSAGE = "12월 $d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    private static final String HEADER_FORMAT = "<%s>";
    public static final String ORDERED_MENU_HEADER = String.format(HEADER_FORMAT, "주문 메뉴");
    public static final String TOTAL_ORDERED_AMOUNT_BEFORE_DISCOUNT_HEADER = String.format(HEADER_FORMAT, "할인 전 총주문 금액");
    public static final String FREE_MENU_HEADER = String.format(HEADER_FORMAT, "증정 메뉴");
    public static final String BENEFIT_LIST_HEADER = String.format(HEADER_FORMAT, "혜택 내역");
    public static final String TOTAL_BENEFIT_AMOUNT_HEADER = String.format(HEADER_FORMAT, "총혜택 금액");
    public static final String TOTAL_AMOUNT_AFTER_DISCOUNT_HEADER = String.format(HEADER_FORMAT, "할인 후 예상 결제 금액");
    public static final String EVENT_BADGE_HEADER = String.format(HEADER_FORMAT, "12월 이벤트 배지");
}
