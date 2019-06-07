package View.HomeScreen.Ajout.Formulaires;

import Constants.Colors;
import View.HomeScreen.ModelsTable.ModelTableDevoir;
import View.HomeScreen.ModelsTable.ModelTablePersonne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <b>JPanel du JFrame ajoutPersonne</b>
 * @author Leonard
 * @version 1.0
 */
public class FormulaireDevoir extends JPanel {
    //Attributs
    JButton valider;
    JTextField id;
    JTextField note;
    JTextField appreciation;
    ModelTableDevoir modele;
    /**
     * Constructeur
     * @param m modele de la table pour ajout
     */
    public FormulaireDevoir(ModelTableDevoir m) {
        modele=m;
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        id = new JTextField();

        valider = new JButton("Ajouter");


        id.setPreferredSize(new Dimension(300,30));
        note.setPreferredSize(new Dimension(300,30));
        appreciation.setPreferredSize(new Dimension(300,30));


        JLabel idStringLabel = new JLabel("Id : ");
        JLabel noteStringLabel = new JLabel("Note : ");
        JLabel appreciationStringLabel = new JLabel("Appreciation : ");
        idStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        noteStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        appreciationStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));


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
        this.add(noteStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(note, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(appreciationStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(appreciation, constraints);
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

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getNote() {
        return note;
    }

    public void setNote(JTextField note) {
        this.note = note;
    }

    public JTextField getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(JTextField appreciation) {
        this.appreciation = appreciation;
    }
}
