import java.util.*;
public class MyQueue<AnyType> {

    private Object[] data;
    private int size;
    private int first;
    private int last;

    public MyQueue() {
        this(20);
    }

    public MyQueue(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
        this.first = 0;
        this.last = -1;
    }
    
    public void increaseCapacity()
    {
        int newsize = size + size / 2 + 1;
        Object[] newArray = new Object[newsize];
        int indexIntoOrig = first;
        int indexIntoNew = first;
        int numElementsCopied = 0;
        while (numElementsCopied <= size) {
            newArray[indexIntoNew] = data[indexIntoOrig];
            if (indexIntoOrig < data.length -1)
                indexIntoOrig++;
            else
                indexIntoOrig = 0;
            if (indexIntoNew < newArray.length -1)
                indexIntoNew++;
            else
                indexIntoNew = 0;
            numElementsCopied++;
        }
        data = newArray;
    }

    public void enqueue(AnyType element) {
        if ( ! (size < data.length -1) )
            increaseCapacity();

        if (last < data.length-1) {
           data[last+1] = element;
           last++;
        }
        else {
            data[0] = element;
            last = 0;
        }
        size++;
    }

    public AnyType dequeue() {
        AnyType temp = (AnyType)(data[first]);
        data[first] = null;
        if (first < data.length -1)
            first++;
        else
            first = 0;
        size--;
        return temp;
    }

    public AnyType peek() {

        return (AnyType)(data[first]);

    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        String returnval = "";
        returnval += "Size: " + size + " first: " + first + " last: " + last + "\n";
        for (int i=0; i< data.length; i++) {
            returnval += data[i] + " ";
        }
        returnval += "\n";
        return returnval;
    }

/** the following method added by C M Summa
*/
    @Override
    public boolean equals(Object otherQueue) {

        if (otherQueue instanceof MyQueue) {
            // compare the equality of the objects in this queue
            // and the other queue
            //System.out.println("The other thing is a queue");
            MyQueue oq = (MyQueue)otherQueue;
            int oqfirst = oq.first;
            int oqsize = oq.size;

            int myfirst = first;
            int mysize = size;

            if (oqsize != mysize) {
                //System.out.println("mysize: " + mysize);
                //System.out.println("oqsize: " + oqsize);
    
                return false;
            }
            //System.out.println("The other thing has the same size");
            int oqcurrent = oqfirst;
            int mycurrent = myfirst;
            //System.out.println("myfirst: " + myfirst + " oqfirst: " + oqfirst);
            int num=0;
            while (num < size) {
                //System.out.println(data[myfirst] + " " + oq.data[oqfirst]);
                if ( ! data[mycurrent].equals(oq.data[oqcurrent]) ) {
                    return false; 
                }
                num++;
                mycurrent++;
                if (mycurrent == data.length)
                    mycurrent = 0;
                oqcurrent++;
                if (oqcurrent == oq.data.length)
                    oqcurrent = 0;
            }
            return true;
        
        }
        return false;
    }

     /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
/*    public java.util.Iterator<AnyType> iterator( ){
        return new MyQueueIterator( );
    }

    private class MyQueueIterator implements java.util.Iterator<AnyType>{
        private MyQueue<AnyType> current;

        public MyQueueIterator(){
            this.current = MyQueue.this.first;
        }
        
        
        public boolean hasNext(){
            return (this.current == null);
        }

        public AnyType next(){
            if(!hasNext()){
               throw new java.util.NoSuchElementException(); 
            }
            this.current = this.peek();
            AnyType temp = this.
           
            return  
                 
        }
    }    */

} // end class
