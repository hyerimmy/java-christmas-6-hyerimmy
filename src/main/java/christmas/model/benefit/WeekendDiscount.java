package christmas.model.benefit;

import christmas.model.Order;

import java.time.DayOfWeek;

public class WeekendDiscount extends Benefit {
    private final static int discountAmountPerMenu = 2_023;

    public WeekendDiscount() {
        super("주말 할인");
    }

    @Override
    public boolean applyToDiscount(Order order) {
        DayOfWeek dayOfVisit = order.getDateOfVisit().getDayOfWeek();
        return (dayOfVisit.equals(DayOfWeek.FRIDAY)
                || dayOfVisit.equals(DayOfWeek.SATURDAY)
        );
    }

    @Override
    public int getDiscountAmount(Order order) {
        return calculateDiscountPerMenu(order.getMainMenus(), discountAmountPerMenu);
    }
}
