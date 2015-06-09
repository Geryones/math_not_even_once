package persistence;


/**
 * Created by mai714 on 24.04.2015.
 */
public interface SavedGameDAO {
    public void saveGame(GameInterface game);

    public GameInterface loadGame();


}
