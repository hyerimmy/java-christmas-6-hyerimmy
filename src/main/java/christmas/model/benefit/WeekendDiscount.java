package christmas.model.benefit;

import christmas.model.Plan;

import java.time.DayOfWeek;

public class WeekendDiscount extends Benefit {
    private final static int discountAmountPerMenu = 2_023;

    public WeekendDiscount() {
        super("주말 할인");
    }

    @Override
    public boolean applyToDiscount(Plan plan) {
        DayOfWeek dayOfVisit = plan.getDateOfVisit().getDayOfWeek();
        return (dayOfVisit.equals(DayOfWeek.FRIDAY)
                || dayOfVisit.equals(DayOfWeek.SATURDAY)
        );
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        return calculateDiscountPerMenu(plan.getMainMenus(), discountAmountPerMenu);
    }
}
