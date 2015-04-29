package presentation;

import business.calc.CalcFactory;
import business.calc.InterfaceCalc;
import business.timer.TimerClass;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by simon on 12.04.15.
 */
public class GamePanel extends JPanel implements Observer {

    HighscoreBar highscoreBar = new HighscoreBar();
    private JTextField resultInput = new JTextField();
    private JLabel term = new JLabel();
    private JButton menu = new JButton("Menü");
    private JLabel timer;
    private JButton ok;


     //von Jurij
    InterfaceCalc calcInterface;
    Handler theHandler = new Handler();
    TimerClass timerTeil;
    Game game = new Game();


    private int difficulty;


    public GamePanel(int difficulty) {
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
        resultInput.setBounds(270, 250, 200, 50);
        add(resultInput);
        resultInput.addActionListener(theHandler);

        ok=new JButton("OK");
        ok.setFont(inputFont);
        ok.setHorizontalAlignment(JTextField.CENTER);
        ok.setBounds(485, 250, 80, 50);
        add(ok);
        ok.addActionListener(theHandler);


        // the highscore bar
        highscoreBar.setBounds(48, 400, 701, 100);
        highscoreBar.paintBar(150);
        add(highscoreBar);

        // save and menu button
        Font bottomButtons = new Font("SansSerif", Font.BOLD, 15);
        JButton save = new JButton("Speichern");
        save.setFont(bottomButtons);
        save.setBounds(50, 515, 120, 30);
        add(save);

        ActionListener menuButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.getInstance().showMenu();
            }
        };
        this.menu.setFont(bottomButtons);
        this.menu.setBounds(180, 515, 120, 30);
        this.menu.addActionListener(menuButtonListener);
        add(this.menu);

        // the countdown
        timer = new JLabel("⌚ " + "23" + " s");
        timer.setBounds(400, 500, 350, 50);
        timer.setBackground(Color.cyan);
        timer.setFont(new Font("SansSerif", Font.PLAIN, 50));
        timer.setHorizontalAlignment(JLabel.RIGHT);
        add(timer);

        requestFocusInWindow();

        //Adding the timer to the Gui
        timerTeil = new TimerClass();
        timerTeil.setTotalDuration(2);

        timerTeil.addObserver(this);

        //Set up the Game-File and prepare the first Calculation
        setCalc(difficulty);
        game.setDifficulty(difficulty);
        game.setCountSolvedCalculations(0);
        game.setScore(0);

    }

    public void setTimer(String seconds) {

        timer.setText("⌚ " + seconds + " s");
    }

    /**
     * Created by Jurij
     *
     * @param o   All the observers are being updated
     * @param arg contains a long with the time-value
     */
    @Override
    public void update(Observable o, Object arg) {


        String time = String.valueOf(arg);
        if (time.equals("0")) {
            term.setText("Your Score: "+game.getScore());

            resultInput.setText("Enter your Name");



        }
        setTimer(time);


    }


    /**
     * Created by Jurij
     *
     * @param difficulty determines the difficulty of the calculation
     */
    public void setCalc(int difficulty) {
        calcInterface = CalcFactory.getInstance().createCalculation(difficulty);
        term.setText(calcInterface.createCalc());
        setDifficulty(difficulty);

    }

    /**
     * Class to determine the behaviour of the OK-Button
     */
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            // As soon as the timer hits zero, things get messed up... if there is a string in the result input, and you hit oke, it throws  an error
            //if the field is empty and you hit enter nothing happens, it seems it never reaches this if-else structure
         /*   if (timerTeil.getRemainingTime()==0){

                game.setPlayerName(resultInput.getText());
            }else */if (calcInterface.correct(Integer.parseInt(resultInput.getText()))) {

               setCalc(getDifficulty());
               resultInput.setText(null);
               game.setCountSolvedCalculations(game.getCountSolvedCalculations() + 1);
               game.setScore(game.getScore() + (1 * difficulty));
               timerTeil.setTotalDuration(timerTeil.getTotalDuration() + 10);

           }





        }
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


}

