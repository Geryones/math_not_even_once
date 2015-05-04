package presentation;

import business.businessGame.BusinessPlayerScore;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * Created by mai714 on 04.05.2015.
 * Panel where u can see the whole HighScore-List
 *
 */
public class HighScorePanel extends JPanel {

    BusinessPlayerScore businessPlayerScore;



   ArrayList<JLabel> labelArrayList = new ArrayList<JLabel>();


    /**
     * Constructor, 10 JLabel's are created and filled with PlayerName and the Score
     */
    public HighScorePanel(){
     JButton menu = new JButton("Menü");
        setLayout(null);

        businessPlayerScore = new BusinessPlayerScore();
        ArrayList<BusinessPlayerScore> highScoreList=businessPlayerScore.sortHighScoreDesc();

        for (int i =0;i<highScoreList.size();i++){
            labelArrayList.add(new JLabel());
            labelArrayList.get(i).setText(highScoreList.get(i).getPlayerName()+"  "+highScoreList.get(i).getPlayerScore());
            labelArrayList.get(i).setBounds(100,25+(i*50),650,50);
           labelArrayList.get(i).setFont(new Font("SansSerif", Font.BOLD, 25));
            add(labelArrayList.get(i));
        }

        ActionListener menuButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.getInstance().showMenu();

            }
        };

        menu.setBounds(180, 515, 120, 30);
        menu.addActionListener(menuButtonListener);
        add(menu);

        requestFocusInWindow();



    }

}
