package christmas.model.benefit;

import christmas.model.Plan;

import java.time.LocalDate;

public class SpecialDiscount extends Benefit {
    private final static int discountAmount = 1_000;

    public SpecialDiscount() {
        super("특별 할인");
    }

    @Override
    public boolean applyToDiscount(Plan plan) {
        LocalDate dayOfVisit = plan.getDateOfVisit();
        return (dayOfVisit.getDayOfMonth() == 3
                || dayOfVisit.getDayOfMonth() == 10
                || dayOfVisit.getDayOfMonth() == 17
                || dayOfVisit.getDayOfMonth() == 25
                || dayOfVisit.getDayOfMonth() == 31
        );
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        return discountAmount;
    }
}
