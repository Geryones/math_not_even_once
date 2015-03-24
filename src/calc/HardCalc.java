package calc;

/**
 * Created by mai714 on 02.03.2015.
 */
public class HardCalc extends AbstractCalc {
    private int result=0;

    /**
     * Creates an hard Calculation
     * @return String with the Calculation
     */
    @Override
    public String createCalc() {
        String calculation=null;
        EasyCalc easyPartOne = new EasyCalc();
        String partOne =easyPartOne.createCalc();
        int tempResultOne=easyPartOne.getResult();


        EasyCalc easyPartTwo = new EasyCalc();
        String partTwo = easyPartTwo.createCalc();
        int tempResultTwo = easyPartTwo.getResult();

        int operator = (int)(Math.random()*3);

        switch (operator){
            //Addition
            case 0:
                calculation="("+partOne+") + ("+partTwo+")";
                setResult(tempResultOne+tempResultTwo);

                break;
            //Subtraction
            case 1:
                if (tempResultOne>=tempResultTwo){
                    System.out.println(tempResultOne+" = erster term");
                    System.out.println(tempResultTwo+" = zweiter term");
                    calculation="("+partOne+") - ("+partTwo+")";
                    setResult((tempResultOne-tempResultTwo));
                    System.out.println(getResult()+" gesammt");
                }else{
                    calculation="("+partTwo+") - ("+partOne+")";
                    setResult((tempResultTwo-tempResultOne));
                }


                break;
            //Division
            case 2:
                setResult((int)(Math.random()*100)+1);
                System.out.println("Resultat = "+getResult());
                int multiplier=(int)(Math.random()*100)+1;
                System.out.println("Multiplier = "+multiplier);
                partTwo=createTerm(getResult());
                System.out.println("part2 mit Resultat: "+getResult()+" als parameter wird erstellt");
                System.out.println("part2 = "+partTwo);
                partOne=createTerm((getResult()* multiplier));
                System.out.println("part1 mit Resultat * Multiplier: "+getResult()+" und "+multiplier+" als parameter wird erstellt");
                System.out.println("part1 = "+ partOne);
                setResult(multiplier);
                System.out.println("entgültiges Resultat wird gesetzt "+getResult());
                calculation=partOne+" / "+partTwo;


                break;
            //Muliplication
            case 3:
                calculation= "("+partOne+") * ("+partTwo+")";
                setResult(tempResultOne*tempResultTwo);

                break;
            default:
                System.out.println("Problem in HardCalc");
                break;
        }




        return calculation;
    }

    /**
     * Creates a Calculation, based on the Result
     * @param result of the Calculation
     * @return String with the Calculation
     */
    public String createTerm(int result){
        String calculation=null;
        int numberOne;
        int numberTwo;

        int operator =(int) (Math.random()*4);

        switch (operator){
            // Subtraction
            case 0:
                numberOne=(int)(Math.random()*1000)+1;
                numberTwo=numberOne-result;
                calculation = "("+numberOne+" - "+numberTwo+")";
                break;
            //Addition
            case 1:
                numberOne=(int)(Math.random()*1000)+1;
                numberTwo=result-numberOne;
                calculation= "("+numberOne+" + "+numberTwo+")";
                break;
            //Multiplication
            case 2:
                numberTwo=(int)(Math.random()*30)+1;
                numberOne=result/numberTwo;
                calculation="("+numberOne+" * "+numberTwo+")";
                break;
            //Division
            case 3:
                do {
                    numberTwo=(int)(Math.random()*(result/2))+1;

                }while(result%numberTwo!=0);
                numberOne=result/numberTwo;
                calculation="("+numberOne+" * "+numberTwo+")";
                break;
            default:
                System.out.println("Problem in HardCalc --> createTerm");
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
