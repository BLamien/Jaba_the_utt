package View;
//TODO : JavaDoc
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
/**
 * <b>JPanel qui gere l'affichage des photos</b>
 * @author Leonard
 * @version 1.0
 */
public class ImagePanel extends JPanel {
    //Attributs
    private BufferedImage img;
    private String path;

    /**
     * Constructeur
     * @param path String du chemin de stockage de l'image
     */
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

    /**
     * Gettteur de l'image
     * @return BufferedImage
     */
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
