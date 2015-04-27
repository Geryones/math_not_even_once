import game.PlayerScore;
import persistence.HighScoreFileDAO;
import java.util.ArrayList;



/**
 * Created by mai714 on 02.03.2015.
 */
public class Core {



    public static void main(String[] args)  {
        HighScoreFileDAO file = new HighScoreFileDAO();



        ArrayList<PlayerScore> test= new ArrayList<PlayerScore>();

       PlayerScore test1 = new PlayerScore();
        test1.setPlayerName("hans");
        test1.setScore(9);

        PlayerScore test2 = new PlayerScore();
        test2.setPlayerName("wurst");
        test2.setScore(90);

        PlayerScore test3 =new PlayerScore();
        test3.setPlayerName("hubi");
        test3.setScore(5);

        test.add(test1);
        test.add(test2);
        test.add(test3);
        for (PlayerScore a : test){
            System.out.println(a.getScore());
        }

        file.justSaveHighScoreList(file.sortHighScoreList(test));


        for (PlayerScore a: file.getHighScoreList()){
            System.out.println(a.getScore());
        }


        PlayerScore ersatz = new PlayerScore();
        ersatz.setPlayerName("penis");
        ersatz.setScore(1220);
        System.out.println("added new player");
        file.saveHighScore(ersatz);
        for (PlayerScore a: file.getHighScoreList()){
            System.out.println(a.getScore());
        }

/*
        int rechnung;
        Scanner scan = new Scanner(System.in);
        do {
            rechnung=((int) (Math.random() * 3));
            InterfaceCalc temp = CalcFactory.getInstance().createCalculation(rechnung);
            System.out.println(temp.createCalc());
            temp.correct(scan.nextInt());

        }while (true);*/

    }
}
