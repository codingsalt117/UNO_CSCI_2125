/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 * 				Class uses other classes to time adding to build heap one by one and using a binaryHeap method in BinaryHeap class
 * 					Adds to heaps using multiple data orders: natural, reversed and random.
 * 						adds these types of data ordering at 8 different data amounts.
 * 				Class times these actions and prints out to terminal in a trio group.
 * 
 */

import java.util.*;
import java.util.Iterator;
import java.util.Queue;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main{

    final static int NUM_N = 8;
	    
	public static void main(String [] args) throws InterruptedException{

		Queue<Integer> nValues = new LinkedList<Integer>();
		Queue<Integer> nValues2 = new LinkedList<Integer>();
        nValues.add(25000);
        nValues.add(75000);
        nValues.add(125000);
        nValues.add(500000);
        nValues.add(1000000);
        nValues.add(1500000);
        nValues.add(2000000);
        nValues.add(3000000);
        nValues2.add(25000);
        nValues2.add(75000);
        nValues2.add(125000);
        nValues2.add(500000);
        nValues2.add(1000000);
        nValues2.add(1500000);
        nValues2.add(2000000);
        nValues2.add(3000000);

        String nValuesOutput = nValues.toString();
        System.out.println(" Values of N ");
        System.out.println(nValuesOutput);
        //Boolean work = false;
        //Scanner input = new Scanner(System.in);
		String listOut;
		Iterator<Integer> itr = nValues.iterator();

		System.out.println("\n");
	    System.out.println("Natural, Reversed, and Random Order 1 by 1 Insert Times: ");
	    while(itr.hasNext()){
	    	int in = itr.next();
	    	//System.out.println(in);
			Heapiness timeTrial = new Heapiness(in);
			//System.out.println(timeTrial.getDataAmount());
			timeTrial.makeLists(in);
			//listOut = timeTrial.toString();
			//System.out.println(listOut);
			long start = System.nanoTime();
			timeTrial.runOnebyOneNat(in);
			long end = System.nanoTime();
			long msElapsed = (end - start) / 1000000;
			System.out.println("Natural Exec time in milliseconds: " + msElapsed);
			
			start = System.nanoTime();
            timeTrial.runOnebyOneRev(in);
            end = System.nanoTime();
            msElapsed = (end - start) / 1000000;
            System.out.println("Reverse Exec time in milliseconds: " + msElapsed);

			start = System.nanoTime();
            timeTrial.runOnebyOneRand(in);
            end = System.nanoTime();
            msElapsed = (end - start) / 1000000;
            System.out.println("Random Exec time in milliseconds:  " + msElapsed);

	    }

	    Iterator<Integer> itr2 = nValues2.iterator();
	    System.out.println("\n");
	    System.out.println("Natural, Reversed, and Random Order buildHeap Insert Times: ");
	    while(itr2.hasNext()){
	    	int in2 = itr2.next();
	    	Heapiness timeTrial2 = new Heapiness(in2);
	    	timeTrial2.makeNatOrder(in2);
	    	timeTrial2.makeRevOrder(in2);
	    	timeTrial2.makeRandOrder(in2);
	    	long start = System.nanoTime();
	    	BinaryHeap a = new BinaryHeap<>(timeTrial2.getNatOrder());
	    	long end = System.nanoTime();
            long msElapsed = (end - start) / 1000000;
            System.out.println("Natural Exec time in milliseconds: " + msElapsed);

            start = System.nanoTime();
            BinaryHeap b = new BinaryHeap<>(timeTrial2.getRevOrder());
            end = System.nanoTime();
            msElapsed = (end - start) / 1000000;
            System.out.println("Reverse Exec time in milliseconds: " + msElapsed);

            start = System.nanoTime();
            BinaryHeap c = new BinaryHeap<>(timeTrial2.getRandOrder());
            end = System.nanoTime();
            msElapsed = (end - start) / 1000000;
            System.out.println("Random Exec time in milliseconds:  " + msElapsed);

	    }

	}// end of main method

}// end of main class