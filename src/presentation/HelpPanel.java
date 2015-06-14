package presentation;

import javax.swing.*;

/**
 * Created by simon on 02.05.15.
 */
public class HelpPanel extends JPanel {
    private JLabel helpText = new JLabel();

    public HelpPanel() {
        helpText.setText("<HTML><h1>Hilfe</h1>" +
                         "Mit <i>Math - not even once</i> können Sie Ihre Kopfrechenkünste spielerisch trainieren<br>" +
                         "Es stehen drei Spielmodi zur Auswahl" +
                         "<dl>" +
                             "<dt><strong>einfach</strong></dt>" +
                             "<dd>Jede Aufgabe hat zwei Operanden.<br>" +
                                  "Punkte pro gelöste Aufgabe: <br>" +
                                  "Zusätzliche Zeit pro gelöste Aufgabe: <br><br></dd>" +
                             "<dt><b>mittel</b></dt>" +
                                  "<dd>Jede Aufgabe hat drei Operanden, teilweise mit Klammern.<br>" +
                                  "Punkte pro gelöste Aufgabe: <br>" +
                                  "Zusätzliche Zeit pro gelöste Aufgabe: <br><br></dd>" +
                             "<dt><b>schwer</b></dt>" +
                                  "<dd>Jede Aufgabe hat vier Operanden, teilweise mit Klammern.<br>" +
                                  "Punkte pro gelöste Aufgabe: <br>" +
                                  "Zusätzliche Zeit pro gelöste Aufgabe: <br></dd>" +
                         "</dl>" +
                         "Balken, Speichern, Laden"
                        );
        add(helpText).setBounds(45,70,50,50);
    }
}
