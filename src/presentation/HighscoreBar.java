package presentation;


import business.businessGame.BusinessPlayerScore;

import javax.swing.*;
import java.awt.*;


/**
 * Created by simon
 *
 * Draws a progressbar with the high score as max value
 */
public class HighscoreBar extends JPanel {

    private JProgressBar progressBar;
    BusinessPlayerScore businessPlayerScore = new BusinessPlayerScore();

    public HighscoreBar() {
        setLayout(null);
        if (businessPlayerScore == null) {
            progressBar = new JProgressBar(0, 0);
        } else {
            progressBar = new JProgressBar(0, businessPlayerScore.getTheHighScore());
        }
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.black);
        add(progressBar).setBounds(0, 0, 700, 50);


    }

    public void setHighScoreProgress(int score) {
        progressBar.setValue(score);
    }

    public double getPercentage() {
        return progressBar.getPercentComplete();
    }
}