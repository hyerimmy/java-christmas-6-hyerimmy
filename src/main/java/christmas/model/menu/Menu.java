package christmas.model.menu;

import java.util.Arrays;

import static christmas.constant.message.ExceptionMessage.INVALID_ORDER_EXCEPTION;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6_000, MenuType.APPETIZER),
    TAPAS("타파스", 5_500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, MenuType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, MenuType.MAIN),
    BARBECUE_LIP("바비큐립", 54_000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuType.DESSERT),
    ZERO_COKE("제로콜라", 3_000, MenuType.DRINK),
    RED_WINE("레드와인", 60_000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuType.DRINK);

    private final String name;
    private final long price;
    private final MenuType type;

    Menu(String name, long price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public boolean isMain(){
        return type.equals(MenuType.MAIN);
    }

    public boolean isDessert(){
        return type.equals(MenuType.DESSERT);
    }
    public boolean isDrink(){
        return type.equals(MenuType.DRINK);
    }

    public static boolean isValidMenu(String menuName){
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name.equals(menuName));
    }

    public static Menu of(String targetName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(targetName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_EXCEPTION.getMessage()));
    }

    public long getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}
