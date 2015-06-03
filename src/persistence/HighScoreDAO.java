package persistence;


import game.PlayerScoreInterface;

import java.util.ArrayList;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface HighScoreDAO {
    public void saveHighScore(PlayerScoreInterface playerScore);

    public ArrayList<PlayerScoreInterface> getHighScoreList();
}
