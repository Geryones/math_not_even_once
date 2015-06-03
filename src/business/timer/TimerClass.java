package business.timer;


import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mai714
 * TimerClass is for time management
 * sperated thread
 */
public class TimerClass extends Observable {


    Timer timer;
    private long passedTime;
    private long remainingTime = 1;
    private long totalDuration = 0;
    private boolean isRunning = true;

    /**
     * Constructer
     * definition of the new Thread
     */
    public TimerClass() {


        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
                1000); //subsequent rate

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

    public long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }

    /**
     * Class which includes the runnable
     */
    class RemindTask extends TimerTask {
        //int numWarningBeeps = 10;
        long startTime = System.currentTimeMillis();

        /**
         * seperated Thread
         * Calculates the time you have to solve the terms
         */
        public void run() {


            if (System.currentTimeMillis() - startTime < (getTotalDuration() * 1000)) {
                setPassedTime(System.currentTimeMillis() - startTime);
                setRemainingTime(getTotalDuration() - (getPassedTime() / 1000));
                setChanged();
                notifyObservers(getRemainingTime());


            } else if (isRunning) {
                setChanged();
                notifyObservers(0);
                setRemainingTime(0);


                timer.cancel();
                //System.exit(0); //Stops the AWT thread (and everything else)
            }
            /*
            With this condition i can cancel a thread
            for example if i save a game and want to return to the menu
             */
            if (!isRunning) {
                timer.cancel();
            }


        }


    }

    public void setIsRunning(Boolean isRunning) {
        this.isRunning = isRunning;
    }


}