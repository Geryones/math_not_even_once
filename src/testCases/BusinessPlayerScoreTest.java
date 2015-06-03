package testCases;


import business.businessGame.BusinessPlayerScore;
import junit.framework.TestCase;


public class BusinessPlayerScoreTest extends TestCase {

    public void testHighScoreSaving(){
        int score =100;
        String name = "Geryones";
        BusinessPlayerScore businessPlayerScore = new BusinessPlayerScore();
        businessPlayerScore.setScore(score);
        businessPlayerScore.createDummyHighScore();

        assertTrue(businessPlayerScore.getPlayerScore()==score);

        businessPlayerScore.setPlayerName(name);

        assertTrue(businessPlayerScore.getPlayerName().equals(name));

        businessPlayerScore.safePlayerScore();

       assertTrue(score==businessPlayerScore.getTheHighScore());

        assertTrue(businessPlayerScore.sortHighScoreDesc().get(0).getPlayerName().equals(name));
        assertTrue(businessPlayerScore.sortHighScoreDesc().get(0).getPlayerScore()==score);
    }


}