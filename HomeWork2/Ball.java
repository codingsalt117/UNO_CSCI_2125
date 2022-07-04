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
     * @param number is an int representing a ball number
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
	public String toStrting(){
		
		String returnBallNum = "";
		returnBallNum = returnBallNum + ballNum;
		return returnBallNum;
	
	}
	

}