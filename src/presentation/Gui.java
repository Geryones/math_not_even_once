package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by simon on 06.04.15.
 */
public class Gui extends JFrame {

    HighscoreBar highscoreBar = new HighscoreBar();
    JTextField resultInput = new JTextField();
    JLabel term = new JLabel("1337 + 42");

    public Gui() {

        // some basic settings
        setSize(800, 600);
        setResizable(false);
        setTitle("math, not even once!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // no layout manager but absolute positioning

        // the term to calculate
        this.term.setBounds(0, 120, 800, 80);
        this.term.setFont(new Font("SansSerif", Font.PLAIN, 80));
        this.term.setHorizontalAlignment(JLabel.CENTER);
        add(term);

        // input text field for the result
        Font inputFont = new Font("SansSerif", Font.BOLD, 25);
        JLabel equals = new JLabel("=");
        equals.setBounds(235, 250, 50, 50);
        equals.setFont(inputFont);
        add(equals);
        resultInput.setFont(inputFont);
        resultInput.setHorizontalAlignment(JTextField.CENTER);
        resultInput.setBounds(270,250,200,50);
        add(resultInput);
        JButton ok = new JButton("OK");
        ok.setFont(inputFont);
        ok.setHorizontalAlignment(JTextField.CENTER);
        ok.setBounds(485,250,80,50);
        add(ok);


        // the highscore bar
        highscoreBar.setBounds(48,400,701,100);
        highscoreBar.paintBar(150);
        add(highscoreBar);

        // save and menu button
        Font bottomButtons = new Font("SansSerif", Font.BOLD, 15);
        JButton save = new JButton("Speichern");
        save.setFont(bottomButtons);
        save.setBounds(50, 515, 120, 30);
        add(save);
        JButton menu = new JButton("Menü");
        menu.setFont(bottomButtons);
        menu.setBounds(180,515,120,30);
        add(menu);

        // the countdown
        JLabel timer = new JLabel("⌚ " + "23" + " s");
        timer.setBounds(400, 500, 350, 50);
        timer.setBackground(Color.cyan);
        timer.setFont(new Font("SansSerif", Font.PLAIN, 50));
        timer.setHorizontalAlignment(JLabel.RIGHT);
        add(timer);




        // menu.add(new JLabel("Beispiel JLabel"));
        // removeAll();


        // setVisible should be called last to assure the JFrame is not blank
        setVisible(true);
    }

    public void getTerm(String term) {
        this.term.setText(term);
    }
}