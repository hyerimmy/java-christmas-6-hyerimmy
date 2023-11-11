package christmas.model.benefit;

import christmas.model.Order;

import java.time.DayOfWeek;

public class WeekdayDiscount extends Benefit {
    private final static int discountAmountPerMenu = 2_023;

    public WeekdayDiscount() {
        super("평일 할인");
    }

    @Override
    public boolean applyToDiscount(Order order) {
        DayOfWeek dayOfVisit = order.getDateOfVisit().getDayOfWeek();
        return (dayOfVisit.equals(DayOfWeek.SUNDAY)
                || dayOfVisit.equals(DayOfWeek.MONDAY)
                || dayOfVisit.equals(DayOfWeek.TUESDAY)
                || dayOfVisit.equals(DayOfWeek.WEDNESDAY)
                || dayOfVisit.equals(DayOfWeek.THURSDAY)
        );
    }

    @Override
    public int getDiscountAmount(Order order) {
        return calculateDiscountPerMenu(order.getDessertMenus(), discountAmountPerMenu);
    }
}
