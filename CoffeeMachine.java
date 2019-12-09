import java.util.Scanner;

public class CoffeeMachine {

    public static void print(int water, int milk, int beans, int cups) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " grams of coffee beans");
        System.out.println(cups + " pices of disposable cups");
    }

    public static boolean isEnough(String type, int water, int milk, int beans, int cups) {
        boolean enough = false;

        int waterLimit;
        int milkLimit;
        int beansLimit;

        switch (type) {
            case "1": // espresso
                waterLimit = 250;
                milkLimit = 0;
                beansLimit = 16;
                break;
            case "2": // latte
                waterLimit = 350;
                milkLimit = 75;
                beansLimit = 20;
                break;
            case "3": // cappuccino
                waterLimit = 200;
                milkLimit = 100;
                beansLimit = 12;
                break;
            default:
                return false;
        }
        if (water < waterLimit) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkLimit) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansLimit) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            enough = true;
            System.out.println("Your coffee is ready! Enjoy it!");
        }
        return enough;
    }

    public static void main(String[] args) {

        int water = 1000;
        int milk = 1000;
        int beans = 120;
        int cups = 10;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Write action (\"buy\", \"fill\", \"remaining\", \"exit\"): ");
            String command = scanner.next();
            System.out.println();

            switch (command) {
                case "buy":
                    System.out.print("What do you want to buy? \npress 1 - espresso, press 2 - latte, press 3 - cappuccino, " +
                            "\npress \"back\" - to main menu: ");
                    String type = scanner.next();
                    boolean enough = isEnough(type, water, milk, beans, cups);

                    switch (type) {
                        case "1": // espresso
                            if (enough) {
                                water -= 250;
                                beans -= 16;
                                cups -= 1;
                            }
                            break;
                        case "2": // latte
                            if (enough) {
                                water -= 250;
                                milk -= 50;
                                beans -= 20;
                                cups -= 1;
                            }
                            break;
                        case "3": // cappuccino
                            if (enough) {
                                water -= 200;
                                milk -= 100;
                                beans -= 11;
                                cups -= 1;
                            }
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("Unknown command! Please try again!");
                            break;
                    }
                    break;
                case "fill":
                    System.out.print("Write how many ml of water do you want to add: ");
                    water = scanner.nextInt();
                        if (water > 2000){
                            System.out.println("The quantity is too much! Please insert a value less than 2000.");
                            water = scanner.nextInt();
                        }else{
                            water += scanner.nextInt();
                        }
                    System.out.print("Write how many ml of milk do you want to add: ");
                    milk = scanner.nextInt();
                    if (milk > 1500){
                        System.out.println("The quantity is too much! Please insert a value less than 1500.");
                        milk = scanner.nextInt();
                    }else{
                        milk += scanner.nextInt();
                    }
                    System.out.print("Write how many grams of coffee beans do you want to add: ");
                    beans = scanner.nextInt();
                    if (beans > 300){
                        System.out.println("The quantity is too much! Please insert a value less than 300.");
                        beans = scanner.nextInt();
                    }else{
                        beans += scanner.nextInt();
                    }
                    System.out.print("Write how many disposable cups of coffee do you want to add: ");
                    cups = scanner.nextInt();
                    if (cups > 100){
                        System.out.println("The quantity is too much! Please insert a value less than 100.");
                        cups = scanner.nextInt();
                    }else{
                        cups += scanner.nextInt();
                    }
                    break;

                case "remaining":
                    print(water, milk, beans, cups);
                    break;
                case "exit":
                    System.out.println("Have a nice day!");
                    return;
                default:
                    System.out.println("Unknown command! Please try again!");
                    break;
            }
            System.out.println();
        }
    }
}
