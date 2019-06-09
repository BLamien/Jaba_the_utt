package View.HomeScreen.Ajout.Formulaires;

import Constants.Colors;
import View.HomeScreen.ModelsTable.ModelTablePersonne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <b>JPanel du JFrame ajoutPersonne</b>
 * @author Leonard
 * @version 1.0
 */
public class FormulairePersonne extends JPanel {
    //Attributs
    JButton valider;
    JComboBox type;
    JTextField prenom;
    JTextField nom;
    JTextField userName;
    JPasswordField password;
    ModelTablePersonne modele;
    JList<String> listClasses = new JList<>();


    /**
     * Constructeur
     * @param m modele de la table pour ajout
     */
    public FormulairePersonne(ModelTablePersonne m) {
        modele=m;
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        String sType[]={"Ensignants","Eleves"};
        type = new JComboBox(sType);
        nom = new JTextField();
        prenom = new JTextField();
        userName = new JTextField();
        password = new JPasswordField();
        valider = new JButton("Ajouter");


        type.setPreferredSize(new Dimension(300,30));
        nom.setPreferredSize(new Dimension(300,30));
        prenom.setPreferredSize(new Dimension(300,30));
        userName.setPreferredSize(new Dimension(300,30));
        password.setPreferredSize(new Dimension(300,30));

        JLabel typesrtringLabel = new JLabel("Type : ");
        JLabel nomStringLabel = new JLabel("Nom : ");
        JLabel prenomStringLabel = new JLabel("Prenom : ");
        JLabel usernameStringLabel = new JLabel("Nom d'utilisateur : ");
        JLabel mdpStringLabel = new JLabel("Mot de passe : ");
        JLabel listClassesStringLabel = new JLabel("Choix de la classe : ");
        typesrtringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        nomStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        prenomStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        usernameStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        mdpStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        listClassesStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (int i=0;i<modele.getClasses().size();i++){
            l1.addElement(modele.getClasses().get(i).getNom_niveau());
        };
        listClasses = new JList<>(l1);
        listClasses.setBounds(100,100, 75,75);

        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(typesrtringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(type, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(nomStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(nom, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(prenomStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(prenom, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(usernameStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(userName, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(mdpStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        this.add(password, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.add(listClassesStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        this.add(listClasses, constraints);
        constraints.gridx=0;
        constraints.gridy=6;
        constraints.gridwidth=2;
        this.add(valider, constraints);

        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);
    }

    /**
     * Getteur du bouton de validation du formulaire
     * @return le bouton valider
     */
    public JButton getValider() {
        return valider;
    }
    /**
     * Getteur du JComboBox qui recupère le type
     * @return le JComboBox
     */
    public JComboBox getType() {
        return type;
    }
    /**
     * Getteur du Jtextfield qui recupère le nom
     * @return le JTextfield du nom
     */
    public JTextField getNom() {
        return nom;
    }
    /**
     * Getteur du Jtextfield qui recupère le prenom
     * @return le JTextfield du prenom
     */
    public JTextField getPrenom() {
        return prenom;
    }
    /**
     * Getteur du Jtextfield qui recupère le nom d'utilisateur
     * @return le JTextfield du nom d'utilisateur
     */
    public JTextField getUserName() {
        return userName;
    }
    /**
     * Getteur du Jtextfield qui recupère le mot de passe
     * @return le JTextfield du mot de passe
     */
    public JPasswordField getPassword() {
        return password;
    }
    /**
     * Getteur du JComboBox qui récupère la classe
     * @return le JcomBox qui définie la classe de l'élève
     */
    public JList<String> getListClasses() {
        return listClasses;
    }
}
