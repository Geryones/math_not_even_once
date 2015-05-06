package business.calc;

import business.notification.Sound;

/**
 * Created by mai714 on 02.03.2015.
 */
public class EasyCalc extends AbstractCalc {
    Sound sound = new Sound();

    private int result;

    /**
     * Creates an easy Calculation
     * @return String with the Calculation
     */
    @Override
    public String createCalc() {
        int numberOne;
        int numberTwo;
        String calculation=null;

        int random = (int) (Math.random()*4);

        switch (random){
             // Addition
            case 0:
                numberOne = (int) (Math.random()*1000)+1;
                numberTwo = (int) (Math.random()*1000)+1;
                setResult(numberOne+numberTwo);
                calculation=numberOne+" + "+numberTwo;

                break;
            //Subtraction
            case 1:
                numberOne = (int) (Math.random()*1000)+1;
                numberTwo = (int) (Math.random()*numberOne)+1;
                setResult(numberOne-numberTwo);
                calculation=numberOne+" - "+numberTwo;

                break;
            //Multiplication
            case 2:
                numberOne = (int) (Math.random()*100)+1;
                numberTwo = (int) (Math.random()*15)+2;
                setResult(numberOne*numberTwo);
                calculation=numberOne+" * "+numberTwo;

                break;
            //Division
            case 3:
                setResult(  (int) (Math.random()* 100)+1);
                numberTwo = (int) (Math.random()*10)+3;
                numberOne =  getResult()*numberTwo;
                calculation=numberOne+" / "+numberTwo;

                break;
            default:
                System.out.println("Problem in EasyCalc-createCalc()");
        }






        return calculation;
    }

    /**
     * Checks your Result against the actual one
     * @param result your Result
     */
    public boolean correct(int result){
        if (result==getResult()){
           sound.soundrichtig();
            return true;
        }
        else
        sound.soundfalsch();
          return false;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }






}
