package View.HomeScreen.Ajout;

import DAO.EleveDAO;
import Model.Personne;
import View.HomeScreen.Ajout.Formulaires.FormulairePersonne;
import View.HomeScreen.ModelsTable.ModelTablePersonne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Jframe de la fenetre de saisie de nouvelles personnes</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutPersonne extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTablePersonne modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException
     */
    public AjoutPersonne(ModelTablePersonne m) throws HeadlessException {
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
        FormulairePersonne form = new FormulairePersonne(modele);

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addPersonne(new Personne((String) form.getType().getItemAt(form.getType().getSelectedIndex()), form.getNom().getText(), form.getPrenom().getText(),form.getUserName().getText(), form.getPassword().getText()));
                new EleveDAO().ajoutEleve(new Personne((String) form.getType().getItemAt(form.getType().getSelectedIndex()), form.getNom().getText(), form.getPrenom().getText(),form.getUserName().getText(), form.getPassword().getText()),form.getListClasses().getSelectedValue());
                setVisible(false); //you can't see me!
                dispose();
            }
        });

        contentPane.add(form);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Ajouter une personne");
    }
}
