package calc;

/**
 * Created by mai714 on 02.03.2015.
 */
public abstract class AbstractCalc implements InterfaceCalc{
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
