package View;

import Controller.TabHeaderViewController;

import javax.swing.*;

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

        userName = new UserHeader("Léonard DEVINCRE", "/Applications/MAMP/htdocs/Jaba_the_utt/src/Assets/14-Leo.png");


    }
}
