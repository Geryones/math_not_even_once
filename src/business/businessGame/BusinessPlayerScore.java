package business.businessGame;


import persistence.PlayerScoreInterface;
import persistence.HighScoreDAO;
import persistence.HighScoreFileDAO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mai714 on 30.04.2015.
 */
public class BusinessPlayerScore implements Serializable, PlayerScoreInterface {


    private String playerName;
    private int playerScore;

    /**
     * Constructor for a BusinessPlayerScore
     *
     * @param thePlayerScore the object of a PlayerScore
     */
    public BusinessPlayerScore(BusinessPlayerScore thePlayerScore) {
        this.playerName = thePlayerScore.getPlayerName();
        this.playerScore = thePlayerScore.getScore();
        //System.out.println("constructor fertig");
    }

    /**
     * Empty Constructor to initialise an empty object
     */
    public BusinessPlayerScore() {

    }

    /**
     * Safes a BusinessPlayerScore
     */
    public void safePlayerScore() {
        // System.out.println("enter safePlayerScore");
        HighScoreDAO highScoreDAO = new HighScoreFileDAO();
        highScoreDAO.saveHighScore(this);

    }

    /**
     * Reads the file with the PlayerScores and creates a List--> the actual HighScore-List
     *
     * @return ArrayList of the type BusinessPlayerScore which holds up to 10 BusinessPlayerScore-Objects
     */
    public ArrayList<PlayerScoreInterface> loadHighScore() {
        try {
            HighScoreDAO highScoreDAO = new HighScoreFileDAO();
            return highScoreDAO.getHighScoreList();
        } catch (Exception e) {
            System.out.println("HighScore konnte nicht geladen werden");
            return null;
        }
    }

    /**
     * Loads and sorts a ArrayList containing the HighScores
     *
     * @return an ArrayList with the HighScore
     */
    public ArrayList<PlayerScoreInterface> sortHighScoreDesc() {
        try {
            HighScoreFileDAO highScoreFileDAO = new HighScoreFileDAO();
            return highScoreFileDAO.sortHighTopHighScoreList(loadHighScore());
        } catch (Exception e) {
            System.out.println("BusinessPlayerScore: Can't sort HighScore list, list does not exist");
            return null;
        }
    }

    public int getTheHighScore() {
        try {
            return sortHighScoreDesc().get(0).getPlayerScore();
        } catch (Exception e) {
            System.out.println("BusinessPlayerScore: Failed to get HighScore for References in ProgressBar, returned 1 instead");
            return 1;
        }

    }


    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int getScore() {
        return playerScore;
    }

    @Override
    public void setScore(int score) {
        this.playerScore = score;
    }

    public int getPlayerScore() {
        return playerScore;
    }


    /**
     * Function to create a dummy HighScore
     * if any of the code which has a connection with the creation of the highScore.ser file is altert,
     * there are errors because of some id.
     * so after the code is alter, the HighScore.ser file has to be rewritten.
     */
    public void createDummyHighScore() {
        BusinessPlayerScore one = new BusinessPlayerScore();
        BusinessPlayerScore two = new BusinessPlayerScore();

        one.setPlayerName("maxerl");
        two.setPlayerName("Max");
        one.setScore(2);
        two.setScore(1);

        BusinessPlayerScore pl1 = new BusinessPlayerScore(one);
        BusinessPlayerScore pl2 = new BusinessPlayerScore(two);

        ArrayList<BusinessPlayerScore> list = new ArrayList<BusinessPlayerScore>();
        list.add(pl1);
        list.add(pl2);

        HighScoreFileDAO save = new HighScoreFileDAO();
        save.justSaveHighScoreList(list);

        BusinessPlayerScore drei = new BusinessPlayerScore();
        drei.setScore(3);
        drei.setPlayerName("Fritz");

        BusinessPlayerScore pl3 = new BusinessPlayerScore(drei);
        pl3.safePlayerScore();
    }


}
