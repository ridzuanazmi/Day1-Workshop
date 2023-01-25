package Day01Workshop;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Workshop1 {

    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> cartItems = new ArrayList<String>(); // to store cart items
        boolean itemExist; // check if item exists

        String userAction = "";

        while (!(userAction == "quit")) {
            System.out.print("> "); // user prompt
            userAction = scanner.next(); // this is to get the first word from the input
            String items = scanner.nextLine(); // get the items
            // Replace the commas in the string with space to easily diffrentiate different
            // items
            String item = items.replace(",", " ");
            switch (userAction) {
                case "add":
                    String[] input = item.split(" ");
                    for (String itemString : input) {
                        itemExist = cartItems.contains(itemString);
                        if (!itemExist) {
                            cartItems.add(itemString);
                            System.out.println(itemString + " added to cart");
                        } else {
                            System.out.println("You have " + itemString +
                                    " in your cart");
                        }
                    }
                    break;

                case "quit":
                    return;

                case "list":
                    if (cartItems.isEmpty()) {
                        System.out.println("your cart is empty");
                    } else {
                        for (int i = 0; i < cartItems.size(); i++) {
                            System.out.println((i + 1) +". " + cartItems.get(i));
                        }
                    }
                default:
                    break;
            }
        }
    }
}
