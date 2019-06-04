package View.HomeScreen;

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * <b>JPanel du header de la fenetre principal</b>
 * @author Leonard
 * @version 1.0
 */
public class HeaderV2 extends JPanel {
    //attributs
    private JButton menu;
    private JButton recherche;
    private JButton stats;
    private UserHeader user;

    /**
     * <b>Constructeur par defaut</b>
     */
    public HeaderV2() {
        init();
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        menu = new JButton("Menu");
        recherche = new JButton("Rechercher");
        stats = new JButton("Statistiques");
        user = new UserHeader("Léonard DEVINCRE", "/Assets/14-Leo.png");


        // Layout
        GridLayout layout = new GridLayout(1, 4);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.darkGreen);

        user.setBackground(Colors.white);

        this.add(user);
        this.add(stats);
        this.add(recherche);
        this.add(menu);
    }

    /**
     * <b>Getteur qui retourne le bouton qui permet de revenir au menu</b>
     * @return le bouton "Menu"
     */
    public JButton getMenu() {
        return menu;
    }

    /**
     * <b>Getteur qui retourne le bouton de recherche</b>
     * @return le bouton de recherche
     */
    public JButton getRecherche() {
        return recherche;
    }

    /**
     * <b>Getteur qui recupere le bouton qui permet d'acceder aux statistiques</b>
     * @return le bouton "Statistiques"
     */
    public JButton getStats() {
        return stats;
    }
}
