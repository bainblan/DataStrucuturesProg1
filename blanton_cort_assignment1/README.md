This README file does not format in Github the way it does when I'm editing the text, so just keep that in mind if everything looks smushed together

Compile: javac -d bin *.java
Run: java -cp bin cs2720.p1.LinkedListDriver input.txt

Baines Blanton and Caleb Cort collaborated on this project

Baines.Blanton@uga.edu

Caleb.Cort@uga.edu

Baines's Contribution: deleteAlternate, mergeList, and intersection methods, as well as the if statements and methods called by them for the 1 character commands in the driver class.
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

Intersection operation Big O: O(n^2)
Explanation: 
-The intersection loop runs at most n + m times.
-Each insertItem could itself run up to O(k) where k is the size of the growing intersection list.
-In the worst case, there could be O(n) insertions, each costing up to O(n) >= O(n^2).
If lists barely overlap, meaning few insertions, then the runtime is closer to O(n + m).
-Very similar structure to mergeList.
-However, worst-case scenario, if we're assuming the two lists are approximately similar length,
-Then O(n^2) would be the Big O.


intersection(SortedLinkedList other)
-set curr1 and curr2 equal to the head of their respective lists
-create new intersected SortedLinkedList
-while both lists aren't empty
    -if 1st less than 2nd
        next Node in 1st list
    -if 1st more than 2nd 
        next Node in 2nd list
    -else if 1st equals 2nd
        insert 1st into intersection
        Next node in both lists
-The main list is set to intersected