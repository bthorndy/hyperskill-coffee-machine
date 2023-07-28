package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.displayStatus();

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy" -> machine.buyCoffee(scanner);
            case "fill" -> machine.fillSupplies(scanner);
            case "take" -> machine.takeCash(scanner);
            default -> System.out.println("Not a valid action.");
        }




    }

}
