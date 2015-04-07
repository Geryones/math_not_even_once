package business.timer;


import java.util.Timer;
import java.util.TimerTask;

public class TimerClass {


    private long passedTime;


    private long remainingTime=1;
    Timer timer;

    public TimerClass() {



        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
                1*1000 ); //subsequent rate
    }

    class RemindTask extends TimerTask {
        //int numWarningBeeps = 10;
        long startTime=System.currentTimeMillis();


        public void run() {
            if ( System.currentTimeMillis()-startTime<(getRemainingTime()*1000)) {
                setPassedTime(System.currentTimeMillis() - startTime);
                System.out.println(getPassedTime());
                setRemainingTime(5+(getPassedTime()/1000));
                System.out.println(getRemainingTime());
            } else {

                System.out.println("Time's up!");
                //timer.cancel(); //Not necessary because we call System.exit
                System.exit(0); //Stops the AWT thread (and everything else)
            }
        }
    }




    public long getPassedTime() {
        return passedTime;
    }

    public void setPassedTime(long passedTime) {
        this.passedTime = passedTime;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }


}