package presentation;

import business.businessGame.BusinessGame;

import javax.swing.*;

/**
 * Created by simon on 06.04.15.
 *
 * The JFrame which contains the different panels
 */
public class Gui extends JFrame {

    private static Gui instance;
    private GamePanel game;
    private MenuPanel menu = new MenuPanel();
    private HighScorePanel highScorePanel;
    private HelpPanel help;


    private Gui() {

        // some basic settings
        setSize(800, 600);
        setResizable(false);
        setTitle("math, not even once!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // no layout manager but absolute positioning

        add(menu).setBounds(0, 0, 800, 600);

        setVisible(true); // setVisible should be called last to assure the JFrame is not blank
        requestFocusInWindow();
    }

    public void showMenu() {
        if (game != null) remove(game);
        if (highScorePanel != null) remove(highScorePanel);
        if (help != null) remove(help);
        menu.actualiseSaveGame();
        add(menu).setBounds(0, 0, 800, 600);
        repaint();
    }

    public void showHelp() {
        help = new HelpPanel();
        remove(menu);
        add(help).setBounds(0, 0, 800, 600);
        repaint();
    }

    public void startGame(int difficulty) {
        remove(menu);
        game = new GamePanel(difficulty);
        add(game).setBounds(0, 0, 800, 600);
        repaint();
    }

    /**
     * Created by Jurij
     * Reads a previously saved File, which contains all the information for a Game
     *
     * @param businessGame a BusinessObject which holds the necessary information
     */
    public void loadGame(BusinessGame businessGame) {
        remove(menu);
        try {
            game = new GamePanel(businessGame.getDifficulty());

            game.timerPart.setTotalDuration(businessGame.getRemainingTime());
            game.game.setDifficulty(businessGame.getDifficulty());
            game.game.setRemainingTime(businessGame.getRemainingTime());
            game.game.setPlayerName(businessGame.getPlayerName());
            game.game.setCountSolvedCalculations(businessGame.getCountSolvedCalculations());
            game.game.setScore(businessGame.getScore());
            game.highscoreBar.setHighScoreProgress(game.game.getScore());
            add(game).setBounds(0, 0, 800, 600);
            repaint();

        } catch (Exception e) {
            System.out.println("Gui: failed to load the game");
            JOptionPane.showMessageDialog(menu, "Game Crashed, please quit and restart the game");
        }


    }

    public void showHighScore() {
        remove(menu);
        highScorePanel = new HighScorePanel();
        add(highScorePanel).setBounds(0, 0, 800, 600);
        repaint();
    }


    public static Gui getInstance() {
        if (Gui.instance == null) {
            Gui.instance = new Gui();
        }
        return Gui.instance;
    }


}