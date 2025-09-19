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

        SortedLinkedList = new SortedLinkedList();

        try(Scanner s = new Scanner(newFile(args[0]))){
            while(s.hasNextInt()){
                list.insertItem(new ItemType(s.next()));
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }

        Scanner in = new Scanner(System.in);
        char command;

        while(command != 'q'){
            System.out.print("Enter command: ");
            command = input.next().charAt(0);

            if(command == 'i'){

            } else if(command =='s'){

            } else if(command == 'a'){

            } else if(command =='m'){

            } else if(command == 't'){

            } else if(command == 'p'){
                list.printList();
            } else if(command == 'l'){
                System.out.println("The length of the list is " + list.getLength());
            } else if(command == 'q'){
                System.out.println("Exiting program");
            } else {
                System.out.println("Invalid command, try again!");
            }

        }

    }
}
