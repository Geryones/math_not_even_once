package game;

/**
 * Created by mai714 on 26.05.2015.
 */
public interface GameInterface {
    public int getScore();
    public void setScore(int score);

    public int getDifficulty();

    public void setDifficulty(int difficulty);

    public long getRemainingTime();

    public void setRemainingTime(long remainingTime);

    public String getPlayerName();

    public void setPlayerName(String playerName);

    public int getCountSolvedCalculations();

    public void setCountSolvedCalculations(int countSolvedCalculations);
}
