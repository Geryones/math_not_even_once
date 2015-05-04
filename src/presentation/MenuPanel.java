package presentation;

import business.businessGame.BusinessGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The menu.
 *
 * Created by simon on 12.04.15.
 */
public class MenuPanel extends JPanel {

    JButton easy = new JButton("einfach");
    JButton medium = new JButton("mittel");
    JButton hard = new JButton("schwer");
    JButton load = new JButton("Laden");
    JButton exit = new JButton("Beenden");
    JButton highscore = new JButton("Highscore");
    JButton help = new JButton("Hilfe");
    private JLabel savedGame=new JLabel();
    BusinessGame newBusinessGame;
    BusinessGame businessGame = new BusinessGame();


    public MenuPanel() {
        setLayout(null);

        ClickListener cl = new ClickListener();


        JLabel title1 = new JLabel("Math");
        title1.setFont(new Font("SansSerif", Font.PLAIN, 80));
        title1.setHorizontalAlignment(JLabel.CENTER);
        add(title1).setBounds(0, 30, 800, 80);

        JLabel title2 = new JLabel("not even once!");
        title2.setFont(new Font("SansSerif", Font.PLAIN, 30));
        title2.setHorizontalAlignment(JLabel.CENTER);
        add(title2).setBounds(0, 110, 800, 30);

        JLabel newGame = new JLabel("Neues Spiel");
        newGame.setFont(new Font("SansSerif", Font.PLAIN, 25));
        newGame.setHorizontalAlignment(JLabel.CENTER);
        add(newGame).setBounds(0, 200, 400, 25);

        easy.addActionListener(cl);
        add(easy).setBounds(100, 250, 200, 50);

        medium.addActionListener(cl);
        add(medium).setBounds(100, 310, 200, 50);

        hard.addActionListener(cl);
        add(hard).setBounds(100, 370, 200, 50);

        JLabel loadGame = new JLabel("Gespeichertes Spiel");
        loadGame.setFont(new Font("SansSerif", Font.PLAIN, 25));
        loadGame.setHorizontalAlignment(JLabel.CENTER);
        add(loadGame).setBounds(400, 200, 400, 25);

        actualiseSaveGame();

        add(savedGame).setBounds(500,250,300,80);


        load.addActionListener(cl);
        add(load).setBounds(500, 370, 200, 50);

        // footer navigation and copyright
        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout());
        add(footer).setBounds(0,530,300,40);
        footer.add(exit);
        exit.addActionListener(cl);
        footer.add(highscore);
        highscore.addActionListener(cl);
        footer.add(help);
        JLabel copyright = new JLabel("© 2015 Jurij Maïkoff, Simon Leber");
        copyright.setHorizontalAlignment(JLabel.RIGHT);
        add(copyright).setBounds(400,560,380,40);

    }

    /**
     * created by Jurij
     * Function to actualise the information about the saved game on the gamePanel
     */
    public void actualiseSaveGame(){
        String difficulty;

        newBusinessGame=businessGame.loadGame();

        if (newBusinessGame==null){
            savedGame.setText("Zurzeit kein gespeichertes Spiel");
        }else{
            switch (newBusinessGame.getDifficulty()){
                case 0:
                    difficulty="einfach";
                    break;
                case 1:
                    difficulty="mittel";
                    break;
                case 2:
                    difficulty="hard";
                    break;
                default:
                    difficulty="Problem?";
            }
            savedGame.setText("<HTML>" +
                    "SpielerName: " + newBusinessGame.getPlayerName() + "<br>" +
                    "Schwierigkeitsgrad: " + difficulty + "<br>" +
                    "Gelöste Rechnungen: " + newBusinessGame.getCountSolvedCalculations() + "<br>" +
                    "Score: " + newBusinessGame.getScore() + "<br>" +
                    "Verbleibende Zeit: " + newBusinessGame.getRemainingTime() +
                    "</HTML>");
        }

    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == easy) {
                Gui.getInstance().startGame(0);
            } else if (e.getSource() == medium) {
                Gui.getInstance().startGame(1);
            } else if (e.getSource() == hard) {
                Gui.getInstance().startGame(2);
            } else if (e.getSource() == load) {
                Gui.getInstance().loadGame(newBusinessGame);
            } else if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == highscore) {
                Gui.getInstance().showHighScore();
            } else if (e.getSource() == help) {
                System.out.println("not yet implemented");

            }
        }
    }

}
