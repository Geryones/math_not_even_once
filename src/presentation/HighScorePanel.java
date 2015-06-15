package presentation;

import business.businessGame.BusinessPlayerScore;
import persistence.PlayerScoreInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by simon on 04.05.2015.
 *
 * Displays the high score list
 */
public class HighScorePanel extends JPanel {

    BusinessPlayerScore businessPlayerScore;



    /**
     * Constructor, 10 JLabel's are created and filled with player names and their scores
     */
    public HighScorePanel() {

        setLayout(null);

        JLabel title1 = new JLabel("Math");
        title1.setFont(new Font("SansSerif", Font.PLAIN, 80));
        title1.setHorizontalAlignment(JLabel.CENTER);
        add(title1).setBounds(0, 130, 400, 80);

        JLabel title2 = new JLabel("not even once!");
        title2.setFont(new Font("SansSerif", Font.PLAIN, 30));
        title2.setHorizontalAlignment(JLabel.CENTER);
        add(title2).setBounds(0, 210, 400, 30);

        JLabel title3 = new JLabel("Highscore");
        title3.setFont(new Font("SansSerif", Font.PLAIN, 30));
        title3.setHorizontalAlignment(JLabel.CENTER);
        add(title3).setBounds(0, 300, 400, 50);

        JButton menu = new JButton("Menü");

        businessPlayerScore = new BusinessPlayerScore();
        try {
            ArrayList<PlayerScoreInterface> highScoreList = businessPlayerScore.sortHighScoreDesc();

            for (int i = 0; i < highScoreList.size(); i++) {
                JLabel name = new JLabel(i+1 + ". " + highScoreList.get(i).getPlayerName());
                name.setFont(new Font("SansSerif", Font.PLAIN, 25));
                add(name).setBounds(450, 50 + (i * 40), 650, 50);
                JLabel score = new JLabel((""+highScoreList.get(i).getPlayerScore()));
                score.setFont(new Font("SansSerif", Font.PLAIN, 25));
                score.setHorizontalAlignment(JLabel.RIGHT);
                add(score).setBounds(500, 50 + (i * 40), 200, 50);
            }
        } catch (Exception e) {
            System.out.println("No high score, nothing to show");
        }

        ActionListener menuButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.getInstance().showMenu();

            }
        };

        menu.setBounds(20, 530, 120, 30);
        menu.addActionListener(menuButtonListener);
        add(menu);

        requestFocusInWindow();


    }

}
