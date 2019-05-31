package View.Acceuil;

import Constants.Colors;
import View.ImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AcceuilCenter extends JPanel {
    //Attributs
    JTextField addrServer;
    JTextField nomServer;
    JTextField userName;
    JPasswordField password;

    public AcceuilCenter() {
        init();
    }

    public void init(){
        addrServer = new JTextField();
        nomServer = new JTextField();
        nomServer.setBounds(0,0,50,10);
        userName = new JTextField();
        password = new JPasswordField();
        addrServer.setPreferredSize(new Dimension(300,30));
        nomServer.setPreferredSize(new Dimension(300,30));
        userName.setPreferredSize(new Dimension(300,30));
        password.setPreferredSize(new Dimension(300,30));

        JLabel nomStringLabel = new JLabel("Nom base de données : ");
        JLabel addrtringLabel = new JLabel("Addresse du serveur : ");
        JLabel userNameStringLabel = new JLabel("Nom d'utilisateur : ");
        JLabel passwordStringLabel = new JLabel("Mot de passe : ");
        nomStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        addrtringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        userNameStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        passwordStringLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        View.ImagePanel img = new ImagePanel("/Assets/14-Leo.png");

        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 0.25;
        constraints.ipadx = 80;


        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(addrtringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(addrServer, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(nomStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(nomServer, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(userNameStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(userName, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(passwordStringLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(password, constraints);

        /*
        GridLayout layout = new GridLayout(1, 3);
        layout.setHgap(200);

         */
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);
    }
}
