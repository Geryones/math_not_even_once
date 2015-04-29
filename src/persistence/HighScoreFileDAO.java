package persistence;


import game.PlayerScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by mai714 on 24.04.2015.
 * Class to Read and Save the HighScore
 */
public class HighScoreFileDAO implements HighScoreDAO {
    private int maxHighScoreSize=10;


    /**
     * Function to save a new HighScore
     * First it checks if the HighScore is actually a Highscore  and then saves the list
     * @param playerScore
     */
    @Override
    public void saveHighScore(PlayerScore playerScore) {
        ArrayList<PlayerScore> highScoreList = getHighScoreList();

        //if the score is higher than the lowest value, or there are less than 5 entries.

        if (isHighScore(playerScore.getScore()) && highScoreList.size() == maxHighScoreSize) {

            highScoreList = getHighScoreList();
            highScoreList.add(playerScore);
            highScoreList = sortHighScoreList(highScoreList);
            highScoreList.remove(0);
        //if there arent 10 objects in the list, the new one is just being added
        } else if (highScoreList.size() < maxHighScoreSize) {
            highScoreList.add(playerScore);
        }


        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\mai714\\IdeaProjects\\mathe\\src\\game\\highScore.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(highScoreList);
            objectOutput.close();
            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Function to pass a list of PlayersScore-Objects and Save them
     * @param theList List of PlayerScore objects [0] playername (String), [1]score (int)
     */
    public void justSaveHighScoreList(ArrayList<PlayerScore> theList){
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\mai714\\IdeaProjects\\mathe\\src\\game\\highScore.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(theList);
            objectOutput.close();
            fileOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to get the HighScore-List out of the saved File
     * @return the HighScore-list
     */
    @Override
    public ArrayList<PlayerScore> getHighScoreList() {
        ArrayList<PlayerScore> scoreList;


        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\mai714\\IdeaProjects\\mathe\\src\\game\\highScore.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            scoreList = (ArrayList<PlayerScore>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return scoreList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Function to sort the HighScore-List (Ascending, [0]= lowest value)
     * @param highScoreList The list, wich should be sorted
     * @return a sorted List
     */
    public ArrayList<PlayerScore> sortHighScoreList(ArrayList<PlayerScore> highScoreList){
       PlayerScore temp;
        Collections.sort(highScoreList, new Comparator<PlayerScore>() {
            @Override
            public int compare(PlayerScore o1, PlayerScore o2) {
                return o1.getScore()-o2.getScore();
            }
        });

        return highScoreList;
    }


    public boolean isHighScore(int score){


        int temp;

        for (int i=0;i<getHighScoreList().size();i++){
            temp= getHighScoreList().get(i).getScore();
            if (score>temp){
                return true;
            }
        }


        return false;
    }

}
