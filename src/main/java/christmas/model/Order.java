package christmas.model;

import christmas.model.menu.Menu;
import christmas.utils.Utils;

import static christmas.constant.SystemSetting.KOR_COUNTING_UNIT;
import static christmas.constant.message.ExceptionMessage.INVALID_ORDER_EXCEPTION;

public class Order {
    private Menu menu;
    private int count;

    public Order(String orderData) {
        setMenu(orderData.split("-")[0]);
        setCount(orderData.split("-")[1]);
    }
    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }

    public String getMenuAndCountString() {
        return menu.getName() + " " + count + KOR_COUNTING_UNIT;
    }

    public long getAmount() {
        return menu.getPrice() * count;
    }


    private void setMenu(String menuName) {
        validateMenuName(menuName);
        this.menu = Menu.of(menuName);
    }

    private void setCount(String count) {
        validateCount(count);
        this.count = Utils.parseInt(count);
    }

    private static void validateMenuName(String name) {
        if (!Menu.isValidMenu(name))
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }

    private static void validateCount(String numberString) {
        if (Utils.parseInt(numberString) < 1)
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }


    public boolean isMain() {
        return this.menu.isMain();
    }

    public boolean isDessert() {
        return this.menu.isDessert();
    }

    public boolean isDrink() {
        return this.menu.isDrink();
    }
}
