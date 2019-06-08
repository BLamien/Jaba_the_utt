package View.HomeScreen.Ajout.Formulaires;

import Constants.Colors;
import View.HomeScreen.ModelsTable.ModelTableClasse;
import View.HomeScreen.ModelsTable.ModelTableDevoir;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <b>JPanel du JFrame ajoutPersonne</b>
 * @author Leonard
 * @version 1.0
 */
public class FormulaireClasse extends JPanel {
    //Attributs
    JButton valider;
    JTextField id_classe;
    JTextField ecole;
    JTextField nom_niveau;
    JTextField annee_scolaire;
    //JTextField classe;    il faut rajouter la liste de toutes les personnes
    ModelTableClasse modele;
    /**
     * Constructeur
     * @param m modele de la table pour ajout
     */
    public FormulaireClasse(ModelTableClasse m) {
        modele=m;
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        id_classe = new JTextField();
        ecole = new JTextField();
        nom_niveau = new JTextField();
        annee_scolaire = new JTextField();
        

        valider = new JButton("Ajouter");


        id_classe.setPreferredSize(new Dimension(300,30));
        ecole.setPreferredSize(new Dimension(300,30));
        nom_niveau.setPreferredSize(new Dimension(300,30));
        annee_scolaire.setPreferredSize(new Dimension(300,300));


        JLabel id_classeStringLabel = new JLabel("Id : ");
        JLabel ecoleStringLabel = new JLabel("Note : ");
        JLabel nom_niveauStringLabel = new JLabel("Appreciation : ");
        JLabel annee_scolaireStringLabel = new JLabel("Année scolaire : ");
        id_classeStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        ecoleStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        nom_niveauStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        annee_scolaireStringLabel.setFont(new Font("Verdana",Font.BOLD,18));


        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(id_classeStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(id_classe, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(ecoleStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(ecole, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(annee_scolaireStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(annee_scolaire, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(nom_niveauStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(nom_niveau, constraints);
        constraints.gridx=0;
        constraints.gridy=4;
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
    public JTextField getId_classe() {
        return id_classe;
    }
    public void setId_classe(JTextField id_classe) {
        this.id_classe = id_classe;
    }
    public JTextField getEcole() {
        return ecole;
    }
    public void setEcole(JTextField ecole) {
        this.ecole = ecole;
    }
    public JTextField getNom_niveau() {
        return nom_niveau;
    }
    public void setNom_niveau(JTextField nom_niveau) {
        this.nom_niveau = nom_niveau;
    }
    public JTextField getAnnee_scolaire() {
        return annee_scolaire;
    }
    public void setAnnee_scolaire(JTextField annee_scolaire) {
        this.annee_scolaire = annee_scolaire;
    }
}
