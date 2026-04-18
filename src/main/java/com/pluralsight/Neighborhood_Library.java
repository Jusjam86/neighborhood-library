package com.pluralsight;

import java.util.Scanner;

public class Neighborhood_Library {

    public static void main(String[] args) {

        // Inventory of books
        // -----------------------
        Book[] inventory = {
                new Book(1, "978-1591162209", "Meiji Swordsman Romantic Story"),
                new Book(2, "978-1591162490", "The Two Hitokiri"),
                new Book(3, "978-1591162506", "A Reason to Act"),
                new Book(4, "978-1591162513", "Dual Conclusions"),
                new Book(5, "978-1591163206", "The State of Meiji Swordsmanship"),
                new Book(6, "978-1591163565", "No Worries"),
                new Book(7, "978-1591163572", "In the 11th Year of Meiji, May 14th"),
                new Book(8, "978-1591165637", "On the East Sea Road"),
                new Book(9, "978-1591166696", "Arrival in Kyoto"),
                new Book(10, "978-1591167037", "Mitsurugi, Master and Student"),
                new Book(11, "978-1591167099", "Overture to Destruction"),
                new Book(12, "978-1591167129", "The Great Kyoto Fire"),
                new Book(13, "978-1591167136", "A Beautiful Night"),
                new Book(14, "978-1591167679", "The Time is Now"),
                new Book(15, "978-1591168102", "The Great Man vs. The Giant"),
                new Book(16, "978-1591168546", "Providence"),
                new Book(17, "978-1591168768", "The Age Decides the Man"),
                new Book(18, "978-1591169598", "Do You Still Bear the Scar?"),
                new Book(19, "978-1591169277", "Shades of Reality"),
                new Book(20, "978-1421500645", "Remembrance"),
                new Book(21, "978-1421500829", "And So, Time Passed"),
                new Book(22, "978-1421501963", "Battle on Three Fronts"),
                new Book(23, "978-1421502762", "Sin, Judgement, Acceptance"),
                new Book(24, "978-1421503387", "The End of Dreams"),
                new Book(25, "978-1421504070", "The Truth"),
                new Book(26, "978-1421506739", "A Man's Back"),
                new Book(27, "978-1421506746", "The Answer"),
                new Book(28, "978-1421506753", "Toward a New Era")
        };

        Scanner userInput = new Scanner(System.in);
        int selectedOption;

        // This is the home screen loop
        // -------------------------------
        do {
            System.out.println();
            System.out.println("Welcome to the Grand Archives, Stranger!");
            System.out.println("=============================================");
            System.out.println("Got somethin' that might interest ya!");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit Menu");
            System.out.println("=============================================");
            System.out.print("Enter your selection: ");
//          System.out.println("Needin' a book to suit your specific needs, oho! It's a thing of beauty, innit?");
            selectedOption = Integer.parseInt(userInput.nextLine());

            switch (selectedOption) {
                case 1:
                    showAvailableBooks(inventory, userInput);
                    break;
                case 2:
                    showCheckedOutBooks(inventory, userInput);
                    break;
                case 3:
                    System.out.println("\nThank you for using our library. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a valid option of 1 - 3.");
                    break;
            }
        } while (selectedOption != 3);

        userInput.close();
    }

    // This shows all available books (not checked out)
    // ----------------------------------------------------
    public static void showAvailableBooks(Book[] inventory, Scanner userInput) {

        System.out.println("\n==============================");
        System.out.println("        Available Books");
        System.out.println("================================");
        System.out.printf("%5s %-20 %-30s%n", "ID", "ISBN", "Title");
        System.out.println("-".repeat(55));

        // Loop through and print only books that are "NOT" checked out
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].isCheckedOut()) {
                System.out.printf("%-5d %-20s %-30s%n",
                        inventory[i].getId(),
                        inventory[i].getIsbn(),
                        inventory[i].getTitle());
            }
        }

        System.out.println("\nEnter a Book ID to checkout, or 0 to go back: ");
        System.out.println("Enter your selection: ");
        int choice = Integer.parseInt(userInput.nextLine());

        // Goes back to the main menu
        if (choice == 0) {
            return;
        }

        // Search for book by ID and check it out
        boolean found = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getId() == choice) {
                found = true;
                if (!inventory[i].isCheckedOut()) {
                    System.out.print("Enter you name: ");
                    String name = userInput.nextLine();
                    inventory[i].checkOut(name);
                    System.out.println("\n\"" + inventory[i].getTitle() + "\" has been checked out to " + name + ".");
                }
                else {
                    System.out.println("\nSorry, that book is already checked out.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("\nNo book with that ID was found.");
        }
    }

}
