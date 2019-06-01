package View.HomeScreen;

import Model.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class AjoutPersonne extends JFrame {
    public static final Dimension windowDimension = new Dimension(600,800);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();
    ModelTable modele;

    public AjoutPersonne(ModelTable m) throws HeadlessException {
        modele = m;
        init();
        setVisible(true);
    }

    public void init(){
        // initialisation header
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.green);
        Formulaire form = new Formulaire(modele);

        form.getValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addPersonne(new Personne(Integer.parseInt(form.getId().getText()), (String) form.getType().getItemAt(form.getType().getSelectedIndex()), form.getPrenom().getText(),form.getUserName().getText(), form.getPassword().getText()));
                setVisible(false); //you can't see me!
                dispose();
            }
        });

        contentPane.add(form);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("Ajouter une personne");
    }
}