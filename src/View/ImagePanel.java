package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ImagePanel extends JPanel {
    //Attributs
    private BufferedImage img;
    private String path;

    //Constructeur
    public ImagePanel(String path) {
        this.path = path;
        try {
            img = ImageIO.read(new File(getClass().getResource(path).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        JLabel wIcon = new JLabel(new ImageIcon(img));
        add(wIcon);
    }

    //Getters & Setters
    public BufferedImage getImg() {
        return img;
    }
    public void setImg(BufferedImage img) {
        this.img = img;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
