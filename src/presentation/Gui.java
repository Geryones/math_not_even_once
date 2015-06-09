package presentation;

import business.businessGame.BusinessGame;

import javax.swing.*;

/**
 * Created by simon on 06.04.15.
 */
public class Gui extends JFrame {

    private static Gui instance;
    GamePanel game;
    MenuPanel menu = new MenuPanel();
    HighScorePanel highScorePanel;


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
        endGame();
        if (game != null) remove(game);
        if (highScorePanel != null) remove(highScorePanel);
        menu.actualiseSaveGame();
        add(menu).setBounds(0, 0, 800, 600);
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

            game.timerTeil.setTotalDuration(businessGame.getRemainingTime());
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

    public void endGame() {
        // TODO: end the game if running. ask player if game should be saved
    }


    public static Gui getInstance() {
        if (Gui.instance == null) {
            Gui.instance = new Gui();
        }
        return Gui.instance;
    }


}