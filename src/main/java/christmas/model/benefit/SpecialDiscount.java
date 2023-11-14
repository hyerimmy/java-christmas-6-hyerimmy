package christmas.model.benefit;

import christmas.model.Plan;

import java.time.LocalDate;
import java.util.List;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;

public class SpecialDiscount extends Benefit {
    private static final SpecialDiscount instance = new SpecialDiscount();
    private final static int discountAmount = 1_000;
    private final static List<LocalDate> specialDates = List.of(
            LocalDate.of(YEAR, MONTH, 3),
            LocalDate.of(YEAR, MONTH, 10),
            LocalDate.of(YEAR, MONTH, 17),
            LocalDate.of(YEAR, MONTH, 25),
            LocalDate.of(YEAR, MONTH, 31)
    );

    public SpecialDiscount() {
        super("특별 할인");
    }

    protected static SpecialDiscount getInstance() {
        return instance;
    }

    @Override
    public boolean applyToDiscount(Plan plan) {
        LocalDate dateOfVisit = plan.getDateOfVisit();
        if(!includeInEventDate(dateOfVisit))
            return false;
        return specialDates.contains(dateOfVisit);
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        return Math.min(plan.getTotalAmount(), discountAmount);
    }
}
