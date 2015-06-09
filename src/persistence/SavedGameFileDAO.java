package persistence;

import business.businessGame.BusinessGame;

import java.io.*;

/**
 * Created by mai714 on 24.04.2015.
 * Class to save and load games
 */
public class SavedGameFileDAO implements SavedGameDAO, Serializable {

    /**
     * Function to save the game
     *
     * @param game object of an BusinessGame which holds all the game information
     */
    @Override
    public void saveGame(GameInterface game) {
        // System.out.println("im saveGameDaO");
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/resources/saveFiles/savedGame.ser");
            // System.out.println("erste Zeile");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            // System.out.println("zweite Zeile");
            objectOutput.writeObject(game);
            // System.out.println("dritte zeile");
            objectOutput.close();
            fileOutput.close();
            //  System.out.println("sollte gespeichert sein");

        } catch (Exception e) {
            System.out.println("SavedGameFileDAO: There was en error while saving the game");

        }


    }

    /**
     * function to load a previously saved Game
     *
     * @return a new Game object
     */
    @Override
    public GameInterface loadGame() {
        BusinessGame game;
        //System.out.println("im Save Game file angekommen");
        try {
            FileInputStream fileInput = new FileInputStream("src/resources/saveFiles/savedGame.ser");
            //System.out.println("zeile 1");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            // System.out.println("zeile2");
            game = (BusinessGame) objectInput.readObject();
            // System.out.println("zeile 3");
            objectInput.close();
            fileInput.close();
            // System.out.println("sollte ein volles GameObject sein");

            return game;
        } catch (Exception e) {
            System.out.println("SavedGameFileDAO: could not open the Save-File");

            return null;
        }


    }
}
