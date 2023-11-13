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
    public boolean applyToDiscount(Plan plan) {
        DayOfWeek dayOfVisit = plan.getDateOfVisit().getDayOfWeek();
        return (dayOfVisit.equals(DayOfWeek.SUNDAY)
                || dayOfVisit.equals(DayOfWeek.MONDAY)
                || dayOfVisit.equals(DayOfWeek.TUESDAY)
                || dayOfVisit.equals(DayOfWeek.WEDNESDAY)
                || dayOfVisit.equals(DayOfWeek.THURSDAY)
        );
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        return calculateDiscountPerMenu(plan.getDessertMenus(), discountAmountPerMenu);
    }
}
