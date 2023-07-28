package machine;

public enum CoffeeDrink {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);



    public final int water;
    public final int milk;
    public final int beans;
    public final double price;
    
    CoffeeDrink(int water, int milk, int beans, double price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }
}
