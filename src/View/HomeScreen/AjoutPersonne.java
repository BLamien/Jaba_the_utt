package View.HomeScreen;

import Model.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 * <b>Jframe de la fenetre de saisie de nouvelles personnes</b>
 * @author Leonard
 * @version 1.0
 */
public class AjoutPersonne extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTable modele;


    /**
     * <b>Constructeur</b>
     * @param m modele de la table pour l'ajouter
     * @throws HeadlessException
     */
    public AjoutPersonne(ModelTable m) throws HeadlessException {
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
        Formulaire form = new Formulaire(modele);

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addPersonne(new Personne(Integer.parseInt(form.getId().getText()), (String) form.getType().getItemAt(form.getType().getSelectedIndex()), form.getNom().getText(), form.getPrenom().getText(),form.getUserName().getText(), form.getPassword().getText()));
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
