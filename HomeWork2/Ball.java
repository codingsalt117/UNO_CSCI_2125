/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 * 				Class Ball creates ball objects
 * 
 */


public class Ball{
	 
	public int ballNum;
    /**
     * Ball constructor makes a ball object with an int variable of number
     * @param number is an int representing a ball
     */
	public Ball(int number){

		ballNum = number;

	}
    /**
     * Returns the int ball number
     */
	public int getBallNum(){
		
		return ballNum;
	
	}
    /**
     * Returns a string rep of int balNum
     */
	public String toString(){
		
		String returnBallNum = "";
		returnBallNum = returnBallNum + ballNum;
		return returnBallNum;
	
	}
	

}