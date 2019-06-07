package View.HomeScreen;

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BoutonLeft extends JPanel {
    //attributs
    private JButton personne;
    private JButton enseignement;
    private JButton classe;
    private JButton devoir;

    public BoutonLeft() {
        personne = new JButton("Personne");
        enseignement = new JButton("Enseignement");
        classe = new JButton("Classe");
        devoir = new JButton("Devoir");


        // Layout
        GridLayout layout = new GridLayout(4, 1);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(10, 10,10,10));
        setBackground(Colors.white);

        devoir.setBackground(Colors.white);

        this.add(personne);
        this.add(devoir);
        this.add(classe);
        this.add(enseignement);
    }

    //Getters & Setters
    public JButton getPersonne() {
        return personne;
    }
    public void setPersonne(JButton personne) {
        this.personne = personne;
    }
    public JButton getEnseignement() {
        return enseignement;
    }
    public void setEnseignement(JButton enseignement) {
        this.enseignement = enseignement;
    }
    public JButton getClasse() {
        return classe;
    }
    public void setClasse(JButton classe) {
        this.classe = classe;
    }
    public JButton getDevoir() {
        return devoir;
    }
    public void setDevoir(JButton devoir) {
        this.devoir = devoir;
    }
}
