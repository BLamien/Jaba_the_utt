package View.HomeScreen.Ajout;

import Model.*;
import View.HomeScreen.Ajout.Formulaires.FormulaireClasse;
import View.HomeScreen.ModelsTable.ModelTableClasse;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <b>Jframe de la fenetre de saisie de nouvelles classes</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutClasse extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTableClasse modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException exception
     */
    public AjoutClasse(ModelTableClasse m) throws HeadlessException {
        modele = m;
        init();
        setVisible(true);
    }

    /**
     * <b>methode d'initialisation des composants</b>
     */
    public void init(){
        // initialisation header
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.green);
        FormulaireClasse form = new FormulaireClasse(modele);

        //pour trouver les personnes qui ont été selectionné par l'utilisateur
        ArrayList<Personne> classePersonne = new ArrayList<>();
        form.getListPersonnes().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {//This line prevents double events
                    for (int j = 0; j < modele.getPersonnes().size(); j++) {
                        if (modele.getPersonnes().get(j).getNom() == form.getListPersonnes().getSelectedValue()) {
                            classePersonne.add(modele.getPersonnes().get(j));
                            System.out.println(form.getListPersonnes().getSelectedValue());
                        }
                    }
                }
            }
        });

        //pour trouver l'école qui a été selectioné par l'utilisateur
        ArrayList<Ecole> ecoleSelected = new ArrayList<>();
        form.getListEcoles().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {//This line prevents double events
                    for (int j = 0; j < modele.getEcoles().size(); j++) {
                        if (modele.getEcoles().get(j).getNom_ecole() == form.getListEcoles().getSelectedValue()) {
                            ecoleSelected.clear();
                            ecoleSelected.add(modele.getEcoles().get(j));
                        }
                    }
                }
            }
        });

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addClasse(new Classe(ecoleSelected.get(0), form.getNom_niveau().getText(), new AnneeScolaire(),classePersonne));
                setVisible(false); //you can't see me!
                dispose();
            }
        });

        contentPane.add(form);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Ajouter une classe");
    }
}
