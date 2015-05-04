package persistence;

import business.businessGame.BusinessPlayerScore;


import java.util.ArrayList;

/**
 *
 * Created by mai714 on 24.04.2015.
 *
 */
public interface HighScoreDAO {
    public void saveHighScore(BusinessPlayerScore playerScore);
    public ArrayList<BusinessPlayerScore> getHighScoreList() ;
}
