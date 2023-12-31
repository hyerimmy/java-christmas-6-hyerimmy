package christmas.model.benefit;

import christmas.model.Order;
import christmas.model.Plan;
import christmas.model.menu.Menu;

public class GiveawayEvent extends Benefit {
    private static final GiveawayEvent instance = new GiveawayEvent();
    private final static Order giveaway = new Order(Menu.CHAMPAGNE, 1);
    private final static int amountCondition = 120_000;

    private GiveawayEvent() {
        super("증정 이벤트");
    }

    protected static GiveawayEvent getInstance(){
        return instance;
    }

    @Override
    public boolean applyBenefit(Plan plan) {
        if(!includeInEventDate(plan.getDateOfVisit()))
            return false;
        return (plan.getTotalAmount() >= amountCondition);
    }

    @Override
    public long getDiscountAmount(Plan plan) {
        return giveaway.getAmount();
    }

    public String getGivewayMenuAndCountString() {
        return giveaway.getMenuAndCountString();
    }
}
