package business.notification;

/**
 * Created by mai714 on 06.05.2015.
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * hier werden die sound dateien geladen
 *
 * @author mai714
 *
 */
public class Sound {

    /**
     * Datei und Funktion um bei einem falschen Resultat einen charakteristischen sound abspielen zu k�nnen
     */
    public  void soundfalsch(){


        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    new File("src/resources/sounds/nope.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }

        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
    }
    /**
     *  Datei und Funktion um bei einem richtigen Resultat einen charakteristischen sound abspielen zu k�nnen
     */
    public  void soundrichtig(){


        try {
            AudioInputStream richtig = AudioSystem.getAudioInputStream(
                    new File("src/resources/sounds/jap.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(richtig);
            clip.start();
        }

        catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
    }

}
