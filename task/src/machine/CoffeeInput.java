package machine;

public enum CoffeeInput {

    COFFEE_BEANS(15, "g"),
    MILK(50, "ml"),
    WATER(200, "ml");


    private int amountPerCup;
    private final String units;

    CoffeeInput(int amountPerCup, String units) {
        this.amountPerCup = amountPerCup;
        this.units = units;
    }

    public int amountPerCup() {
        return amountPerCup;
    }

    public String units() {
        return units;
    }
}
