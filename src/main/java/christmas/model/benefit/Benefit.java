package christmas.model.benefit;

import christmas.model.menu.Menu;
import christmas.model.Plan;
import christmas.model.Order;

import java.util.HashMap;
import java.util.List;

public abstract class Benefit {
    private final String title;

    protected Benefit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract public boolean applyToDiscount(Plan plan);

    abstract public int getDiscountAmount(Plan plan);

    protected int calculateDiscountPerMenu(List<Order> orderList, int discountAmountPerMenu) {
        int amountSum = 0;
        for (Order order : orderList) {
            amountSum += Math.min(order.getAmount(), discountAmountPerMenu);
        }
        return amountSum;
    }

    public HashMap<Menu, Integer> getGiveawayMenus() {
        return null;
    }

}
