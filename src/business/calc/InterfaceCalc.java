package business.calc;

/**
 * Created by mai714 on 02.03.2015.
 */
public interface InterfaceCalc {

    /**
     * Creates a new Calculation
     *
     * @return Calculation as String
     */
    public String createCalc();

    /**
     * Checks if you solved a Calculation correctly
     *
     * @param result your Result
     */
    public boolean correct(int result);

}
