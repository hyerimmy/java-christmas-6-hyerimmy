package christmas.model.benefit;

import christmas.model.Plan;

import java.time.DayOfWeek;

public class WeekdayDiscount extends Benefit {
    private static final WeekdayDiscount instance = new WeekdayDiscount();
    private final static int discountAmountPerMenu = 2_023;

    public WeekdayDiscount() {
        super("평일 할인");
    }

    protected static WeekdayDiscount getInstance(){
        return instance;
    }

    @Override
    public boolean applyBenefit(Plan plan) {
        if(!includeInEventDate(plan.getDateOfVisit()))
            return false;

        DayOfWeek dayOfVisit = plan.getDateOfVisit().getDayOfWeek();
        return isWeekday(dayOfVisit) && containDessertMenu(plan);
    }

    @Override
    public long getDiscountAmount(Plan plan) {
        return calculateDiscountPerMenu(plan.getDessertMenuOrders(), discountAmountPerMenu);
    }
}
