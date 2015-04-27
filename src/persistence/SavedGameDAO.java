package persistence;

import game.Game;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface SavedGameDAO {
    public void saveGame(int score, int difficulty, long timerTime, String playerName);
    public Game loadGame();


}
