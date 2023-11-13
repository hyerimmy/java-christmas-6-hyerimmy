package christmas.controller;

import christmas.model.Order;
import christmas.model.Plan;
import christmas.utils.FormattedPrinter;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.utils.FormattedPrinter.printlnExceptionWithReEnterMessage;

public class EventController {
    private Plan plan;

    public void run() {
        OutputView.printWelcomeMessage();
        makePlan();
        showEventBenefitsPreview();
    }

    /* 방문일, 주문 목록 계획 설정 */
    private void makePlan() {
        InputView.printEnterDateOfVisit();
        setDateOfVisit();
        InputView.printEnterMenuAndNumberToOrder();
        setOrderList();
    }

    /* 이벤트 혜택 미리 보기 결과 출력 */
    private void showEventBenefitsPreview() {
        OutputView.printEventBenefitsPreviewMessage(plan.getDayOfVisit());
        showOrderedMenu();
        showTotalAmountBeforeDiscount();
        showGiveawayMenu();
        showBenefitList();
        showTotalBenefitAmount();
        showTotalAmountAfterDiscout();
        showEventBadge();
    }

    /* 방문일 설정 */
    private void setDateOfVisit() {
        try {
            plan = new Plan(InputView.inputDateOfVisit());
        } catch (IllegalArgumentException e) {
            printlnExceptionWithReEnterMessage(e.getMessage());
            setDateOfVisit();
        }
    }

    /* 주문 목록 설정 */
    private void setOrderList() {
        try {
            plan.setOrderList(InputView.inputOrders());
        } catch (IllegalArgumentException e) {
            printlnExceptionWithReEnterMessage(e.getMessage());
            setOrderList();
        }
    }

    /* 주문 메뉴 출력 */
    private void showOrderedMenu() {
        OutputView.printOrderedMenuHeader();
        for(Order order : plan.getOrderList()){
            System.out.println(order.getMenuAndCountString());
        }
        System.out.println();
    }

    /* 할인 전 총주문 금액 출력 */
    private void showTotalAmountBeforeDiscount() {
        OutputView.printTotalAmountBeforeDiscountHeader();
        FormattedPrinter.printlnKorMoney(plan.getTotalAmount());
        System.out.println();
    }

    /* 증정 메뉴 출력 */
    private void showGiveawayMenu() {
        OutputView.printGiveawayMenuHeader();
        System.out.println();


    }

    /* 혜택 내역 출력 */
    private void showBenefitList() {
        OutputView.printBenefitListHeader();
        System.out.println();


    }

    /* 총혜택 금액 출력 */
    private void showTotalBenefitAmount() {
        OutputView.printTotalBenefitAmountHeader();
        System.out.println();


    }

    /* 할인 후 예상 결제 금액 */
    private void showTotalAmountAfterDiscout() {
        OutputView.printTotalAmountAfterDiscountHeader();
        System.out.println();


    }

    /* 12월 이벤트 배지 출력 */
    private void showEventBadge() {
        OutputView.printEventBadgeHeader();
        System.out.println();

    }
}
