import business.businessGame.BusinessGame;
import business.businessGame.BusinessPlayerScore;
import game.Game;
import game.PlayerScore;
import persistence.HighScoreDAO;
import persistence.HighScoreFileDAO;
import presentation.Gui;

import java.util.ArrayList;



/**
 * Created by mai714 on 02.03.2015.
 */
public class Core {



    public static void main(String[] args)  {

      Gui.getInstance();

        /*
        Hier habe ich manuell eine HighScore liste erstellt, da ich auf Probleme stiess beim laden der list, weiss noch nicht genau was es war,
        da nachdem ich diese einträge hinzugefügt habe, alles wieder funktioniert hat
         */
     /* PlayerScore one = new PlayerScore();
        PlayerScore two = new PlayerScore();

        one.setPlayerName("Geryones");
        two.setPlayerName("Max");
        one.setScore(93);
        two.setScore(64);

        BusinessPlayerScore pl1 = new BusinessPlayerScore(one);
        BusinessPlayerScore pl2 = new BusinessPlayerScore(two);

        ArrayList<BusinessPlayerScore> list=new ArrayList<BusinessPlayerScore>();
        list.add(pl1);
        list.add(pl2);

        HighScoreFileDAO save = new HighScoreFileDAO();
        save.justSaveHighScoreList(list);

        PlayerScore drei = new PlayerScore();
        drei.setScore(12);
        drei.setPlayerName("Fritz");

        BusinessPlayerScore pl3 = new BusinessPlayerScore(drei);
        pl3.safePlayerScore();
*/



      /*  int rechnung;
        Scanner scan = new Scanner(System.in);
        do {
            rechnung=((int) (Math.random() * 3));
            InterfaceCalc temp = CalcFactory.getInstance().createCalculation(rechnung);
            System.out.println(temp.createCalc());
            temp.correct(scan.nextInt());

        }while (true);*//*
*/
    }
}
