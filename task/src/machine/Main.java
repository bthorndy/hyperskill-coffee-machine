package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterAvailable = CoffeeMachine.collectInput(CoffeeInput.WATER.toString(), scanner);
        int milkAvailable = CoffeeMachine.collectInput(CoffeeInput.MILK.toString(), scanner);
        int coffeeAvailable = CoffeeMachine.collectInput(CoffeeInput.COFFEE_BEANS.toString(), scanner);
        int cupsRequested = CoffeeMachine.collectInput("COFFEE", scanner);

        CoffeeMachine myMachine = new CoffeeMachine(waterAvailable, milkAvailable, coffeeAvailable);

        myMachine.canMakeRequestedAmount(cupsRequested);
        System.out.println();

        scanner.close();
    }

}
