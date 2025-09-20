Compile: javac -d bin *.java
Run: java -cp bin cs2720.p1.LinkedListDriver input.txt

Baines Blanton and Caleb Cort collaborated on this project

Baines.Blanton@uga.edu
Caleb.Cort@uga.edu

Baines's Contribution: deleteAlternate, mergeList, and intersection methods, as well as the if statements for the 1 character commands in the driver class.
Caleb's Contribution: Everything else.

Merge operation Big O: O(n + m)
Explanation: 
-The while loop runs n times, as long as the shorter list.
-In the loop, inserting an item into merged is O(m) because it has to traverse through the linked list
-The other operations within the loop are assignments and comparisons, so O(1), but at most O(n)
-With each loop iteration, O(m + n)
-n is the length of the first list and m is the length of the second.

mergeList(SortedLinkedList other) 
-set curr1 and curr2 equal to the head of the current and other list respectively
-Make new empty sorted list named merged
-while both lists not empty:
    -if 1st less than 2nd,
        insert 1st item into merged. Next curr1.
    -else if 1st more than 2nd,
        insert 2nd item into merged. Next curr2.
    -else if 1st and 2nd are equal value,
        insert 1st item into merged. Next curr1 and curr2
-loop through the rest of curr1
    -Add it to merged
-loop through the rest of curr2
    -Add it to merged
-The main list is now set to the merged list