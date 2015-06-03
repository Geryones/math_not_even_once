package business.notification;

/**
 * Created by mai714 on 06.05.2015.
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Class which hosts the funktions to play sounds
 *
 * @author mai714
 */
public class Sound {

    /**
     * Function to play the sound for a wrong answer
     */
    public void soundfalsch() {


        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    new File("src/resources/sounds/nope.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException uae) {
            System.out.println(uae);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (LineUnavailableException lua) {
            System.out.println(lua);
        }
    }

    /**
     * Function to play the sound for a correct answer
     */
    public void soundrichtig() {


        try {
            AudioInputStream richtig = AudioSystem.getAudioInputStream(
                    new File("src/resources/sounds/jap.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(richtig);
            clip.start();
        } catch (UnsupportedAudioFileException uae) {
            System.out.println(uae);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (LineUnavailableException lua) {
            System.out.println(lua);
        }
    }

    /**
     * Function to play the sound for a correct answer
     */
    public void newHighScore() {


        try {
            AudioInputStream highScore = AudioSystem.getAudioInputStream(
                    new File("src/resources/sounds/highscore.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(highScore);
            clip.start();
        } catch (UnsupportedAudioFileException uae) {
            System.out.println(uae);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (LineUnavailableException lua) {
            System.out.println(lua);
        }
    }

}
