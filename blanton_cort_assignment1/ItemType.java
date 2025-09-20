package cs2720.p1;

public class ItemType{
    private int value;

    public ItemType(int value){
        this.value = value;
    }

    public int compareTo(ItemType item){
        if(this.value > item.value){
            return 1;
        } else if(this.value < item.value){
            return -1;
        } else {
            return 0;
        }
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int num){
        this.value = num;
    }
}
