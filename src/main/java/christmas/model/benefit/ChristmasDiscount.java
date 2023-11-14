package christmas.model.benefit;

import christmas.model.Plan;

import java.time.LocalDate;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;

public class ChristmasDiscount extends Benefit {
    private static final ChristmasDiscount instance = new ChristmasDiscount();
    private final static int defaultAmount = 1_000;
    private final static int unitAmount = 100;

    public ChristmasDiscount() {
        super(
                "크리스마스 디데이 할인",
                LocalDate.of(YEAR, MONTH, 1),
                LocalDate.of(YEAR, MONTH, 25)
        );
    }

    protected static ChristmasDiscount getInstance() {
        return instance;
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        LocalDate dateOfVisit = plan.getDateOfVisit();
        return (defaultAmount + (dateOfVisit.getDayOfMonth() - 1) * unitAmount);
    }

    @Override
    public boolean applyBenefit(Plan plan) {
        return includeInEventDate(plan.getDateOfVisit());
    }
}
