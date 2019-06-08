package View.HomeScreen.Ajout;

import Model.*;
import View.HomeScreen.Ajout.Formulaires.FormulaireClasse;
import View.HomeScreen.Ajout.Formulaires.FormulaireDevoir;
import View.HomeScreen.ModelsTable.ModelTableClasse;
import View.HomeScreen.ModelsTable.ModelTableDevoir;

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
public class AjoutClasse extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTableClasse modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException
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

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addClasse(new Classe(new Ecole(), form.getNom_niveau().getText(), new AnneeScolaire(), new ArrayList<Personne>()));
                setVisible(false); //you can't see me!
                dispose();
            }
        });

        contentPane.add(form);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Ajouter un devoir");
    }
}
