package cs2720.p1;

public class NodeType{
    ItemType info;
    NodeType next;

    public NodeType(ItemType item){
        this.info = item;
        this.next = null;
    }
}
