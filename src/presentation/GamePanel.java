package presentation;

import business.businessGame.BusinessGame;
import business.businessGame.BusinessPlayerScore;
import business.calc.CalcFactory;
import business.calc.InterfaceCalc;
import business.notification.Sound;
import business.timer.TimerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by simon on 12.04.15.
 *
 * This class draws the actual game with the term to solve, an input field for the result,
 * the timer and some buttons.
 */
public class GamePanel extends JPanel implements Observer {

    HighscoreBar highscoreBar = new HighscoreBar();
    private JTextField resultInput = new JTextField();
    private JLabel term = new JLabel();

    private JLabel timer;
    private JButton ok;
    private JButton save = new JButton("Speichern");
    private boolean isSaving = false;


    //von Jurij
    InterfaceCalc calcInterface;
    Handler theHandler = new Handler();
    TimerClass timerTeil;
    BusinessGame game = new BusinessGame();
    BusinessPlayerScore playerScore = new BusinessPlayerScore();
    BusinessGame businessGame;
    Sound sound = new Sound();


    private int difficulty;


    public GamePanel(int difficulty) {

        JButton menu = new JButton("Menü");

        setLayout(null); // no layout manager but absolute positioning

        // the term to calculate
        this.term.setBounds(0, 120, 800, 80);
        this.term.setFont(new Font("SansSerif", Font.PLAIN, 50));
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

        ok = new JButton("OK");
        ok.setFont(inputFont);
        ok.setHorizontalAlignment(JTextField.CENTER);
        ok.setBounds(485, 250, 80, 50);
        add(ok);
        ok.addActionListener(theHandler);


        // the highscore bar
        highscoreBar.setBounds(48, 400, 701, 100);
        //highscoreBar.paintBar(150);
        add(highscoreBar);

        // save and menu button
        Font bottomButtons = new Font("SansSerif", Font.BOLD, 15);
        save.setFont(bottomButtons);
        save.addActionListener(theHandler);
        save.setBounds(50, 515, 120, 30);
        add(save);

        ActionListener menuButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.getInstance().showMenu();
                timerTeil.setIsRunning(false);
            }
        };
        menu.setFont(bottomButtons);
        menu.setBounds(180, 515, 120, 30);
        menu.addActionListener(menuButtonListener);
        add(menu);

        // the countdown
        timer = new JLabel();
        timer.setBounds(400, 500, 350, 50);
        timer.setBackground(Color.cyan);
        timer.setFont(new Font("SansSerif", Font.PLAIN, 50));
        timer.setHorizontalAlignment(JLabel.RIGHT);
        add(timer);

        requestFocusInWindow();

        //Adding the timer to the Gui
        timerTeil = new TimerClass();
        timerTeil.setTotalDuration(60);

        timerTeil.addObserver(this);

        //Set up the Game-File and prepare the first Calculation
        setCalc(difficulty);
        game.setDifficulty(difficulty);
        game.setCountSolvedCalculations(0);
        game.setScore(0);

    }

    /**
     * Sets the remaining time on the gamePanel
     *
     * @param seconds remaining seconds
     */
    public void setTimer(String seconds) {

        timer.setText(seconds + " s");
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
        //System.out.println(timerTeil.getRemainingTime());
        if (time.equals("0")) {
            prepareTheEnd();
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
     * Created by Jurij
     * Class to determine the behaviour of the OK-Button
     */
    public class Handler implements ActionListener {
        boolean firstTime = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            /*
            If the the cursor is in the resultInput and you hit Enter
            clickinig the OK-button
             */
                if (e.getSource() == ok || e.getSource() == resultInput) {


                    // Do nothing if there is nothing in the resultInput
                    if (resultInput.getText().equals("")) {

                    /*
                    If the time is 0, and the user is not saving, come here
                     */
                    } else if (timerTeil.getRemainingTime() == 0 && !isSaving) {
                        playerScore.setPlayerName(resultInput.getText());
                        playerScore.setScore(game.getScore());
                        BusinessPlayerScore businessPlayerScore = new BusinessPlayerScore(playerScore);
                        businessPlayerScore.safePlayerScore();
                        Gui.getInstance().showMenu();

                    /*
                    If the user is not saving and the entered Number is correct
                    maybe errors if you enter a string which is not numbers only
                     */
                    } else if (!isSaving && calcInterface.correct(Integer.parseInt(resultInput.getText()))) {
                        setCalc(getDifficulty());
                        resultInput.setText(null);
                        game.setCountSolvedCalculations(game.getCountSolvedCalculations() + 1);
                        game.setScore(game.getScore() + (difficulty + 1));
                        timerTeil.setTotalDuration(timerTeil.getTotalDuration() + 10 * (1 + difficulty));
                        highscoreBar.setHighScoreProgress(game.getScore());
                        if (highscoreBar.getPercentage() == 1 && firstTime) {
                            sound.newHighScore();
                            firstTime = false;
                        }

                    /*
                     if the user wants to safe, the boolean isSaving brings you here.
                      All the necessary Information is transferred and saved
                     */
                    } else if (isSaving) {
                        game.setPlayerName(resultInput.getText());
                        businessGame = new BusinessGame(game);
                        businessGame.safeGame();
                        Gui.getInstance().showMenu();


                    }
            /*
            if you hit the save button midgame
            the timer gets canceled
             */
                } else if (e.getSource().equals(save)) {

                    game.setRemainingTime(timerTeil.getRemainingTime());
                    timerTeil.setIsRunning(false);
                    isSaving = true;
                    prepareTheEnd();


                }
            } catch (Exception E) {
                System.out.println("maybe problem");
            }


        }
    }

    /**
     * Preparation for exiting the gamePanel
     */
    public void prepareTheEnd() {
        term.setText("Your Score: " + game.getScore());
        resultInput.setText("Enter your Name");

    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


}

