package cs2720.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of inputs");
            return;
        }
        SortedLinkedList list = new SortedLinkedList();

        try (Scanner s = new Scanner(new File(args[0]))) {
            while (s.hasNextInt()) {
                list.insertItem(new ItemType(s.nextInt()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        Scanner input = new Scanner(System.in);
        char command = ' ';

        while (command != 'q') {
            System.out.print("Enter command: ");
            command = input.next().charAt(0);
            while (command != 'q' && command != 'i' && command != 'd' && command != 'p'
                    && command != 'l' && command != 'm' && command != 't'
                    && command != 's' && command != 'a') {
                System.out.print("Invalid command try again: ");
                command = input.next().charAt(0);
            }
            if (command == 'q') {
                System.out.println("Exiting the program...");
            } else if (command == 'i') {
                iCalled(input, list);
            } else if (command == 'd') {
                dCalled(input, list);
            } else if (command == 's') {
                sCalled(input, list);
            } else if (command == 'a') {
                aCalled(input, list);
            } else if (command == 'm') {
                mCalled(input, list);
            } else if (command == 't') {
                tCalled(input, list);
            } else if (command == 'p') {
                System.out.print("The list is: ");
                list.printList();
            } else if (command == 'l') {
                System.out.println("The length of the list is " + list.getLength());
            }
        }
        input.close();
    }

    /**
     * Handles the insert command by prompting the user for a number, inserting it into the list,
     * and displaying the original and new list.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the insertion on.
     */
    public static void iCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Enter a number to insert: ");
        int value = input.nextInt();
        ItemType item = new ItemType(value);
        System.out.print("Original list: ");
        list.printList();
        try {
            list.insertItem(item);
            System.out.print("New list: ");
            list.printList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("New list: ");
            list.printList();
        }
    }

    /**
     * Handles the delete command by prompting the user for a number, deleting it from the list,
     * and displaying the original and new list.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the deletion on.
     */
    public static void dCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Enter a number to delete: ");
        int value = input.nextInt();
        ItemType item = new ItemType(value);
        try {
            System.out.print("Original list: ");
            list.printList();
            list.deleteItem(item);
            System.out.print("New list: ");
            list.printList();
        } catch (IllegalArgumentException e) {
            System.out.print("Original list: ");
            list.printList();
            System.out.println(e.getMessage());
            System.out.print("New list: ");
            list.printList();

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the search command by prompting the user for a number, searching for it in the list,
     * and displaying the index if found or an error message if not found.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the search on.
     */
    public static void sCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Enter a number to search: ");
        int value = input.nextInt();
        ItemType item = new ItemType(value);
        System.out.print("Original list: ");
        list.printList();
        try {
            System.out.println("The Item is present at index " + list.searchItem(item));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the merge command by prompting the user for a new list, merging it with the existing list,
     * and displaying both lists and the merged result.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the merge on.
     */
    public static void mCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Enter the length of the new list: ");
        int length = input.nextInt();
        System.out.print("Enter the numbers: ");
        SortedLinkedList other = new SortedLinkedList();
        for (int i = 0; i < length; i++) {
            int value = input.nextInt();
            ItemType item = new ItemType(value);
            other.insertItem(item);
        }
        System.out.print("List 1: ");
        list.printList();
        System.out.print("List 2: ");
        other.printList();
        list.mergeList(other);
        System.out.print("Merged list: ");
        list.printList();
    }

    /**
     * Handles the delete alternate nodes command by displaying the original list,
     * deleting alternate nodes, and displaying the modified list.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the deletion of alternate nodes on.
     */
    public static void aCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Original list: ");
        list.printList();
        try {
            list.deleteAlternateNodes();
            System.out.println("New list: ");
            list.printList();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Modified list: ");
            list.printList();
        }
    }

    /**
     * Handles the intersection command by prompting the user for a new list, finding the intersection with the existing list,
     * and displaying both lists and the intersection result.
     * 
     * @param input The Scanner object for user input.
     * @param list  The SortedLinkedList to perform the intersection on.
     */
    public static void tCalled(Scanner input, SortedLinkedList list) {
        System.out.print("Enter the length of the new list: ");
        int length = input.nextInt();
        System.out.print("Enter the numbers: ");
        SortedLinkedList other = new SortedLinkedList();
        for (int i = 0; i < length; i++) {
            int value = input.nextInt();
            ItemType item = new ItemType(value);
            other.insertItem(item);
        }
        System.out.print("List 1: ");
        list.printList();
        System.out.print("List 2: ");
        other.printList();
        list.intersection(other);
        System.out.print("Intersection of lists: ");
        list.printList();
    }
}
