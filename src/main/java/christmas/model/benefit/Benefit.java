package christmas.model.benefit;

import christmas.model.menu.Menu;
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

    abstract public boolean applyToDiscount(Order order);

    abstract public int getDiscountAmount(Order order);

    protected int calculateDiscountPerMenu(List<Menu> menus, int discountAmountPerMenu) {
        int amountSum = 0;
        for (Menu menu : menus) {
            amountSum += Math.min(menu.getPrice(), discountAmountPerMenu);
        }
        return amountSum;
    }

    public HashMap<Menu, Integer> getGiveawayMenus() {
        return null;
    }

}
