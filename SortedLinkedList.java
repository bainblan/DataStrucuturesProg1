package cs2720.p1;

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
            throw new IllegalArgumentExcpetion("Item already exists");
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

    }

    public void mergeList(SortedLinkedList other){

    }

    public void intersection(SortedLinkedList other){

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
