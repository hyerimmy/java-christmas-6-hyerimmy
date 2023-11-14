package christmas.model.benefit;

import christmas.model.menu.Menu;
import christmas.model.Plan;
import christmas.model.Order;
import christmas.utils.Utils;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;

public abstract class Benefit {
    private final String title;

    protected Benefit(String title) {
        this.title = title;
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

    protected boolean isWeekend(DayOfWeek dayOfVisit) {
        return (dayOfVisit.equals(DayOfWeek.FRIDAY)
                || dayOfVisit.equals(DayOfWeek.SATURDAY)
        );
    }
    protected boolean isWeekday(DayOfWeek dayOfVisit) {
        return (dayOfVisit.equals(DayOfWeek.SUNDAY)
                || dayOfVisit.equals(DayOfWeek.MONDAY)
                || dayOfVisit.equals(DayOfWeek.TUESDAY)
                || dayOfVisit.equals(DayOfWeek.WEDNESDAY)
                || dayOfVisit.equals(DayOfWeek.THURSDAY)
        );
    }

    protected boolean containDessertMenu(Plan plan){
        return !plan.getDessertMenus().isEmpty();
    }

    protected boolean containMainMenu(Plan plan){
        return !plan.getMainMenus().isEmpty();
    }

}
