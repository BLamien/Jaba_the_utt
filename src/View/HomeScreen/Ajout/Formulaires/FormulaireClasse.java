package View.HomeScreen.Ajout.Formulaires;

import Constants.Colors;
import View.HomeScreen.ModelsTable.ModelTableClasse;

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
    JTextField ecole;
    JTextField nom_niveau;
    JTextField annee_scolaire;
    JList<String> listPersonnes = new JList<>();
    JList<String> listEcoles = new JList<>();

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
        ecole = new JTextField();
        nom_niveau = new JTextField();
        annee_scolaire = new JTextField();
        

        valider = new JButton("Ajouter");


        ecole.setPreferredSize(new Dimension(300,30));
        nom_niveau.setPreferredSize(new Dimension(300,30));
        annee_scolaire.setPreferredSize(new Dimension(300,300));


        JLabel ecoleStringLabel = new JLabel("Ecole : ");
        JLabel nom_niveauStringLabel = new JLabel("Niveau : ");
        JLabel annee_scolaireStringLabel = new JLabel("Année scolaire : ");
        JLabel personnesStringLabel = new JLabel("Membres : ");
        ecoleStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        nom_niveauStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        annee_scolaireStringLabel.setFont(new Font("Verdana",Font.BOLD,18));

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (int i=0;i<modele.getPersonnes().size();i++){
            l1.addElement(modele.getPersonnes().get(i).getNom());
        };
        listPersonnes = new JList<>(l1);
        listPersonnes.setBounds(100,100, 75,75);

        DefaultListModel<String> l2 = new DefaultListModel<>();
        for(int i=0;i<modele.getEcoles().size();i++){
            l2.addElement(modele.getEcoles().get(i).getNom_ecole());
        }
        listEcoles = new JList<>(l2);
        listEcoles.setBounds(100,100,75,75);


        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(ecoleStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(listEcoles, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(annee_scolaireStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(annee_scolaire, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(nom_niveauStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(nom_niveau, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(personnesStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(listPersonnes, constraints);
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
    public JList<String> getListPersonnes() {
        return listPersonnes;
    }
    public JList<String> getListEcoles() {
        return listEcoles;
    }
}
