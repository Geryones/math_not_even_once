package persistence;

import game.Game;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface SavedGameDAO {
    public void saveGame(Game game);
    public Game loadGame();


}
