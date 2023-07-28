package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (repeat) {
            System.out.printf("%nWrite action (buy, fill, take, remaining, exit):%n");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> machine.buyCoffee(scanner);
                case "fill" -> machine.fillSupplies(scanner);
                case "take" -> machine.takeCash(scanner);
                case "remaining" -> machine.displayStatus();
                case "exit" -> repeat = false;
                default -> System.out.println("Not a valid action.");
            }
        }
    }
}
