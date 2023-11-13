package christmas.model;

import christmas.model.menu.Menu;

import java.util.Arrays;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String name;
    private final int benefitAmount;

    Badge(String name, int benefitAmount) {
        this.name = name;
        this.benefitAmount = benefitAmount;
    }

    public static String getBadgeNameOf(int benefitAmount) {
        String resultBadgeName = null;
        for(Badge badge : Badge.values()){
            if(badge.benefitAmount <= benefitAmount)
                resultBadgeName = badge.name;
        }
        return resultBadgeName;
    }
}
