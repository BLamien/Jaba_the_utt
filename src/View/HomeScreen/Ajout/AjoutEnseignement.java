package View.HomeScreen.Ajout;

import Model.*;
import View.HomeScreen.Ajout.Formulaires.FormulaireClasse;
import View.HomeScreen.Ajout.Formulaires.FormulaireEnseignement;
import View.HomeScreen.ModelsTable.ModelTableClasse;
import View.HomeScreen.ModelsTable.ModelTableEnseignement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * <b>Jframe de la fenetre de saisie de nouvelles classes</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutEnseignement extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTableEnseignement modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException
     */
    public AjoutEnseignement(ModelTableEnseignement m) throws HeadlessException {
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
        FormulaireEnseignement form = new FormulaireEnseignement(modele);

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addEnseignement(new Enseignement(new Discipline(), new Personne(), new Classe()));
                setVisible(false); //you can't see me!
                dispose();
            }
        });

        contentPane.add(form);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Ajouter un enseignement");
    }
}
