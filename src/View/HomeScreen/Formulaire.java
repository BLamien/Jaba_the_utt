package View.HomeScreen;

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
public class Formulaire extends JPanel {
    //Attributs
    JButton valider;
    JTextField id;
    JComboBox type;
    JTextField prenom;
    JTextField nom;
    JTextField userName;
    JPasswordField password;
    ModelTablePersonne modele;

    /**
     * Constructeur
     * @param m modele de la table pour ajout
     */
    public Formulaire(ModelTablePersonne m) {
        modele=m;
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        id = new JTextField();
        String sType[]={"Ensignants","Eleves"};
        type = new JComboBox(sType);
        nom = new JTextField();
        prenom = new JTextField();
        userName = new JTextField();
        password = new JPasswordField();
        valider = new JButton("Ajouter");


        id.setPreferredSize(new Dimension(300,30));
        type.setPreferredSize(new Dimension(300,30));
        nom.setPreferredSize(new Dimension(300,30));
        prenom.setPreferredSize(new Dimension(300,30));
        userName.setPreferredSize(new Dimension(300,30));
        password.setPreferredSize(new Dimension(300,30));

        JLabel idStringLabel = new JLabel("Id : ");
        JLabel typesrtringLabel = new JLabel("Type : ");
        JLabel nomStringLabel = new JLabel("Nom : ");
        JLabel prenomStringLabel = new JLabel("Prenom : ");
        JLabel usernameStringLabel = new JLabel("Nom d'utilisateur : ");
        JLabel mdpStringLabel = new JLabel("Mot de passe : ");
        idStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        typesrtringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        nomStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        prenomStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        usernameStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        mdpStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(idStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(id, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(typesrtringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(type, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(nomStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(nom, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(prenomStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(prenom, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(usernameStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        this.add(userName, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.add(mdpStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        this.add(password, constraints);
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
     * Getteur du Jtextfield qui recupère l'ID
     * @return le JTextfield de l'ID
     */
    public JTextField getId() {
        return id;
    }
    /**
     * Setteur du Jtextfield qui recupère l'ID
     */
    public void setId(JTextField id) {
        this.id = id;
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

}
