package cs2720.p1;

import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;

public class SortedLinkedList {
    
    private NodeType head;

    /**
     * Constructor to initialize an empty sorted linked list.
     */
    public SortedLinkedList() {
        head = null;
    }

    /**
     * Returns the length of the linked list.
     * 
     * @return The number of nodes in the linked list.
     */
    public int getLength() {
        int len = 0;
        NodeType curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    /**
     * Inserts an item into the sorted linked list while maintaining sorted order.
     * If the item already exists, an IllegalArgumentException is thrown.
     * 
     * @param item The ItemType object to be inserted.
     * @throws IllegalArgumentException if the item already exists in the list.
     */
    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType(item);

        if (head == null || head.info.compareTo(item) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        NodeType curr = head;
        NodeType prev = null;
        while (curr != null && curr.info.compareTo(item) < 0) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null && curr.info.compareTo(item) == 0) {
            throw new IllegalArgumentException("Item already exists");
        }

        prev.next = newNode;
        newNode.next = curr;

    }

    /**
     * Deletes an item from the linked list.
     * 
     * @param item The ItemType object to be deleted.
     * @throws IllegalStateException    if the list is empty.
     * @throws IllegalArgumentException if the item is not found in the list.
     */
    public void deleteItem(ItemType item) {
        if (head == null) {
            throw new IllegalStateException("You cannot delete from an empty list");
        }

        if (head.info.compareTo(item) == 0) {
            head = head.next; 
            return;
        }

        NodeType curr = head.next;
        NodeType prev = head;

        while (curr != null && curr.info.compareTo(item) != 0) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            throw new IllegalArgumentException("The item is not present in the list");
        }

        prev.next = curr.next;
    }

    /**
     * Searches for an item in the linked list and returns its index.
     * 
     * @param item The ItemType object to be searched.
     * @return The index of the item if found, otherwise -1.
     * @throws IllegalStateException if the list is empty.
     */
    public int searchItem(ItemType item) {
        if (head == null) {
            throw new IllegalStateException("The list is empty");
        }

        NodeType curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.info.compareTo(item) == 0) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        throw new IllegalArgumentException("Item is not present in the list");
    }

    /**
     * Deletes every alternate node in the linked list, starting from the second node.
     * 
     * @throws IllegalStateException if the list is empty.
     */
    public void deleteAlternateNodes() {
        if (head == null) {
            throw new IllegalStateException("The list is empty");
        }

        NodeType curr = head;
        NodeType prev = null;
        boolean delete = false;

        while (curr != null) {
            if (delete) {
                prev.next = curr.next;
                curr = curr.next;
                delete = false;
            } else {
                prev = curr;
                curr = curr.next;
                delete = true;
            }
        }
    }

    /**
     * @param other 
     * Merges the current sorted linked list with another sorted linked list 'other'.
     * The merged list is stored in the current list, maintaining sorted order and removing duplicates.
     */
    public void mergeList(SortedLinkedList other) {
        NodeType curr1 = this.head;     // 1
        NodeType curr2 = other.head;    // 1     
        SortedLinkedList merged = new SortedLinkedList(); // 1

        while (curr1 != null && curr2 != null) { // n
            if (curr1.info.compareTo(curr2.info) < 0) { // 1
                merged.insertItem(curr1.info);  // 1
                curr1 = curr1.next; // 1
            } else if (curr1.info.compareTo(curr2.info) > 0) { // 1
                merged.insertItem(curr2.info); // 1
                curr2 = curr2.next; // 1
            } else { 
                merged.insertItem(curr1.info); // 1
                curr1 = curr1.next; // 1
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            merged.insertItem(curr1.info);
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            merged.insertItem(curr2.info);
            curr2 = curr2.next;
        }

        this.head = merged.head;
    }

    /**
     * Modifies the current linked list to contain only the intersection of itself and another linked list 'other'.
     * 
     * @param other The other SortedLinkedList to intersect with.
     */
    public void intersection(SortedLinkedList other) {
        NodeType curr1 = this.head;
        NodeType curr2 = other.head;
        SortedLinkedList intersected = new SortedLinkedList();

        while (curr1 != null && curr2 != null) {
            if (curr1.info.compareTo(curr2.info) < 0) {
                curr1 = curr1.next;
            } else if (curr1.info.compareTo(curr2.info) > 0) {
                curr2 = curr2.next;
            } else {
                intersected.insertItem(curr1.info);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        this.head = intersected.head;
    }

    /**
     * Prints the elements of the linked list in order.
     */
    public void printList() {
        NodeType curr = head;
        while (curr != null) {
            System.out.print(curr.info.getValue() + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
