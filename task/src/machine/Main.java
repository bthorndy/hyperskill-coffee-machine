package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cupsOfCoffee = 0;
        System.out.println("Write how many cups of coffee you will need:");

        while (cupsOfCoffee <= 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                cupsOfCoffee = scanner.nextInt();
                if (cupsOfCoffee < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Input is invalid. Enter a positive integer.");
            }
        }

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.ingredientsNeeded(cupsOfCoffee);

    }
}
