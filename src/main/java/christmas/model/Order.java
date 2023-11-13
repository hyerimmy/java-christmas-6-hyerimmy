package christmas.model;

import christmas.model.menu.Menu;
import christmas.utils.Utils;

import static christmas.exception.ExceptionMessage.INVALID_ORDER_EXCEPTION;

public class Order {
    private Menu menu;
    private int count;

    public Order(String orderData) {
        setMenu(orderData.split("-")[0]);
        setCount(orderData.split("-")[1]);
    }

    public String getMenuName(){
        return menu.getName();
    }

    public int getCount(){
        return count;
    }

    public int getAmount(){
        return menu.getPrice() * count;
    }


    private void setMenu(String menuName){
        validateMenuName(menuName);
        this.menu = Menu.of(menuName);
    }

    private void setCount(String count){
        validateCount(count);
        this.count = Utils.parseInt(count);
    }

    private static void validateMenuName(String name){
        if(!Menu.isMenu(name))
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }

    private static void validateCount(String numberString){
        if(Utils.parseInt(numberString) < 1)
            throw new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage());
    }


    public boolean isMain(){
        return this.menu.isMain();
    }

    public boolean isDessert(){
        return this.menu.isDessert();
    }
}
