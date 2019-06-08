package View.Statistique;

import Constants.Colors;
import Model.Classe;
import Model.Personne;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatsFrame extends JFrame{


    public StatsFrame(ArrayList<Classe> mesClasses, ArrayList<Personne> personne) {
        ChoixStats stats = new ChoixStats(mesClasses,personne);

        getContentPane().add(stats,BorderLayout.CENTER);
        // Frame init
        setBackground(Colors.green);
        setSize(new Dimension(1000,1000));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Bulletin");
        setVisible(true);
    }
}
