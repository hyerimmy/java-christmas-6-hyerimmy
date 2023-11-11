package christmas.model.benefit;

import christmas.model.Order;
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
    public boolean applyToDiscount(Order order) {
        return (order.getTotalAmount() >= amountCondition);
    }

    @Override
    public int getDiscountAmount(Order order) {
        return giveawayMenus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public HashMap<Menu, Integer> getGiveawayMenus(Order order) {
        return giveawayMenus;
    }
}
