package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Paths;

public class UserHeader extends JLabel{
    private ImagePanel img;
    private String imgPath;

    public UserHeader(String userName, String imagePath) {
        this.imgPath = imagePath;
        init(userName);
    }

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
