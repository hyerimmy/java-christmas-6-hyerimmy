package christmas.model.benefit;

import christmas.model.Order;

import java.time.LocalDate;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;

public class ChristmasDiscount extends Benefit {
    private final static LocalDate startDate = LocalDate.of(YEAR, MONTH, 1);
    private final static LocalDate endDate = LocalDate.of(YEAR, MONTH, 25);
    private final static int defaultAmount = 1_000;
    private final static int unitAmount = 100;

    public ChristmasDiscount() {
        super("크리스마스 디데이 할인");
    }

    @Override
    public int getDiscountAmount(Order order){
        LocalDate dateOfVisit = order.getDateOfVisit();
        return (defaultAmount + (dateOfVisit.getDayOfMonth()-1) * unitAmount);
    }

    @Override
    public boolean applyToDiscount(Order order){
        LocalDate dateOfVisit = order.getDateOfVisit();
        return (!dateOfVisit.isBefore(startDate) && !dateOfVisit.isAfter(endDate));
    }
}
