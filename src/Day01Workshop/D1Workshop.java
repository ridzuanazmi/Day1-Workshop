package Day01Workshop;

import java.util.ArrayList;
import java.util.Scanner;
/*
* So basically we need an arraylist that can add, remove, and list items inside
* need a menu to show the available commands that the user can input
* need a loop so the user can keep adding stuff and update the cartItems if remove
* or add
* > list Your cartItems is empty 
* > add apple 
* apple added to cartItems 
* > add orange, pear 
* orange added to cartItems pear added to cartItems 
* > list 
* 1. apple 
* 2. orange 
* 3. pear 
* delete 2 
* orange removed from cartItems
*/

public class D1Workshop {
    // create Scanner class called scanner that can be used
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> cartItems = new ArrayList<>();
        String[] inputArray;
        boolean flag = true;
        boolean checkItem;
        String[] items;
        int itemIndex;

        String command;
        loop: while (flag) {
            // instantiate an ArrayList called cartItems to store our items

            // prints menu and get command from user input
            printMenu();
            command = scanner.nextLine();
            inputArray = command.split(" ");

            switch (inputArray[0]) {
                case "list":
                    if (cartItems.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (int i = 0; i < cartItems.size(); i++) {
                            System.out.println((i + 1) + ". " + cartItems.get(i));
                        }
                    }
                    break;

                case "add":
                    items = inputArray[1].split(",");
                    for (String item : items) {
                        checkItem = cartItems.contains(item); // check to see if arraylist cartItems contains item
                        if (!checkItem) {
                            cartItems.add(item);
                            System.out.println(item + " added to cart");
                        } else {
                            System.out.println("You have " + item + " already in cartItems");
                        }
                    }
                    break;

                case "remove":
                    try {
                        itemIndex = Integer.parseInt(inputArray[1]) - 1;
                        if (itemIndex < 0 || itemIndex >= cartItems.size()) {
                            throw new IndexOutOfBoundsException();
                        }
                        System.out.println(cartItems.get(itemIndex) + " removed from cartItems");
                        cartItems.remove(itemIndex);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Incorrect item itemIndex");
                    } catch (NumberFormatException e) {
                        System.out.println("Index must be a number");
                    }
                    break;

                case "quit":
                    break loop;

                default:
                    System.out.println("Unknow command please re-enter");
                    break;
            }

        } // end of while

    } // end of main

    private static void printMenu() {
        System.out.print("""
                ---------------Welcome to your shopping cartItems---------------
                Type in what you want to do
                list
                add
                remove
                quit
                Enter command: > """);
    }// end of printMenu
}
