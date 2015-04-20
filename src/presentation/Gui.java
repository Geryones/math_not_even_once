package presentation;

import business.timer.TimerClass;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by simon on 06.04.15.
 */
public class Gui  extends JFrame implements Observer {

    private static Gui instance;
    GamePanel game;
    MenuPanel menu = new MenuPanel();


    private Vector<TimerClass> observerList = new Vector<TimerClass>();

    private Gui() {

        // some basic settings
        setSize(800, 600);
        setResizable(false);
        setTitle("math, not even once!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // no layout manager but absolute positioning

        add(menu).setBounds(0,0,800,600);

        setVisible(true); // setVisible should be called last to assure the JFrame is not blank
        requestFocusInWindow();


    }

    public void showMenu() {
        endGame();
        if(game != null) remove(game);
        add(menu).setBounds(0, 0, 800, 600);
        repaint();
    }

    public void startGame(int difficulty) {
        // TODO: switch statement for difficulty
        remove(menu);
        game = new GamePanel();
        add(game).setBounds(0, 0, 800, 600);
        repaint();

        TimerClass timerTeil = new TimerClass();
        timerTeil.setRemainingTime(20);


    }

    public void endGame() {
        // TODO: end the game if running. ask player if game should be saved
    }


    public static Gui getInstance () {
        if (Gui.instance == null) {
            Gui.instance = new Gui();
        }
        return Gui.instance;
    }


    /**
     * Muas ih no macha
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        String time = (String)arg;
        game.setTimer(time);
        System.out.println("updatet");
    }





}