package christmas.model;

import christmas.model.menu.Menu;

import java.util.Arrays;

import static christmas.constant.message.OutputMessage.EMPTY_RESULT;

public enum Badge {
    DEFAULT(EMPTY_RESULT, 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String name;
    private final long benefitAmount;

    Badge(String name, long benefitAmount) {
        this.name = name;
        this.benefitAmount = benefitAmount;
    }

    public static String getBadgeNameOf(long benefitAmount) {
        String resultBadgeName = null;
        for(Badge badge : Badge.values()){
            if(badge.benefitAmount <= benefitAmount)
                resultBadgeName = badge.name;
        }
        return resultBadgeName;
    }
}
