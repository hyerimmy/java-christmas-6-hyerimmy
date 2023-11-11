package christmas.model.benefit;

import christmas.model.Order;

import java.time.LocalDate;

public class SpecialDiscount extends Benefit {
    private final static int discountAmount = 1_000;

    public SpecialDiscount() {
        super("특별 할인");
    }

    @Override
    public boolean applyToDiscount(Order order) {
        LocalDate dayOfVisit = order.getDateOfVisit();
        return (dayOfVisit.getDayOfMonth() == 3
                || dayOfVisit.getDayOfMonth() == 10
                || dayOfVisit.getDayOfMonth() == 17
                || dayOfVisit.getDayOfMonth() == 25
                || dayOfVisit.getDayOfMonth() == 31
        );
    }

    @Override
    public int getDiscountAmount(Order order) {
        return discountAmount;
    }
}
