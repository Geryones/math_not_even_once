package persistence;


/**
 * Created by simon and mai714 on 24.04.2015.
 *
 * interface for loading and saving games
 */
public interface SavedGameDAO {
    public void saveGame(GameInterface game);

    public GameInterface loadGame();


}
