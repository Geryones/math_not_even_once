package business.calc;

/**
 * Created by mai714 on 02.03.2015.
 */
public class CalcFactory {

    /**
     * Singelton for the Factory
     */
    private static CalcFactory instance = new CalcFactory();

    /**
     * constructor for singelton
     */
    private CalcFactory() {

    }

    /**
     * Get the CalcFactory-Singelton instance
     *
     * @return the singelton instance
     */
    public static CalcFactory getInstance() {
        return instance;
    }

    /**
     * The Factory-Method, creates a Calculaion
     *
     * @param difficulty defines the difficulty of the generated Calculation
     * @return an object Calculation with the desired difficulty
     */
    public InterfaceCalc createCalculation(int difficulty) {
        InterfaceCalc calc = null;
        switch (difficulty) {
            case 0:
                calc = new EasyCalc();
                break;
            case 1:
                calc = new MediumCalc();
                break;
            case 2:
                calc = new HardCalc();
                break;
            default:
                System.out.println("problem in CalcFactory");
        }

        return calc;
    }
}
