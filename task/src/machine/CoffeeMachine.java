package machine;

public class CoffeeMachine {
    private final int milkPerCup = 50;
    private final int waterPerCup = 200;
    private final String liquidUnits = "ml";
    private final int beansPerCup = 15;
    private final String beansUnits = "g";

    public void ingredientsNeeded(int cupsOfCoffee) {
        System.out.printf("""
                For %d cups of coffee you will need:
                %d %s of water
                %d %s of milk
                %d %s of coffee beans
                """, cupsOfCoffee, cupsOfCoffee * waterPerCup, liquidUnits,
                cupsOfCoffee * milkPerCup, liquidUnits, cupsOfCoffee * beansPerCup, beansUnits);
    }


}
