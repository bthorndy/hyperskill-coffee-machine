package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int beansAvailable;
    private int milkAvailable;
    private int waterAvailable;

    private CoffeeMachine() {
        this.waterAvailable = 0;
        this.milkAvailable = 0;
        this.beansAvailable = 0;
    }
    public CoffeeMachine(int waterAvailable, int milkAvailable, int beansAvailable) {
        this.waterAvailable = waterAvailable;
        this.milkAvailable = milkAvailable;
        this.beansAvailable = beansAvailable;
    }
    public static void ingredientsNeeded(int cupsOfCoffee) {
        System.out.printf("""
                For %d cups of coffee you will need:
                %d %s of water
                %d %s of milk
                %d %s of coffee beans
                """,
                cupsOfCoffee,
                cupsOfCoffee * CoffeeInput.WATER.amountPerCup(), CoffeeInput.WATER.units(),
                cupsOfCoffee * CoffeeInput.MILK.amountPerCup(), CoffeeInput.MILK.units(),
                cupsOfCoffee * CoffeeInput.COFFEE_BEANS.amountPerCup(), CoffeeInput.COFFEE_BEANS.units());
    }

    public static int collectInput(String input, Scanner scanner) {
        int amount = -1;

        if (input == "COFFEE") {
            System.out.printf("Write how many cups of coffee you will need:%n");
        } else {
            CoffeeInput inputType = CoffeeInput.valueOf(input);
            System.out.printf("Write how many %s of %s the coffee machine has:%n",
                    inputType.units(), inputType.toString().toLowerCase());
        }

        while (amount < 0) {
            try {
                amount = Integer.parseInt(scanner.nextLine());

                if (amount < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Input is invalid. Enter an integer greater than or equal to zero.");
            }
        }
        return amount;
    }

    public void canMakeRequestedAmount(int cupsRequested) {
        int cupsCanBeMade = 0;
        int additionalCups;

        int cupsFromWater = waterAvailable / CoffeeInput.WATER.amountPerCup();
        int cupsFromMilk = milkAvailable / CoffeeInput.MILK.amountPerCup();
        int cupsFromBeans = beansAvailable / CoffeeInput.COFFEE_BEANS.amountPerCup();

        cupsCanBeMade = Math.min(cupsFromBeans, Math.min(cupsFromMilk, cupsFromWater));
        additionalCups = cupsCanBeMade - cupsRequested;

        if (cupsCanBeMade == cupsRequested) {
            System.out.printf("Yes, I can make that amount of coffee%n");
        } else if (cupsCanBeMade > cupsRequested) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", additionalCups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", cupsCanBeMade);
        }

    }


}
