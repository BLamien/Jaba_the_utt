package View.HomeScreen.Ajout.Formulaires;

import Constants.Colors;
import View.HomeScreen.ModelsTable.ModelTableDevoir;
import View.HomeScreen.ModelsTable.ModelTableEnseignement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <b>JPanel du JFrame ajoutPersonne</b>
 * @author Leonard
 * @version 1.0
 */
public class FormulaireEnseignement extends JPanel {
    //Attributs
    JButton valider;
    JTextField discipline;
    JTextField enseignant;
    JTextField classe;
    //JTextField classe;    il faut rajouter la liste de toutes les personnes
    ModelTableEnseignement modele;
    /**
     * Constructeur
     * @param m modele de la table pour ajout
     */
    public FormulaireEnseignement(ModelTableEnseignement m) {
        modele=m;
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        discipline = new JTextField();
        enseignant = new JTextField();
        classe = new JTextField();
        

        valider = new JButton("Ajouter");


        discipline.setPreferredSize(new Dimension(300,30));
        enseignant.setPreferredSize(new Dimension(300,30));
        classe.setPreferredSize(new Dimension(300,300));


        JLabel disciplineStringLabel = new JLabel("Discipline : ");
        JLabel enseignantStringLabel = new JLabel("Enseignant : ");
        JLabel classeStringLabel = new JLabel("Classe : ");
        disciplineStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        enseignantStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        classeStringLabel.setFont(new Font("Verdana",Font.BOLD,18));


        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(disciplineStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(discipline, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(classeStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(classe, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(enseignantStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(enseignant, constraints);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        this.add(valider, constraints);

        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);
    }


    public JButton getValider() {
        return valider;
    }
    public void setValider(JButton valider) {
        this.valider = valider;
    }
    public JTextField getDiscipline() {
        return discipline;
    }
    public void setDiscipline(JTextField discipline) {
        this.discipline = discipline;
    }
    public JTextField getEnseignant() {
        return enseignant;
    }
    public void setEnseignant(JTextField enseignant) {
        this.enseignant = enseignant;
    }
    public JTextField getClasse() {
        return classe;
    }
    public void setClasse(JTextField classe) {
        this.classe = classe;
    }
}
