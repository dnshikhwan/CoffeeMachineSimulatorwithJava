package machine;
import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {

    // resources
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;
    static int coffeeCount = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("exit")) {
            System.out.println("\nWrite action (buy, fill, take, clean, remaining, exit):");
            choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    if (coffeeCount == 10) {
                        System.out.println("I need cleaning!");
                        break;
                    }
                    handleBuy(scanner);
                    break;
                case "fill":
                    handleFill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "clean":
                    clean();
                    break;
                case "remaining":
                    System.out.println();
                    printRemaining();
                    break;
                case "exit":
                    break;
            }
        }

        scanner.close();
    }

    public static void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void handleBuy(Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                " back - to main menu:");
        String typeOfCoffee = scanner.nextLine();
        if (typeOfCoffee.equals("back")){
            return;
        }
        buy(typeOfCoffee);
    }

    // need refactoring
    public static void buy(String typeOfCoffee){
        Coffee selected = null;
        switch (typeOfCoffee) {
            case "1":
                selected = new Coffee("Espresso", 250, 0, 16, 4);
                break;
            case "2":
                selected = new Coffee("Latte", 350, 75, 20, 7);
                break;
            case "3":
                selected  = new Coffee("Cappuccino", 200, 100, 12, 6);
                break;
        }

        if (selected != null && checkResources(selected)) {
            makeCoffee(selected);
        }

    }

    public static void makeCoffee(Coffee coffee) {
        System.out.println("I have enough resources, making you a coffee!");
        water -= coffee.getWaterNeeded();
        milk -= coffee.getMilkNeeded();
        coffeeBeans -= coffee.getCoffeeNeeded();
        disposableCups--;
        money += coffee.getPrice();
        coffeeCount++;
    }

    public static boolean checkResources(Coffee coffee) {
        if (water < coffee.getWaterNeeded()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < coffee.getMilkNeeded()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeans < coffee.getCoffeeNeeded()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (disposableCups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    public static void handleFill(Scanner scanner) {
        System.out.println("\nWrite how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffeeBean = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int addCup = scanner.nextInt();
        scanner.nextLine();

        fill(addWater, addMilk, addCoffeeBean, addCup);
    }

    public static void fill(int addWater, int addMilk, int addCoffeeBean, int addCup) {
        water += addWater;
        milk += addMilk;
        coffeeBeans += addCoffeeBean;
        disposableCups += addCup;
    }

    public static void take() {
        System.out.println("\nI gave you $" + money);
        money = 0;
    }

    public static void clean(){
        coffeeCount = 0;
        System.out.println("I have been cleaned!");
    }
}