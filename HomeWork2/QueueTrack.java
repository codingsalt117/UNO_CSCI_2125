/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *              Creates tracks that behaves like a queue.
 *              Uses an ArrayList.
 */
import java.util.*;
public class QueueTrack<AnyType>{
    private ArrayList<AnyType> data;
    int size;
    /**
     * Constructor that makes a QueueTrack, has an array list and a size
     * @param capacity the capacity the QueueTrack
     */
    public QueueTrack(int capacity){

        data = new ArrayList<AnyType>(capacity);
        size = 0;

    }
    /**
     * Method returns a boolean depoending if the QueueTrack is empty or not.
     */
    public boolean isEmpty() {

        if (data.size() == 0){
            return true;
        }
        return false;
    
    }
    /**
     * Method adds an element to the QueueStack and increments size
     * @param element AnyType object
     */
    public void enqueue(AnyType element) {

        data.add(element);
        size++;
    
    }
    /**
     * Method removes and AnyType object from QueueTrack and decrements size
     */
    public AnyType dequeue() {
        
        size--;
        return data.remove(0);
        
    }
    /**
     *  Method returns an AnyType object at index 0
     */
    public AnyType peek(){
        return data.get(0);
    }

    public AnyType peekIndex(int index){
        return data.get(index);
    }
    /**
     * Method returns an int size of a QueueTrack
     */    
    public int size(){
        return this.size;
    }
    /**
     * Method returns the data of the QueueTrack
     */    
    public ArrayList<AnyType> getData(){
        return data;
    }

    public void setData(ArrayList<AnyType> data) {
        this.data = new ArrayList<AnyType>();
        for (int i = 0; i < data.size(); i++) {
            this.data.add(data.get(i));
        }
    }
    /**
     * Overrided method to return a boolean if the the calling object is equal to passed object
     * @param object is of type Object
     */
    @Override
    public boolean equals(Object object){
        //check if passed objecty is an instance of calling object
        if (object instanceof QueueTrack){
            QueueTrack a = (QueueTrack) object;
                //checking if the data is the same
                if (getData().equals(a.getData())){
                    return true;
                }
           
        }
        // if not an instance of or objects not equal
        return false;    
    }
}