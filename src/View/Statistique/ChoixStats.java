package View.Statistique;

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * <b>Jpanel qui permet le choix de l'affichage des stats</b>
 * @author Leonard
 * @version 1.0
 */
public class ChoixStats extends JPanel implements ActionListener {
    //attributs
    private JButton camembert;
    private JButton graphBaton;

    /**
     * <b>Constructeur par defaut</b>
     */
    public ChoixStats() {
        init();
    }

    /**
     * <b>Methode d'intialisaation des composants</b>
     */
    public void init(){
        camembert = new JButton("Graphe Camembert");
        graphBaton = new JButton("Graphe baton");
        camembert.addActionListener(this);
        graphBaton.addActionListener(this);
        // Layout
        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);

        this.add(camembert);
        this.add(graphBaton);
    }

    public void suppr(){
        setVisible(false);
        remove(this);
    }

    /**
     * Methode qui gere les actions des boutons lorsqu'on leurs clique dessus
     * @param e evenement lorsque l'on clique sur un des boutons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button.getText()=="Graphe Camembert"){
            Reporting.pieChart2parts("categorie1", 43.2,
                    "categorie2", 27.9,
                    "titreFenetre",
                    "titreChart", true, true, false);
        }

        if(button.getText()=="Graphe baton"){
            Reporting.barChartDouble3parts("categorie1", "categorie2",
                    "column1", "column2", "column3",
                    1.0, 5.0, 3.0,
                    2.0, 3.0, 2.0,
                    "titrefenetre", "titreChart", "xLabel", "ylLabel",
                    true, true, false);
        }
    }
}
