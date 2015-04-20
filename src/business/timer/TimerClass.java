package business.timer;


import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mai714
 * TimerClass für die Zeitberechnungen
 * seperater Thread
 */
public class TimerClass extends Observable {


    private long passedTime;
    private long remainingTime=1;
    private long totalDuration=0;
    Timer timer;

    /**
     * Constructer für die TimerClass
     * hier wird ein neuer Task definiert
     */
    public TimerClass() {



        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
                1*1000 ); //subsequent rate

    }

    /**
     * Klasse mit Runnable für seperatem Thread
     */
    class RemindTask extends TimerTask {
        //int numWarningBeeps = 10;
        long startTime=System.currentTimeMillis();

        /**
         * seperater Thread
         * hier wird überprüft wie lange man Eingaben machen kann
         */
        public void run() {
            if ( System.currentTimeMillis()-startTime<(getTotalDuration()*1000)) {
                setPassedTime(System.currentTimeMillis() - startTime);
                setRemainingTime(getTotalDuration()-(getPassedTime()/1000));
                System.out.println("vergange zeit: " + getPassedTime());

                System.out.println("time remaining: "+getRemainingTime());



                setChanged();
                notifyObservers(getRemainingTime());


            } else {
                setChanged();
                notifyObservers(0);

                System.out.println("Time's up!");
                timer.cancel(); //Not necessary because we call System.exit
                //System.exit(0); //Stops the AWT thread (and everything else)
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

    public long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }
}