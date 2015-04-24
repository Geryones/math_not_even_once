package persistence;

import game.HighScore;

import java.util.ArrayList;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface HighScoreDAO {
    public void saveHighScore(HighScore highScore);
    public ArrayList<String> getHighScore();
}
