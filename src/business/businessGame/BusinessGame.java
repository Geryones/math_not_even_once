package business.businessGame;

import game.Game;
import persistence.SavedGameFileDAO;

import java.io.Serializable;

/**
 * This class is created to prevent a violation of the layer-Access
 * this way, the gui creates a object from the bussiness layer and there is lies the object for SavedGameFileDAO
 * Created by mai714 on 24.04.2015.
 */
public class BusinessGame implements Serializable{
    SavedGameFileDAO saveGameDAO = new SavedGameFileDAO();

    public BusinessGame(Game game) {
        this.score=game.getScore();
        this.difficulty=game.getDifficulty();
        this.remainingTime=game.getRemainingTime();
        this.playerName=game.getPlayerName();
        this.countSolvedCalculations=game.getCountSolvedCalculations();
       // System.out.println("businessGame wurde erstellt");
    }

    /**
     * empty Constructor which allows you to create an BussinessGame-Object without all the information
     */
    public BusinessGame(){

    }


    private int score;
    private int difficulty;
    private long remainingTime;
    private String playerName;
    private int countSolvedCalculations;

    /**
     * Function to safe this GameObject into a file
     */
    public void safeGame(){

        saveGameDAO.saveGame(this);

    }

    /**
     * Function create a BussinessGame object from a file
     * @return BussinessGame-Object
     */
    public BusinessGame loadGame(){
        //System.out.println("im BusinessGame angekommen");

        return saveGameDAO.loadGame();
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCountSolvedCalculations() {
        return countSolvedCalculations;
    }




}
