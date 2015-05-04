package business.businessGame;

import game.PlayerScore;
import persistence.HighScoreDAO;
import persistence.HighScoreFileDAO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mai714 on 30.04.2015.
 */
public class BusinessPlayerScore  implements Serializable {


    private String playerName;
    private int playerScore;

    /**
     * Constructor for a BusinessPlayerScore
     * @param thePlayerScore the object of a PlayerScore
     */
    public BusinessPlayerScore(PlayerScore thePlayerScore){
        this.playerName=thePlayerScore.getPlayerName();
        this.playerScore=thePlayerScore.getScore();
        //System.out.println("constructor fertig");
    }

    /**
     * Empty Constructor to initialise an empty object
     */
    public BusinessPlayerScore(){

    }

    /**
     * Safes a BusinessPlayerScore
     */
    public void safePlayerScore(){
       // System.out.println("enter safePlayerScore");
        HighScoreDAO highScoreDAO = new HighScoreFileDAO();
        highScoreDAO.saveHighScore(this);

    }

    /**
     * Reads the file with the PlayerScores and creates a List--> the actual HighScore-List
     * @return ArrayList of the type BusinessPlayerScore which holds up to 10 BusinessPlayerScore-Objects
     */
    public ArrayList<BusinessPlayerScore> loadHighScore(){
        HighScoreDAO highScoreDAO = new HighScoreFileDAO();
        return highScoreDAO.getHighScoreList();
    }

    /**
     * Loads and sorts a ArrayList containing the HighScores
     * @return an ArrayList with the HighScore
     */
    public ArrayList<BusinessPlayerScore> sortHighScoreDesc(){
        HighScoreFileDAO highScoreFileDAO = new HighScoreFileDAO();
        return highScoreFileDAO.sortHighTopHighScoreList(loadHighScore());
    }

    public int getTheHighScore(){
        return sortHighScoreDesc().get(0).getPlayerScore();
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }



}
