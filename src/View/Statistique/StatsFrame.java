package View.Statistique;

import Constants.Colors;

import javax.swing.*;
import java.awt.*;

public class StatsFrame extends JFrame{
    private ChoixStats stats = new ChoixStats();


    public StatsFrame() {


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
