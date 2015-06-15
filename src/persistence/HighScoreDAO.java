package persistence;


import java.util.ArrayList;

/**
 * Created by simon and mai714 on 24.04.2015.
 *
 * Interface for saving and loading the high score
 */
public interface HighScoreDAO {
    public void saveHighScore(PlayerScoreInterface playerScore);

    public ArrayList<PlayerScoreInterface> getHighScoreList();
}
