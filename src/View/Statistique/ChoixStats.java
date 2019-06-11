package View.Statistique;

import Constants.Colors;
import Model.Classe;
import Model.Personne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <b>Jpanel qui permet le choix de l'affichage des stats</b>
 * @author Leonard
 * @version 1.0
 */
public class ChoixStats extends JPanel implements ActionListener {
    //attributs
    private JButton graphEleveNiveau;
    private JButton proportionProfEleve;
    private ArrayList<Classe> mesClasses;
    private ArrayList<Personne> personne;


    /**
     * <b>Constructeur par defaut</b>
     * @param  mesClasses_ arraylist de classes
     * @param  personne_ arraylist de personnes
     */
    public ChoixStats(ArrayList<Classe> mesClasses_,ArrayList<Personne> personne_) {
        mesClasses=mesClasses_;
        personne=personne_;
        init();
    }

    /**
     * <b>Methode d'intialisaation des composants</b>
     */
    public void init(){
        graphEleveNiveau = new JButton("Graphe des élèves par niveau");
        proportionProfEleve = new JButton("Proportion de prof et d'élève dans l'école");
        graphEleveNiveau.addActionListener(this);
        proportionProfEleve.addActionListener(this);
        // Layout
        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);

        this.add(graphEleveNiveau);
        this.add(proportionProfEleve);
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

        if(button.getText()=="Graphe des élèves par niveau"){
            Reporting.graphEleveNiveau(mesClasses);
        }

        if(button.getText()=="Proportion de prof et d'élève dans l'école"){
            Reporting.graphEleveProf_ecole(personne);
        }
    }
}
