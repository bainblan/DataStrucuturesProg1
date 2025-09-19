package cs2720.p1;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;

public class SortedLinkedList {
    private NodeType head;

    public SortedLinkedList(){
        head = null;
    }

    public int getLength(){
        int len = 0;
        NodeType curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    public void insertItem(ItemType item){
        NodeType newNode = new NodeType(item);

        if(head == null || head.info.compareTo(item) > 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        NodeType curr = head;
        NodeType prev = null;
        while(curr != null && curr.info.compareTo(item) < 0){
            prev = curr;
            curr = curr.next;
        }

        if(curr != null && curr.info.compareTo(item) == 0){
            throw new IllegalArgumentException("Item already exists");
        }

        prev.next = newNode;
        newNode.next = curr;

    }

    public void deleteItem(ItemType item){
        if(head == null){
            throw new IllegalArgumentException("No items to delete");
        }

        if(head.info.compareTo(item) == 0){
            head = null;
        }

        NodeType curr = head;
        NodeType prev = null;

        while(curr.info.compareTo(item) != 0){
            prev = curr;
            curr = curr.next;
        }

        if(curr.info.compareTo(item) == 0){
            prev.next = curr.next;
            return;
        }

        if(curr.next == null){
            throw new IllegalArgumentException("Item does not exist");
        }
    }

    public int searchItem(ItemType item){
        if(head == null){
            throw new IllegalStateException("The list is empty");
        }

        NodeType curr = head;
        int index = 0;

        while(curr !=null){
            if(curr.info.compareTo(item) == 0){
                return index;
            }

            curr = curr.next;
            index++;
        }

        throw new IllegalArgumentException("Item does not exist");
    }

    public void deleteAlternateNodes(){
        if(head == null || head.next == null){
            return;
        }

        NodeType curr = head;
        NodeType prev = null;
        boolean delete = false;

        while(curr != null){
            if(delete){
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

    public void mergeList(SortedLinkedList other){
        NodeType curr1 = this.head;
        NodeType curr2 = other.head;
        SortedLinkedList merged = new SortedLinkedList();

        while(curr1 != null && curr2 != null){
            if(curr1.info.compareTo(curr2.info) < 0){
                merged.insertItem(curr1.info);
                curr1 = curr1.next;
            } else if(curr1.info.compareTo(curr2.info) > 0){
                merged.insertItem(curr2.info);
                curr2 = curr2.next;
            } else {
                merged.insertItem(curr1.info);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        while(curr1 != null){
            merged.insertItem(curr1.info);
            curr1 = curr1.next;
        }

        while(curr2 != null){
            merged.insertItem(curr2.info);
            curr2 = curr2.next;
        }

        this.head = merged.head;
    }

    public void intersection(SortedLinkedList other){
        NodeType curr1 = this.head;
        NodeType curr2 = other.head;
        SortedLinkedList intersected = new SortedLinkedList();

        while(curr1 != null && curr2 != null){
            if(curr1.info.compareTo(curr2.info) < 0){
                curr1 = curr1.next;
            } else if(curr1.info.compareTo(curr2.info) > 0){
                curr2 = curr2.next;
            } else {
                intersected.insertItem(curr1.info);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        this.head = intersected.head;
    }

    public void printList(){
        NodeType curr = head;
        while(curr != null){
            System.out.print(curr.info.getValue() + " ");
            curr=curr.next;
        }
        System.out.println();
    }
}
