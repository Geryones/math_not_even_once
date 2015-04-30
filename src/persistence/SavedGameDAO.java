package persistence;

import business.businessGame.BusinessGame;

/**
 * Created by mai714 on 24.04.2015.
 */
public interface SavedGameDAO {
    public void saveGame(BusinessGame game);
    public BusinessGame loadGame();


}
