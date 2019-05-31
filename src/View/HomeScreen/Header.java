package View.HomeScreen;

import Constants.Colors;
import Controller.TabHeaderViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Header extends JPanel {
    //Attributs
    private TabHeaderViewController header1;
    private TabHeaderViewController header2;
    private JLabel userName;

    //constructeur
    public Header() {
        init();
    }

    public void init(){
        header1 = new TabHeaderViewController(new TabHeader("Mise à jour"));
        header2 = new TabHeaderViewController(new TabHeader("Refresh"));

        userName = new UserHeader("Léonard DEVINCRE", "/Assets/14-Leo.png");

        // Layout
        GridLayout layout = new GridLayout(1, 1);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);

        this.add(userName);
        this.add(header1.getTabHeader());
        this.add(header2.getTabHeader());
    }

    //Getters & Setters
    public TabHeaderViewController getHeader1() {
        return header1;
    }
    public void setHeader1(TabHeaderViewController header1) {
        this.header1 = header1;
    }
    public TabHeaderViewController getHeader2() {
        return header2;
    }
    public void setHeader2(TabHeaderViewController header2) {
        this.header2 = header2;
    }
}
