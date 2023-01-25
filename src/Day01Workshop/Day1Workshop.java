package Day01Workshop;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Workshop {

    public static void main(String[] args) {
        System.out.println("-------------------- Welcome to your shopping cart --------------------");
        System.out.println("<list> <add 'objects'> <remove 'objects' number> or <quit> to exit program");
        ArrayList<String> cart = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String userInput;
        String[] inputArray;
        String[] items;
        boolean itemExist;
        int index;

        System.out.println("Welcome to your shopping cart");

        while (true) {
            System.out.print("> ");
            userInput = input.nextLine();
            inputArray = userInput.split(" ");

            switch (inputArray[0]) {
                case "list":
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.println((i + 1) + ". " + cart.get(i));
                        }
                    }
                    break;
                case "add":
                    items = inputArray[1].split(",");
                    for (String item : items) {
                        itemExist = cart.contains(item);
                        if (!itemExist) {
                            cart.add(item);
                            System.out.println(item + " added to cart");
                        } else {
                            System.out.println("You have " + item + " in your cart");
                        }
                    }
                    break;
                case "delete":
                    try {
                        index = Integer.parseInt(inputArray[1]) - 1;
                        if (index < 0 || index >= cart.size()) {
                            throw new IndexOutOfBoundsException();
                        }
                        System.out.println(cart.get(index) + " removed from cart");
                        cart.remove(index);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Incorrect item index");
                    } catch (NumberFormatException e) {
                        System.out.println("Index must be a number");
                    }
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        /*
         * List<String> cartItems = new ArrayList<String>();
         * 
         * Scanner scanner = new Scanner(System.in);
         * Console console = System.console();
         * String input = "";
         * 
         * while (!input.equals("quit")) {
         * input =
         * console.readLine("Key in action from above. Type quit to exit program");
         * 
         * switch (input) {
         * case "list":
         * listItems();
         * break;
         * 
         * default:
         * break;
         * 
         * }
         * }
         */
    } // end of main

    public static void listItems(ArrayList<String> cartItems) {
        if (cartItems.size() > 0) {
            for (int i = 0; i < cartItems.size(); i++) {
                System.out.println(cartItems.get(i));
            }
        } else {
            System.out.println("Your cart is empty");
        }
    } // end of listItems method

    public static void addItem() {

    } // end of addItem method

    public static void removeItem() {

    } // end of removeItem method
}
