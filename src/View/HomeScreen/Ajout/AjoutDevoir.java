package View.HomeScreen.Ajout;

import Model.Devoir;
import View.HomeScreen.Ajout.Formulaires.FormulaireDevoir;
import View.HomeScreen.Ajout.Formulaires.FormulairePersonne;
import View.HomeScreen.ModelsTable.ModelTableDevoir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Jframe de la fenetre de saisie de nouvelles personnes</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutDevoir extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTableDevoir modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException
     */
    public AjoutDevoir(ModelTableDevoir m) throws HeadlessException {
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
        FormulaireDevoir form = new FormulaireDevoir(modele);

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addDevoir(new Devoir(Integer.parseInt(form.getId().getText()), Integer.parseInt(form.getNote().getText()), form.getAppreciation().getText()));
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
