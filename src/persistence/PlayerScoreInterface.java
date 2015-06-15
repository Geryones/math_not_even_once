package persistence;

/**
 * Created by simon and mai714 on 26.05.2015.
 *
 * Interface for saving and loading a palyer's score
 */
public interface PlayerScoreInterface {
    public String getPlayerName();

    public void setPlayerName(String playerName);

    public int getScore();

    public void setScore(int score);

    public int getPlayerScore();
}
