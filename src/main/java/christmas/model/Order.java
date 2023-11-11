package christmas.model;

import christmas.model.menu.Menu;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final HashMap<Menu, Integer> menus;
    private final LocalDate dateOfVisit;

    Order(HashMap<Menu, Integer> menus, LocalDate dateOfVisit) {
        this.menus = menus;
        this.dateOfVisit = dateOfVisit;
    }

    public int getTotalAmount(){
        return menus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Menu> getDessertMenus(){
        return menus.keySet().stream()
                .filter(Menu::isDessert)
                .collect(Collectors.toList());
    }

    public List<Menu> getMainMenus(){
        return menus.keySet().stream()
                .filter(Menu::isMain)
                .collect(Collectors.toList());
    }

    public LocalDate getDateOfVisit(){
        return dateOfVisit;
    }
}
