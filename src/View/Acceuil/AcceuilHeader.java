package View.Acceuil;


import Constants.Colors;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class AcceuilHeader extends JPanel {
    //Attributs
    private JLabel titleLabel;

    //constructeur
    public AcceuilHeader() {
        init();
    }

    public void init(){
       titleLabel = new JLabel("Bienvenue dans ce programme");
       titleLabel.setFont(new Font("Verdana", Font.BOLD, 22));
       titleLabel.setForeground(Colors.white);
       titleLabel.setBorder(new CompoundBorder(new LineBorder(Colors.white), new EmptyBorder(30,30,30,30)));
       setBackground(Colors.green);
       setBorder(new EmptyBorder(30, 30,30,30));
       add(titleLabel);
    }
}
