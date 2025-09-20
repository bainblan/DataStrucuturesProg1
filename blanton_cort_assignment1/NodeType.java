package cs2720.p1;

public class NodeType{
    ItemType info;
    NodeType next;

    /**
     * Constructor to initialize a node with the given ItemType and null next reference.
     * 
     * @param item The ItemType object to be stored in the node.
     */
    public NodeType(ItemType item){
        this.info = item;
        this.next = null;
    }
}
