package presentation;

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
    JButton medium = new JButton("medium");
    JButton hard = new JButton("schwer");
    JButton load = new JButton("Laden");
    JButton exit = new JButton("Beenden");
    JButton highscore = new JButton("Highscore");
    JButton help = new JButton("Hilfe");

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

        JLabel savedGame = new JLabel("<HTML>" +
                                      "Schwierigkeitsgrad: " + "<br>" +
                                      "Gelöste Rechnungen: " + "<br>" +
                                      "Ungelöste Rechnungen: " + "<br>" +
                                      "Verbleibende Zeit: " +
                                      "</HTML>");
        add(savedGame).setBounds(500,250,300,80);
        // TODO: "Kein Spiel gespeichert" if no saved game exits

        load.addActionListener(cl);
        add(load).setBounds(500, 370, 200, 50);

        // footer navigation and copyright
        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout());
        add(footer).setBounds(0,560,300,40);
        footer.add(exit);
        footer.add(highscore);
        footer.add(help);
        JLabel copyright = new JLabel("© 2015 Jurij Maïkoff, Simon Leber");
        copyright.setHorizontalAlignment(JLabel.RIGHT);
        add(copyright).setBounds(400,560,380,40);

    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == easy) {
                Gui.getInstance().startGame(1);
            } else if (e.getSource() == medium) {
                Gui.getInstance().startGame(2);
            } else if (e.getSource() == hard) {
                Gui.getInstance().startGame(3);
            } else if (e.getSource() == load) {

            } else if (e.getSource() == exit) {

            } else if (e.getSource() == highscore) {

            } else if (e.getSource() == help) {

            }
        }
    }

}
