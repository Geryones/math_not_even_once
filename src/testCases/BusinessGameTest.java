package testCases;

import business.businessGame.BusinessGame;
import junit.framework.TestCase;

public class BusinessGameTest extends TestCase {

    public void testGameSaving(){

        BusinessGame businessGame = new BusinessGame();

        int score =150;
        int difficulty=1;
        long remainingTime=75;
        String playerName="Geryones_saveGame";
        int countSolvedCalculations=200;

        businessGame.setScore(score);
        businessGame.setPlayerName(playerName);
        businessGame.setDifficulty(difficulty);
        businessGame.setRemainingTime(remainingTime);
        businessGame.setCountSolvedCalculations(countSolvedCalculations);

        businessGame.safeGame();

        BusinessGame loadedBusinessGame= (BusinessGame) businessGame.loadGame();

        assertTrue(loadedBusinessGame.getPlayerName().equals(playerName));
        assertTrue(loadedBusinessGame.getScore()==score);
        assertTrue(loadedBusinessGame.getCountSolvedCalculations()==countSolvedCalculations);
        assertTrue(loadedBusinessGame.getRemainingTime()==remainingTime);
        assertTrue(loadedBusinessGame.getDifficulty()==difficulty);
    }


}