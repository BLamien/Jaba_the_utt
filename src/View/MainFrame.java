package View;

import Controller.Connexion;
import Controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    private Connexion databaseConnection = null;

    //Attributs
    private HeaderViewController header = new HeaderViewController();

    //Constructor
    public MainFrame() {
        init();
    }

    private void init() {
        // Content Panel init
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);

        contentPane.add(header.getHeader(), BorderLayout.NORTH);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("EduManager");
    }

    //Getters & Setters
    public static Dimension getWindowDimension() {
        return windowDimension;
    }
    public static int getWidthSize() {
        return widthSize;
    }
    public static int getHeightSize() {
        return heightSize;
    }
    public HeaderViewController getHeader() {
        return header;
    }
    public void setHeader(HeaderViewController header) {
        this.header = header;
    }
}
