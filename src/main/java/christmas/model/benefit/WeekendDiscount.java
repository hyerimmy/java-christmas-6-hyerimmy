package christmas.model.benefit;

import christmas.model.Plan;

import java.time.DayOfWeek;

public class WeekendDiscount extends Benefit {
    private static final WeekendDiscount instance = new WeekendDiscount();
    private final static int discountAmountPerMenu = 2_023;

    public WeekendDiscount() {
        super("주말 할인");
    }

    protected static WeekendDiscount getInstance(){
        return instance;
    }

    @Override
    public boolean applyBenefit(Plan plan) {
        if(!includeInEventDate(plan.getDateOfVisit()))
            return false;
        DayOfWeek dayOfVisit = plan.getDateOfVisit().getDayOfWeek();
        return isWeekend(dayOfVisit) && containMainMenu(plan);
    }

    @Override
    public long getDiscountAmount(Plan plan) {
        return calculateDiscountPerMenu(plan.getMainMenuOrders(), discountAmountPerMenu);
    }
}
