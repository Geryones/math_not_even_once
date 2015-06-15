package persistence;

import business.businessGame.BusinessGame;

import java.io.*;

/**
 * Created by simon and mai714 on 24.04.2015.
 *
 * saves and loads games
 */
public class SavedGameFileDAO implements SavedGameDAO, Serializable {

    /**
     * saves the game
     *
     * @param game object of an BusinessGame which holds all the game information
     */
    @Override
    public void saveGame(GameInterface game) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/resources/saveFiles/savedGame.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(game);
            objectOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            System.err.println("SavedGameFileDAO: error while saving the game");
        }


    }

    /**
     * loads a previously saved game
     *
     * @return a new Game object
     */
    @Override
    public GameInterface loadGame() {
        BusinessGame game;
        try {
            FileInputStream fileInput = new FileInputStream("src/resources/saveFiles/savedGame.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            game = (BusinessGame) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return game;
        } catch (Exception e) {
            System.err.println("SavedGameFileDAO: could not open the save file");
            return null;
        }


    }
}
