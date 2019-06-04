package View.HomeScreen;
//TODO : JavaDoc
import Constants.Colors;
import View.ImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * <b>JLabel qui affiche les informations sur l'utilisateur dans le header</b>
 * @author Leonard
 * @version 1.0
 */
public class UserHeader extends JLabel{
    private ImagePanel img;
    private String imgPath;

    /**
     * Constructeur
     * @param userName String du nom d'utilisateur connecté
     * @param imagePath String du chemin de stockage de l'image de l'utilisateur
     */
    public UserHeader(String userName, String imagePath) {
        this.imgPath = imagePath;
        init(userName);
    }

    /**
     * Methode d'initialisation des composants de la classe
     * @param userName String du nom d'utilisateur
     */
    private void init(String userName) {
        JLabel Uname = new JLabel(userName);
        Uname.setHorizontalAlignment(SwingConstants.CENTER);

        img = new ImagePanel(imgPath);
        Uname.setIcon(new ImageIcon(img.getImg()));
        Uname.setBorder(new EmptyBorder(5,0,5,0));
        setLayout(new BorderLayout());
        add(Uname, BorderLayout.CENTER);
    }
}
