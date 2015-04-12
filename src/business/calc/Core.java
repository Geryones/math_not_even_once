package business.calc;

import presentation.Gui;
import java.util.Scanner;

/**
 * Created by mai714 on 02.03.2015.
 */
public class Core {


    public static void main(String[] args) {

        Gui gui = new Gui();


        int rechnung;

        Scanner scan = new Scanner(System.in);
        do {
            rechnung=((int) (Math.random() * 3));
            InterfaceCalc temp = CalcFactory.getInstance().createCalculation(rechnung);
            System.out.println(temp.createCalc());
            temp.correct(scan.nextInt());

        }while (true);

    }
}
