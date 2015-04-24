package game;

/**
 * Created by mai714 on 24.04.2015.
 */
public class Game {
    private int score;
    private int difficulty;
    private long remainingTime;
    private String playerName;




    //TODO: Function to check if a score is high enough to be a highscore, for that we have to check the file with the saved scores
    public boolean isHighScore(int score){
        boolean isHighScore = false;


        return isHighScore;
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
}
