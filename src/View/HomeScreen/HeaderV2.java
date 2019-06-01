package View.HomeScreen;

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderV2 extends JPanel {
    //attributs
    private JButton refresh;
    private JButton recherche;
    private JButton stats;
    private UserHeader user;

    public HeaderV2() {
        init();
    }

    public void init(){
        refresh = new JButton("Actualiser");
        recherche = new JButton("Rechercher");
        stats = new JButton("Statistiques");
        user = new UserHeader("Léonard DEVINCRE", "/Assets/14-Leo.png");

        // Layout
        GridLayout layout = new GridLayout(1, 4);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);

        this.add(user);
        this.add(stats);
        this.add(recherche);
        this.add(refresh);
    }

    public JButton getRefresh() {
        return refresh;
    }
    public void setRefresh(JButton refresh) {
        this.refresh = refresh;
    }
    public JButton getRecherche() {
        return recherche;
    }
    public void setRecherche(JButton recherche) {
        this.recherche = recherche;
    }
    public JButton getStats() {
        return stats;
    }
    public void setStats(JButton stats) {
        this.stats = stats;
    }
    public UserHeader getUser() {
        return user;
    }
    public void setUser(UserHeader user) {
        this.user = user;
    }
}
