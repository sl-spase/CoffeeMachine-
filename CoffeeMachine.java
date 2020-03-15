package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);
    private static int money = 550;
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static final String ESPRESSO = "1";
    private static final String LATTE = "2";
    private static final String CAPPUCCINO = "3";
    private static boolean writeAction = true;

    public static void main(String[] args) {

        while (writeAction) {
            chooseAction();
        }

    }

    private static void chooseAction() {

        System.out.println("Write action (buy, fill, take, remaining, exit) :");
        String action = scanner.nextLine();

        if ("buy".equals(action)) {
            buy();
        } else if ("fill".equals(action)) {
            fill();
        } else if ("take".equals(action)) {
            take();
        } else if ("remaining".equals(action)) {
            remaining();
        } else if ("exit".equals(action)) {
            exit();
        }
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeChose = scanner.nextLine();
        boolean haveResources = false;
        if (ESPRESSO.equals(coffeeChose)) {
            int theWater = 250;
            int theCoffeeBeans = 16;
            int theCups = 1;
            if (hasEnoughIngredients(theWater,0, theCups, theCoffeeBeans)) {
                money += 4;
                haveResources = true;
            }
        } else if (LATTE.equals(coffeeChose)) {
            int theWater = 350;
            int theMilk = 75;
            int theCoffeeBeans = 20;
            int theCups = 1;
            if (hasEnoughIngredients(theWater, theMilk, theCups, theCoffeeBeans)) {
                money += 7;
                haveResources = true;
            }
        } else if (CAPPUCCINO.equals(coffeeChose)) {
            int theWater = 200;
            int theMilk = 100;
            int theCups = 1;
            int theCoffeeBeans = 12;
            if (hasEnoughIngredients(theWater, theMilk, theCups, theCoffeeBeans)) {
                money += 6;
                haveResources = true;
            }

        } else if ("back".equals(coffeeChose)) {
            chooseAction();
        }

        if (haveResources) {
            System.out.println("I have enough resources, making you a coffee!");
        }

    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
        System.out.println();
        scanner.nextLine();
    }

    private static void take() {
        System.out.printf("I gave you $%d\n\n", money);
        money = 0;
    }

    private static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", coffeeBeans);
        System.out.printf("%d of disposable cups\n", cups);
        if (money > 0) {
            System.out.printf("$%d of money\n", money);
        } else {
            System.out.printf("%d of money\n", money);
        }

    }

    private static void exit() {
        writeAction = false;
    }

    private static boolean hasEnoughIngredients(int theWater, int theMilk, int theCups, int theCoffeeBeans) {

        boolean canMakeCoffee = true;

        if (CoffeeMachine.water - theWater < 0) {
            System.out.println("Sorry, not enough water!");
            canMakeCoffee = false;
        } else if (CoffeeMachine.milk - theMilk < 0) {
            System.out.println("Sorry, not enough milk!");
            canMakeCoffee = false;
        } else if (CoffeeMachine.cups - theCups < 0) {
            System.out.println("Sorry, not enough cups!");
            canMakeCoffee = false;
        } else if (CoffeeMachine.coffeeBeans - theCoffeeBeans < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            canMakeCoffee = false;
        } else if (canMakeCoffee){
            CoffeeMachine.water -= theWater;
            CoffeeMachine.milk -= theMilk;
            CoffeeMachine.cups -= theCups;
            CoffeeMachine.coffeeBeans -= theCoffeeBeans;
        }

        return canMakeCoffee;
    }


}
