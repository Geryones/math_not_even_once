package game;




/**
 *
 * Created by mai714 on 24.04.2015.
 *
 */
public class Game{
    private int score;
    private int difficulty;
    private long remainingTime;
    private String playerName;
    private int countSolvedCalculations;


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

    public void setCountSolvedCalculations(int countSolvedCalculations) {
        this.countSolvedCalculations = countSolvedCalculations;
    }


}
