package cs2720.p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Incorrect number of inputs");
            return;
        }

        SortedLinkedList list = new SortedLinkedList();

        try(Scanner s = new Scanner(newFile(args[0]))){
            while(s.hasNextInt()){
                list.insertItem(new ItemType(s.next()));
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }

        Scanner input = new Scanner(System.in);
        char command;

        while(command != 'q'){
            System.out.print("Enter command: ");
            command = input.next().charAt(0);

            if(command == 'i'){
                System.out.print("Enter a number to insert: ");
                int value = input.nextInt();
                ItemType item = new ItemType(value);
                System.out.println("Original list: " + list);
                if (list.searchItem(item)){
                    System.out.println("Item already exists");
                } else {
                    list.insertItem(item);
                    System.out.println("New list: " + list);
                }
            } else if(command =='s'){

                System.out.print("Enter a number to search: ");
                int value = input.nextInt();
                ItemType item = new ItemType(value);
                boolean found = list.searchItem(item);
                System.out.println("Original list: " + list);
                if(found){
                    System.out.println("The Item is present at index " + list.getIndex(item));
                } else {
                    System.out.println("Item is not present in the list");
                }

            } else if(command == 'a'){

                System.out.println("Original list: " + list);
                if (list.getLength() == 0){
                    System.out.println("The list is empty");
                    System.out.println("Modified list: " + list);
                } else {
                    list.deleteAlternateNodes();
                    System.out.println("New list: " + list);
                }

            } else if(command =='m'){

                System.out.print("Enter the length of the new list: ");
                int length = input.nextInt();
                System.out.print("Enter the numbers: ");
                SortedLinkedList other = new SortedLinkedList();
                for(int i = 0; i < length; i++){
                    int value = input.nextInt();
                    ItemType item = new ItemType(value);
                    other.insertItem(item);
                }
                System.out.println("List 1: " + list);
                System.out.println("List 2: " + other);
                list.mergeList(other);
                System.out.println("Merged list: " + list);

            } else if(command == 't'){
                System.out.println("Enter the length of the new list: ");
                int length = input.nextInt();
                System.out.print("Enter the numbers: ");
                SortedLinkedList other = new SortedLinkedList();
                for(int i = 0; i < length; i++){
                    int value = input.nextInt();
                    ItemType item = new ItemType(value);
                    other.insertItem(item);
                }
                System.out.println("List 1: " + list);
                System.out.println("List 2: " + other);
                list.intersection(other);
                System.out.println("Intersection of lists: " + list);      
            } else if(command == 'p'){
                System.out.println("The list is: " + list);
            } else if(command == 'l'){
                System.out.println("The length of the list is " + list.getLength());
            } else if(command == 'q'){
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid command, try again: ");
            }

        }

    }
}
