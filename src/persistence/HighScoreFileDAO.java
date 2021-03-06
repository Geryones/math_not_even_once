package persistence;


import business.businessGame.BusinessPlayerScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by simon and mai714 on 24.04.2015.
 *
 * reads and saves the high score
 */
public class HighScoreFileDAO implements HighScoreDAO, Serializable {


    /**
     * saves a new high score
     * First it checks if the HighScore is actually a Highscore  and then saves the list
     *
     * @param playerScore an object of BusinessPlayerScore, which holds the name and score of a Player
     */
    @Override
    public void saveHighScore(PlayerScoreInterface playerScore) {
        int maxHighScoreSize = 10;

        ArrayList<PlayerScoreInterface> highScoreList = getHighScoreList();

        //if the score is higher than the lowest value, or there are less than 5 entries.

        if (isHighScore(playerScore.getPlayerScore()) && highScoreList.size() == maxHighScoreSize) {

            highScoreList = getHighScoreList();
            highScoreList.add(playerScore);
            highScoreList = sortLowTopHighScoreList(highScoreList);
            highScoreList.remove(0);
            //if there aren't 10 objects in the list, the new one is just being added
        } else if (highScoreList.size() < maxHighScoreSize) {
            highScoreList.add(playerScore);
        }

        try {
            FileOutputStream fileOutput = new FileOutputStream("src/resources/saveFiles/highScore.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(highScoreList);
            objectOutput.close();
            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


/*

    */

    /**
     * Function to pass a list of BusinessPlayersScore-Objects and Save them
     *
     * @param theList List of BusniessPlayerScore objects [0] playername (String), [1]score (int)
     */

    public void justSaveHighScoreList(ArrayList<BusinessPlayerScore> theList) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/resources/saveFiles/highScore.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(theList);
            objectOutput.close();
            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to get the HighScoreList out of the saved file
     *
     * @return ArrayList of Type BusinessPlayerScore which represents the HighScoreList
     */
    @Override
    public ArrayList<PlayerScoreInterface> getHighScoreList() {


        ArrayList<PlayerScoreInterface> scoreList;

        try {
            FileInputStream fileInput = new FileInputStream("src/resources/saveFiles/highScore.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            scoreList = (ArrayList<PlayerScoreInterface>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return scoreList;

        } catch (Exception e) {

            System.err.println("HighScoreFileDAO: could not get a HighScoreList, no save file?");
            return null;
        }

    }

    /**
     * Function to sort the HighScore-List (Ascending, [0]= lowest value)
     *
     * @param highScoreList The list, which should be sorted
     * @return sorted ArrayList of type BusinessPlayerScore
     */
    public ArrayList<PlayerScoreInterface> sortLowTopHighScoreList(ArrayList<PlayerScoreInterface> highScoreList) {

        Collections.sort(highScoreList, new Comparator<PlayerScoreInterface>() {
            @Override
            public int compare(PlayerScoreInterface o1, PlayerScoreInterface o2) {
                return o1.getPlayerScore() - o2.getPlayerScore();
            }
        });

        return highScoreList;
    }

    /**
     * Function to sort the HighScore-List (Descending, [0]= Highest Value)
     *
     * @param highScoreList The list, which should be sorted
     * @return sorted ArrayList of type BusinessPlayerScore
     */
    public ArrayList<PlayerScoreInterface> sortHighTopHighScoreList(ArrayList<PlayerScoreInterface> highScoreList) {
        try {
            Collections.sort(highScoreList, new Comparator<PlayerScoreInterface>() {
                @Override
                public int compare(PlayerScoreInterface o1, PlayerScoreInterface o2) {
                    return o2.getPlayerScore() - o1.getPlayerScore();
                }
            });

            return highScoreList;
        } catch (Exception e) {
            System.err.println("HighScoreFileDAO: Unable to sort HighScoreList, does it exist?");
            return null;
        }
    }


    /**
     * This function checks if a playerScore is a HighScore
     *
     * @param score a Players score
     * @return boolean if it is a highScore
     */
    public boolean isHighScore(int score) {
        int temp;
        for (int i = 0; i < getHighScoreList().size(); i++) {
            temp = getHighScoreList().get(i).getPlayerScore();
            if (score > temp) {
                return true;
            }
        }
        return false;
    }

}
