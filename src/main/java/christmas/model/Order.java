package christmas.model;

import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private final HashMap<Menu, Integer> menus;
    private final LocalDate dateOfVisit;

    Order(HashMap<Menu, Integer> menus, LocalDate dateOfVisit) {
        this.menus = menus;
        this.dateOfVisit = dateOfVisit;
    }

    public int getTotalAmount(){
        return menus.values().stream().mapToInt(Integer::intValue).sum();
    }

    public LocalDate getDateOfVisit(){
        return dateOfVisit;
    }
}
