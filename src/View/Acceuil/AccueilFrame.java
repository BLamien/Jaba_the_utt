package View.Acceuil;
//TODO : JavaDoc

import javax.swing.*;
import java.awt.*;

/**
 * <b>Jframe principal de la fenetre d'acceuil de l'application</b>
 * @author Leonard
 * @version 1.0
 */
public class AccueilFrame extends JFrame {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();


    /**
     * <b>Constructeur par defaut</b>
     */
    public AccueilFrame() {
        init();
        setVisible(true);
    }

    /**
     * <b>Methode d'initialisation des parametres</b>
     */
    private void init() {
        // Content Panel init
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);
        AcceuilHeader header = new AcceuilHeader();
        AcceuilCenter center = new AcceuilCenter();

        contentPane.add(center, BorderLayout.CENTER);
        contentPane.add(header, BorderLayout.NORTH);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(getOwner());
        setTitle("Acceuil");
    }

    /**
     * <b>getteur de la taille de la fenetre</b>
     * @return dimension de la fenetre
     */
    public static Dimension getWindowDimension() {
        return windowDimension;
    }

    /**
     * <b>getteur de la longueur de la fenetre</b>
     * @return longueur de la fenetre
     */
    public static int getWidthSize() {
        return widthSize;
    }

    /**
     * <b>getteur de la largeur de la fenetre</b>
     * @return largeur de la fenetre
     */
    public static int getHeightSize() {
        return heightSize;
    }

}
