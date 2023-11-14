package christmas.model;

import christmas.model.benefit.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static christmas.constant.SystemSetting.*;
import static christmas.constant.message.OutputMessage.EMPTY_RESULT;
import static christmas.exception.ExceptionMessage.INVALID_DATE_EXCEPTION;
import static christmas.exception.ExceptionMessage.INVALID_ORDER_EXCEPTION;

public class Plan {
    private final LocalDate dateOfVisit;
    private final List<Order> orderList = new ArrayList<>();
    private final List<Benefit> benefitList = new ArrayList<>();

    public Plan(int day) throws IllegalArgumentException {
        validateDate(day);
        this.dateOfVisit = LocalDate.of(YEAR, MONTH, day);
    }

    public void setOrderList(List<String> orderInputs) throws IllegalArgumentException {
        orderList.clear();

        for (String orderInput : orderInputs) {
            validateOrderInputPattern(orderInput);
            orderList.add(new Order(orderInput));
        }
        validateDuplicateMenu();
        validateNumberOfOrder();
    }

    public int getTotalAmount() {
        return orderList.stream()
                .mapToInt(Order::getAmount)
                .sum();
    }

    public int getTotalAmountAfterDiscount() {
        return getTotalAmount() - getTotalDiscountAmount();
    }

    public List<Order> getDessertMenus() {
        return orderList.stream()
                .filter(Order::isDessert)
                .collect(Collectors.toList());
    }

    public List<Order> getMainMenus() {
        return orderList.stream()
                .filter(Order::isMain)
                .collect(Collectors.toList());
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public int getDayOfVisit() {
        return dateOfVisit.getDayOfMonth();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void calculateBenefitList() {
        for (Benefit benefit : Benefit.getAllInstances()) {
            checkAndAddBenefit(benefit);
        }
    }

    private void checkAndAddBenefit(Benefit benefit) {
        if (benefit.applyToDiscount(this))
            benefitList.add(benefit);
    }

    public String getGiveawayResult() {
        GiveawayEvent giveawayEventInstance = Benefit.getGiveawayEventInstance();
        if (benefitList.contains(giveawayEventInstance))
            return giveawayEventInstance.getGivewayMenuAndCountString(this);
        return EMPTY_RESULT;
    }

    public List<String> getBenefitList() {
        List<String> result = new ArrayList<>();
        for (Benefit benefit : benefitList) {
            result.add(benefit.getTitleAndAmountString(this));
        }
        return result;
    }

    public int getTotalBenefitAmount() {
        int amount = 0;
        for (Benefit benefit : benefitList) {
            amount += benefit.getDiscountAmount(this);
        }
        return amount;
    }

    private int getTotalDiscountAmount() {
        int amount = 0;
        for (Benefit benefit : benefitList) {
            if(benefit == Benefit.getGiveawayEventInstance())
                continue;
            amount += benefit.getDiscountAmount(this);
        }
        return amount;
    }


    private void validateOrderInputPattern(String orderInput) {
        if (!Pattern.matches(ORDER_INPUT_REGEX, orderInput))
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }

    /* 중복 메뉴 검증 */
    private void validateDuplicateMenu() {
        if (orderList.size() != orderList.stream().map(Order::getMenuName).distinct().count())
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }

    /* 주문 목록 최대 개수 제한 검증 */
    private void validateNumberOfOrder() {
        if (orderList.stream().mapToInt(Order::getCount).sum() > MAXIMUM_NUMBER_OF_ORDER)
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }

    private void validateDate(int day) {
        int lastDay = YearMonth.of(YEAR, MONTH).atEndOfMonth().getDayOfMonth();
        if (day < 1 || day > lastDay)
            throw new IllegalArgumentException(INVALID_DATE_EXCEPTION.getMessage());
    }
}
