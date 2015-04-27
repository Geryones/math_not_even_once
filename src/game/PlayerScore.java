package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mai714 on 24.04.2015.
 * Class which holds the players name and score
 */
public class PlayerScore implements Serializable{



    private String playerName;
    private int score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }






}
