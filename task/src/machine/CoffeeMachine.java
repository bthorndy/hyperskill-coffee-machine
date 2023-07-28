package machine;

import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    private int beans;
    private int milk;
    private int water;
    private int cups;
    private double balance;

    private CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.cups = 0;
    }

    public CoffeeMachine(int water, int milk, int beans, int cups, double balance) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.balance = balance;
    }

    public void displayStatus() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%.0f of money
                """, water, milk, beans, cups, balance);
    }


    public void buyCoffee(Scanner scanner) {
        int selection = 0;
        CoffeeDrink beverage = null;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        while (beverage == null) {
            try {
                String input = scanner.nextLine();

                if (input.equals("back")) {
                    return;
                } else {
                    selection = Integer.parseInt(input);
                }

                switch (selection) {
                    case 1 -> beverage = CoffeeDrink.ESPRESSO;
                    case 2 -> beverage = CoffeeDrink.LATTE;
                    case 3 -> beverage = CoffeeDrink.CAPPUCCINO;
                    default -> throw new IllegalArgumentException("Selection out of bounds.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please enter 1, 2 or 3.");
            }
        }

        if (water < beverage.water) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milk < beverage.milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (beans < beverage.beans) {
            System.out.println("Sorry, not enough beans!");
            return;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.printf("I'm making you a coffee!");
        }

        water = water - beverage.water;
        milk = milk - beverage.milk;
        beans = beans - beverage.beans;
        cups--;
        balance = balance + beverage.price;
    }

    public void fillSupplies(Scanner scanner) {

        System.out.println("Write how many ml of water you want to add:");
        water = water + Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk you want to add:");
        milk = milk + Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many g of coffee beans you want to add:");
        beans = beans + Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many disposable cups you want to add:");
        cups = cups + Integer.parseInt(scanner.nextLine());
    }

    public void takeCash(Scanner scanner) {
        System.out.printf("I gave you %.0f of money%n", balance);
        balance = 0;
    }

}


