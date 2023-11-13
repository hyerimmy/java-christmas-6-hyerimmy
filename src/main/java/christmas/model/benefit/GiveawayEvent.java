package christmas.model.benefit;

import christmas.model.Plan;
import christmas.model.menu.Menu;

import java.util.HashMap;

public class GiveawayEvent extends Benefit {
    private final static HashMap<Menu, Integer> giveawayMenus = new HashMap<>() {{
        put(Menu.CHAMPAGNE, 1);
    }};
    private final static int amountCondition = 120_000;

    public GiveawayEvent() {
        super("증정 이벤트");
    }

    @Override
    public String getTitle(){
        return "d";
    }

    @Override
    public boolean applyToDiscount(Plan plan) {
        return (plan.getTotalAmount() >= amountCondition);
    }

    @Override
    public int getDiscountAmount(Plan plan) {
        return giveawayMenus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public HashMap<Menu, Integer> getGiveawayMenus(Plan plan) {
        return giveawayMenus;
    }
}
