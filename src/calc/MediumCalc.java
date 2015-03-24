package calc;

/**
 * Created by mai714 on 02.03.2015.
 */
public class MediumCalc extends AbstractCalc {

    private int result;

    /**
     * Creates an medium Calculation
     * @return String with the Calculation
     */
    @Override
    public String createCalc() {
        EasyCalc easycalc = new EasyCalc();
        String part =easycalc.createCalc();
        int numberTwo;


        int operator = (int) Math.random()*4;

        String calculation=null;

        switch (operator){
            //Addition
            case 0:
                 numberTwo = (int) (Math.random()*1000)+1;
                calculation=part+" + "+numberTwo;
                setResult(easycalc.getResult()+numberTwo);
                break;
            //Subtraction
            case 1:
                numberTwo=(int) (Math.random()*easycalc.getResult())+1;
                calculation = part+" - "+numberTwo;
                setResult(easycalc.getResult()-numberTwo);
                break;
            //Division
            case 2:
                setResult((int)(Math.random()*30)+1);
                numberTwo = getResult()*easycalc.getResult();
                calculation= part+" / "+numberTwo;
                break;
            //Multiplication
            case 3:
                numberTwo=(int)(Math.random()*19)+1;
                calculation= part+" * "+numberTwo;
                setResult(easycalc.getResult()*numberTwo);
                break;
            default:
                System.out.println("Problem in MediumCalc");
                break;


        }


        return calculation;
    }


    /**
     * Checks your Result against the actual one
     * @param result your Result
     */
    @Override
    public void correct(int result) {
        if (result==getResult()){
            System.out.println("True that");
        }
        else
            System.out.println("nope " +getResult());

    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
