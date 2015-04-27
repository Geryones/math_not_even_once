package persistence;

import game.PlayerScore;

import java.util.ArrayList;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface HighScoreDAO {
    public void saveHighScore(PlayerScore playerScore);
    public ArrayList<PlayerScore> getHighScoreList() ;
}
