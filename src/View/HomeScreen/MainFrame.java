package View.HomeScreen;

import Controller.HeaderViewController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    //Attributs
    private HeaderViewController header = new HeaderViewController(new Header());

    //Constructor
    public MainFrame() {
        init();
        setVisible(true);
    }

    private void init() {
        // Content Panel init
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);
        JPanel h = header.getHeader();
        h.setSize(widthSize,heightSize/3);

        contentPane.add(h, BorderLayout.NORTH);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("JABA");
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
