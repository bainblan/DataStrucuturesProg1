package cs2720.p1;

public class ItemType{
    private int value;

    /**
     * Constructor to initialize an ItemType with the given integer value.
     * 
     * @param value The integer value to be stored in the ItemType.
     */
    public ItemType(int value){
        this.value = value;
    }

    /**
     * Compares this ItemType with another ItemType.
     * 
     * @param item The ItemType to compare with.
     * @return A positive integer if this ItemType is greater, a negative integer if less, and zero if equal.
     */
    public int compareTo(ItemType item){
        if(this.value > item.value){
            return 1;
        } else if(this.value < item.value){
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the integer value of this ItemType.
     * 
     * @return The integer value.
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Sets the integer value of this ItemType.
     * 
     * @param num The new integer value to be set.
     */
    public void setValue(int num){
        this.value = num;
    }
}
