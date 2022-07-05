/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *              Creates tracks that behaves like a stack.
 *              Uses an ArrayList under the hood.
 * 
 */

import java.util.*;

public class StackTracks<AnyType>{

    private ArrayList<AnyType> data;
    private int size;
    
    /**
     * @param capacity integer of desired capacity
     * <p>
     * Creates a StackTrack object with a specific capacity depending on track position
     * 
     */
    public StackTracks(int capacity){

        data = new ArrayList<AnyType>(capacity);
        size = 0;

    }
    /**
     * Returns True or False in respect to if the QueueTrack is empty
     */
    public boolean isEmpty() {

        if (data.size() == 0)
            return true;
        return false;
    }    

    /**
     * Method adds an AnyType object onto the stack and increments size
     * @param element is an object of Type AnyType
     */
    public void push(AnyType element) {

        data.add(element);
        size++;
    
    }
    /**
     * Method removes from the stack and decrements size
     */
    public AnyType pop() {
        size--;
        return data.remove(data.size()-1);
    }
    /**
     * Method returns the size of StackTrack
     */
    public int size(){
        return this.size; 
    }
    public Object getData(){
        return data;
    }
    /**
     * Method returns the element from the top of the stack
     */
    public AnyType peek(){
        return data.get(data.size()-1);
    }

}