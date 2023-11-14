package christmas.model.benefit;

import christmas.model.menu.Menu;
import christmas.model.Plan;
import christmas.model.Order;
import christmas.utils.Utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;

import static christmas.constant.SystemSetting.MONTH;
import static christmas.constant.SystemSetting.YEAR;

public abstract class Benefit {
    private final String title;
    private LocalDate startDate = YearMonth.of(YEAR, MONTH).atDay(1);
    private LocalDate endDate = YearMonth.of(YEAR, MONTH).atEndOfMonth();

    private final List<DayOfWeek> weekdays = List.of(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY
    );

    private final List<DayOfWeek> weekends = List.of(
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY
    );


    protected Benefit(String title) {
        this.title = title;
    }

    protected Benefit(String title, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static List<Benefit> getAllInstances() {
        return List.of(
                ChristmasDiscount.getInstance(),
                WeekdayDiscount.getInstance(),
                WeekendDiscount.getInstance(),
                SpecialDiscount.getInstance(),
                GiveawayEvent.getInstance()
        );
    }

    public static ChristmasDiscount getChristmasDiscountInstance() {
        return ChristmasDiscount.getInstance();
    }

    public static GiveawayEvent getGiveawayEventInstance() {
        return GiveawayEvent.getInstance();
    }

    public static SpecialDiscount getSpecialDiscountInstance() {
        return SpecialDiscount.getInstance();
    }

    public static WeekdayDiscount getWeekdayDiscountInstance() {
        return WeekdayDiscount.getInstance();
    }

    public static WeekendDiscount getWeekendDiscountInstance() {
        return WeekendDiscount.getInstance();
    }

    public String getTitleAndAmountString(Plan plan) {
        return title + ": " + Utils.getFormattedKorDiscountMoney(getDiscountAmount(plan));
    }

    abstract public boolean applyToDiscount(Plan plan);

    abstract public int getDiscountAmount(Plan plan);

    protected int calculateDiscountPerMenu(List<Order> orderList, int discountAmountPerMenu) {
        int amountSum = 0;
        for (Order order : orderList) {
            amountSum += Math.min(order.getAmount(), discountAmountPerMenu) * order.getCount();
        }
        return amountSum;
    }

    public HashMap<Menu, Integer> getGiveawayMenus() {
        return null;
    }

    protected boolean includeInEventDate(LocalDate dateOfVisit) {
        return (!dateOfVisit.isBefore(startDate) && !dateOfVisit.isAfter(endDate));
    }

    protected boolean isWeekend(DayOfWeek dayOfVisit) {
        return weekends.contains(dayOfVisit);
    }
    protected boolean isWeekday(DayOfWeek dayOfVisit) {
        return weekdays.contains(dayOfVisit);
    }

    protected boolean containDessertMenu(Plan plan){
        return !plan.getDessertMenus().isEmpty();
    }

    protected boolean containMainMenu(Plan plan){
        return !plan.getMainMenus().isEmpty();
    }

}
