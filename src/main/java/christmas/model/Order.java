package christmas.model;

import java.util.Calendar;
import java.util.HashMap;

public class Order {
    private final HashMap<Menu, Integer> menus;
    private final Calendar dateOfVisit;

    Order(HashMap<Menu, Integer> menus, Calendar dateOfVisit) {
        this.menus = menus;
        this.dateOfVisit = dateOfVisit;
    }

    public int getTotalAmount(){
        return menus.values().stream().mapToInt(Integer::intValue).sum();
    }
}
