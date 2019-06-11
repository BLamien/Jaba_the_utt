package View.HomeScreen.Ajout;

import DAO.DevoirDAO;
import Model.Devoir;
import View.HomeScreen.Ajout.Formulaires.FormulaireDevoir;
import View.HomeScreen.MainFrame;
import View.HomeScreen.ModelsTable.ModelTableDevoir;
import View.Popup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Jframe de la fenetre de saisie de nouveaux devoirs</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutDevoir extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTableDevoir modele;
    MainFrame mainFrame;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @param main valeur attribuer a mainFrame
     * @throws HeadlessException exception
     */
    public AjoutDevoir(ModelTableDevoir m, MainFrame main) throws HeadlessException {
        modele = m;
        mainFrame=main;
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
                String result = Popup.ask("Quel est l'ID du detail bulletin où vous voulez ajouter ? ", "Choix ID");
                new DevoirDAO().ajoutDevoir(new Devoir(Integer.parseInt(form.getNote().getText()), form.getAppreciation().getText()), Integer.parseInt(result));
                mainFrame.resetTables();
                mainFrame.initTables();
                mainFrame.getContentPane().revalidate();
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
