package christmas.model;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private String name;
    private int benefitAmount;

    Badge(String name, int benefitAmount) {
        this.name = name;
        this.benefitAmount = benefitAmount;
    }
}
