/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 * 				Class 
 * 
 */
import java.util.Queue;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Heapiness<AnyType> {

        BinaryHeap<Integer> a;
        BinaryHeap<Integer> b;
        BinaryHeap<Integer> c;
        Iterator<Integer> natItr;
        MyQueue<Integer> natList;
        MyQueue<Integer> revList;
        MyQueue<Integer> randList;
        Integer [] natOrder;
        Integer [] revOrder;
        Integer [] randOrder;
        ArrayList<Integer> natural;
        ArrayList<Integer> reversed;
        ArrayList<Integer> random;

        public int dataAmount;
        public int max = 5000000;
        public int min = 1;


    // public void makeBinaryHeap(AnyType ){
        
    //     int heapSize = number;
    //     BinaryHeap<AnyType> a = new BinaryHeap<>(heapSize);

    // }

    public Heapiness(int number){

        this.dataAmount = number;
        this.natList = new MyQueue<Integer>(dataAmount);
        this.revList = new MyQueue<Integer>(dataAmount);
        this.randList = new MyQueue<Integer>(dataAmount);
        this.natural = new ArrayList<Integer>(dataAmount);
        this.reversed = new ArrayList<Integer>(dataAmount);
        this.random = new ArrayList<Integer>(dataAmount);
        this.natOrder = new Integer[dataAmount];
        this.revOrder = new Integer[dataAmount];
        this.randOrder = new Integer[dataAmount];

    }

    public void makeLists(int number){
        this.makeNatList(number);
        //System.out.println(natList.toString());
        this.makeRevList(number);
        this.makeRandList(number);
    }

    public void runOnebyOneNat(int size){
        int heapSize = size;
        int currentInt;
        a = new BinaryHeap<Integer>(heapSize);
        for(int i = 0; i < heapSize; i++){
            currentInt = (int) natList.dequeue();
            a.insert(currentInt);
        }
    }

    public void runOnebyOneRev(int size){
        int heapSize = size;
        int currentInt;
        b = new BinaryHeap<Integer>(heapSize);
        for(int i = 0; i < heapSize; i++){
            currentInt = (int) revList.dequeue();
            b.insert(currentInt);
        }
    }

    public void runOnebyOneRand(int size){
        int heapSize = size;
        int currentInt;
        c = new BinaryHeap<Integer>(heapSize);
        for(int i = 0; i < heapSize; i++){
            currentInt = (int) randList.dequeue();
            c.insert(currentInt);
        }
    }

    public int getDataAmount(){
        return this.dataAmount;
    }

    public void makeNatList(int number){

        int currentCap = number;
        for (int i = 0; i < currentCap; i++) {
            this.natList.enqueue((i));
        }    
        //System.out.println(natList.toString());
    }

    public void makeRevList(int number){

        int currentCap = number;
        for (int i = currentCap; i >= 0; i--) {
            this.revList.enqueue((i));
        }
        //System.out.println(this.toString());
    }

    public void makeRandList(int number){

        int currentCap = number;
        for (int i = 0; i < currentCap; i++) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            this.randList.enqueue((random_int));
        }
        //System.out.println(this.toString());
    }

    public void makeNatOrder(int number){
        
        int currentCap = number;
        for (int i = 0; i < currentCap; i++) {
            this.natural.add((i));
        } 
        this.natOrder = natural.toArray(new Integer[0]);   
        //System.out.println(natList.toString());
    }

    public void makeRevOrder(int number){
        
        int currentCap = number;
        for (int i = currentCap; i >= 0; i--) {
            this.reversed.add((i));
        }
        this.revOrder = reversed.toArray(new Integer[0]);
        //System.out.println(this.toString());
    }

    public void makeRandOrder(int number){
        
        int currentCap = number;
        for (int i = 0; i < currentCap; i++) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            this.random.add((random_int));
        }
        this.randOrder = random.toArray(new Integer[0]);
        //System.out.println(this.toString());
    }

    public Integer [] getNatOrder(){
        return this.natOrder;
    }

    public Integer [] getRevOrder(){
        return this.revOrder;
    }

    public Integer [] getRandOrder(){
        return this.randOrder;
    }

     @Override
    public String toString(){
        
        return(getDataAmount()+ " amount of balls ");
    }
}