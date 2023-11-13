package christmas.view;

import christmas.utils.FormattedPrinter;

import static christmas.constant.message.OutputMessage.*;

public class OutputView {

    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printEventBenefitsPreviewMessage(int day) {
        System.out.println();
        System.out.println(CHRISTMAS_THEME_DIVIDER);
        System.out.printf(EVENT_BENEFITS_PREVIEW_MESSAGE+"%n",day);
        System.out.println();
    }

    public static void printOrderedMenuHeader() {
        FormattedPrinter.printlnHeaderMessage(ORDERED_MENU_HEADER);
    }

    public static void printTotalAmountBeforeDiscountHeader() {
        FormattedPrinter.printlnHeaderMessage(TOTAL_AMOUNT_BEFORE_DISCOUNT_HEADER);
    }

    public static void printGiveawayMenuHeader() {
        FormattedPrinter.printlnHeaderMessage(GIVEAWAY_MENU_HEADER);
    }

    public static void printBenefitListHeader() {
        FormattedPrinter.printlnHeaderMessage(BENEFIT_LIST_HEADER);
    }

    public static void printTotalBenefitAmountHeader() {
        FormattedPrinter.printlnHeaderMessage(TOTAL_BENEFIT_AMOUNT_HEADER);
    }

    public static void printTotalAmountAfterDiscountHeader() {
        FormattedPrinter.printlnHeaderMessage(TOTAL_AMOUNT_AFTER_DISCOUNT_HEADER);
    }

    public static void printEventBadgeHeader() {
        FormattedPrinter.printlnHeaderMessage(EVENT_BADGE_HEADER);
    }

}
