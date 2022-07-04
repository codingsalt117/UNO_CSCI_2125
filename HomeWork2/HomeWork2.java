/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *              Main Class runs a Ball Clock. Scanner takes a command line .txt file argument
 * 
 */

import java.util.*;

public class HomeWork2{

    public static void main(String[] args) {
        String output;
        boolean keepgoing = true;

        Scanner input = new Scanner(System.in);
        
        
        
        while (input.hasNextInt()){
            if(input.hasNextInt()){
                int start = input.nextInt();
                Clock runningClock = new Clock(start);
                runningClock.run(start);  
            
                output = runningClock.toString();
            
                System.out.println(output);
            }
            else{
                break;
            }
        }
    }
}