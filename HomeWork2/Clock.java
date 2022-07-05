/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *              s
 * 
 */

public class Clock<AnyType>{

    private int numOfballs;
    public int dayCount = 0;
    final int ONETRACKMAX = 4;
    final int FIVETRACKMAX = 11;
    final int HOURTRACKMAX = 11;
    QueueTrack<Ball> queueComapare;
    QueueTrack<Ball> ballReturn;
    StackTracks<Ball> minuteTrack = new StackTracks<>(ONETRACKMAX); 
    StackTracks<Ball> fiveMinuteTrack = new StackTracks<>(FIVETRACKMAX);
    StackTracks<Ball> hourTrack = new StackTracks<>(HOURTRACKMAX);
    /**
     * Constructor builds a clock object
     * @param numOfBalls is the number of balls going to fun through clock
     */
    public Clock(int numOfballs){

        this.numOfballs = numOfballs;
        this.ballReturn = new QueueTrack<Ball>(numOfballs);
        this.minuteTrack = minuteTrack;
        this.fiveMinuteTrack = fiveMinuteTrack;
        this.hourTrack = hourTrack;
        queueComapare = new QueueTrack<>(numOfballs);
    }
    /**
     * Method runs the function of the clock
     * @param fromInput is the number of balls passed from scanner
     */
    public void run(int fromInput){

        int balls = fromInput;

        this.queueLoadBall(balls);
        this.passTime();
        this.toString();
    }
    /**
     * Method loads the specified number of balls into the queue the balls feed from 
     * @param balls number of ball specified to go into QueueTrack
     */
    public void queueLoadBall(int balls){
        
        int loadNumber = balls;
        
        //fill queue with inputed number of balls
        for (int i = 0; i < loadNumber; i++) {
            this.ballReturn.enqueue(new Ball(i));
            //System.out.println(ballReturn.getData());
        }
        queueComapare.setData(this.ballReturn.getData());     
        //System.out.println(queueComapare.getData());
    }
    /**
     * Method returns the number of balls bein g used in clock
     */ 
    public int getNumOfballs(){

        return this.numOfballs;
    }
    /**
     * Method contains all the logic of concept of time passing in a BallClock
     * <p>
     * controls ball movement and tracks time passed
     */
    public int passTime(){
        int days = 0;
        boolean addDay = false;
        boolean stop = false;

        while(!stop){

            //add ball to minute track if not full
            if (minuteTrack.size() < 4) {    
                minuteTrack.push(ballReturn.peek());
                ballReturn.dequeue();
                //System.out.println(ballReturn.getData());
                //System.out.println(minuteTrack.getData());
            }

            else {
                //move current ball to five minute track if not full
                if (fiveMinuteTrack.size() < 11) {
                    fiveMinuteTrack.push(ballReturn.peek());
                    ballReturn.dequeue();
                    
                    //empty minute track in reverse order
                    for (int i = 3; i >= 0; i--) {
                        ballReturn.enqueue(minuteTrack.peek());
                        minuteTrack.pop();
                    }
                }    

                else {
                    //move ball to hour track if not full
                    if (hourTrack.size() < 11) {
                        //move current ball to hour track if not full
                        hourTrack.push(ballReturn.peek());
                        ballReturn.dequeue();
                            
                        //empty minute track in reverse order
                        for (int i = 3; i >= 0; i--) {
                            ballReturn.enqueue(minuteTrack.peek());
                            minuteTrack.pop();
                        }
                            
                        //empty five minute track in reverse order
                        for (int i = 10; i >= 0; i--) {
                                ballReturn.enqueue(fiveMinuteTrack.peek());
                                fiveMinuteTrack.pop();
                        }
                    }

                    else {
                        //empty all tracks in reverse order
                        for (int i = 3; i >= 0; i--) {
                            ballReturn.enqueue(minuteTrack.peek());
                            minuteTrack.pop(/*i*/);
                        }
                                
                        for (int i = 10; i >= 0; i--) {
                            ballReturn.enqueue(fiveMinuteTrack.peek());
                            fiveMinuteTrack.pop();
                        }
                                
                        for (int i = 10; i >= 0; i--) {
                            ballReturn.enqueue(hourTrack.peek());
                            hourTrack.pop();
                        }
                                
                        //move current ball to end of queue
                        ballReturn.enqueue(ballReturn.peek());
                        ballReturn.dequeue();
                                
                        //add day every other time loop hits here
                        if (addDay) {
                            days++;
                            addDay = false;
                        } 
                        else {
                            addDay = true;
                        }
                    }
                }
            }
            
            //stop loop when queue is in original state
            if (ballReturn.equals(queueComapare)) {
                stop = true;
            }
            

        }
        dayCount = days;
        return days;
    }
    /**
     * 
     * 
     * 
     */
    @Override
    public String toString(){
        
         return(getNumOfballs()+ " balls cycle after " + dayCount + " days");
    }
}
    
