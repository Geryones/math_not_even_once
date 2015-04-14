package presentation;

import java.awt.*;
import javax.swing.*;

public class HighscoreBar extends JPanel
{
    int score = 0;
    int highscore = 200; //TODO: set dynamically
    int progress;

    public HighscoreBar()  {
        setLayout(null);
        add(new JLabel("0")).setBounds(0, 55, 10, 15);
        JLabel currentHighscore = new JLabel("aktuelle Highscore (" + highscore + ")");
        currentHighscore.setHorizontalAlignment(JLabel.RIGHT);
        add(currentHighscore).setBounds(200,55,500,15);
    }

    public void paintBar(int score) {
        this.score = score;
        this.progress = (int)(score*700/highscore);
        repaint();
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // antialiasing for the "Neue Highscore!" string
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // the actual bar
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,this.progress,50);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,700,50);
        if(this.score > this.highscore) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.PLAIN, 25));
            g.drawString("Neue Highscore!",242,32);
        }
    }
}