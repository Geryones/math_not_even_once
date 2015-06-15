package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by simon on 02.05.15.
 *
 * Contains the help text
 */
public class HelpPanel extends JPanel {
    private JLabel helpText = new JLabel();
    private JButton menu = new JButton("Menü");

    public HelpPanel() {
        setLayout(null);

        helpText.setText("<HTML><h1>Hilfe</h1>" +
                        "Mit <i>Math - not even once</i> können Sie Ihre Kopfrechenkünste spielerisch trainieren<br>" +
                        "Es stehen drei Spielmodi zur Auswahl:" +
                        "<dl>" +
                        "<dt><strong>einfach</strong></dt>" +
                        "<dd>Jede Aufgabe hat zwei Operanden.<br>" +
                        "Punkte pro gelöste Aufgabe: 1<br>" +
                        "Zusätzliche Zeit pro gelöste Aufgabe: 10 Sekunden<br></dd>" +
                        "<dt><b>mittel</b></dt>" +
                        "<dd>Jede Aufgabe hat drei Operanden, teilweise mit Klammern.<br>" +
                        "Punkte pro gelöste Aufgabe: 2<br>" +
                        "Zusätzliche Zeit pro gelöste Aufgabe: 20 Sekunden<br></dd>" +
                        "<dt><b>schwer</b></dt>" +
                        "<dd>Jede Aufgabe hat vier Operanden, teilweise mit Klammern.<br>" +
                        "Punkte pro gelöste Aufgabe: 3<br>" +
                        "Zusätzliche Zeit pro gelöste Aufgabe: 30 Sekunden<br></dd>" +
                        "</dl>" +
                        "Klicken Sie auf einen der drei Schwierigkeitsgrade um ein neues Spiel zu beginnen. Die " +
                        "Lösung muss in das Feld unter der Aufgabe eingegeben werden und wird nach dem Klick auf " +
                        "den OK-Button oder nach dem Drücken von Return auf Richtigkeit geprüft. War die Lösung " +
                        "falsch, passiert nichts und es muss weiter versucht werden die richtige Lösung zu finden; " +
                        "war sie richtig, erscheint die nächste Aufgabe. Der Balken unter dem Eingabefeld zeigt an, " +
                        "wie viel Prozent der aktuellen Highscore bereits im laufenden Spiel erreicht worden ist.<br><br>" +
                        "Das laufende Spiel kann mit einem Klick auf Speichern gesichert und anschliessend im Menü " +
                        "wieder geladen werden. Beim Speichern besteht die Möglichkeit den eigenen Namen einzugeben.<br><br>" +
                        "Ist die Zeit abgelaufen und die erreichte Punktezahl ist hoch genug, um in der auf 10 Einträge " +
                        "limitierten Highscore-Liste zu erscheinen, kann ebenfalls der eigene Name eingegeben werden.<br><br>" +
                        "Viel Spass mit <i>Math - not even once</i>!" +
                        "</HTML>"
        );
        add(helpText).setBounds(20,0,760,530);

        ActionListener menuButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui.getInstance().showMenu();
            }
        };

        menu.setBounds(20, 530, 120, 30);
        menu.addActionListener(menuButtonListener);
        add(menu);
    }
}
