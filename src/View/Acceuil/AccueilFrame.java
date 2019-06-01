package View.Acceuil;

import javax.swing.*;
import java.awt.*;

public class AccueilFrame extends JFrame {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();


    //Constructor
    public AccueilFrame() {
        init();
        setVisible(true);
    }

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(getOwner());
        setTitle("Acceuil");
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

}
