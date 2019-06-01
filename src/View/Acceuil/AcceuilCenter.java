package View.Acceuil;

import Constants.Colors;
import Controller.Connexion;
import View.HomeScreen.MainFrame;
import View.ImagePanel;
import View.Popup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AcceuilCenter extends JPanel {
    //Attributs
    JButton connexion;
    JTextField addrServer;
    JTextField nombdd;
    JTextField userName;
    JPasswordField password;

    public AcceuilCenter() {
        init();
    }

    public void init(){
        addrServer = new JTextField();
        nombdd = new JTextField();
        nombdd.setBounds(0,0,50,10);
        userName = new JTextField();
        password = new JPasswordField();
        connexion = new JButton("Connection");connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connexion test = new Connexion(nombdd.getText(), userName.getText(), password.getText());
                    System.out.println("Connexion réussi !");
                    Popup.infoBox("La connexion à la base de donnée à réussi !", "Connexion réussi !");
                } catch (SQLException u) {
                    Popup.infoBox("La connexion à la base de donnée à échoué !", "Connexion raté !");
                    u.printStackTrace();
                } catch (ClassNotFoundException u) {
                    Popup.infoBox("La connexion à la base de donnée à échoué !", "Connexion raté !");
                    u.printStackTrace();
                }
                MainFrame mainFrame = new MainFrame();
            }
        });

        addrServer.setPreferredSize(new Dimension(300,30));
        nombdd.setPreferredSize(new Dimension(300,30));
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
        this.add(nombdd, constraints);
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
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        this.add(connexion, constraints);

        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);
    }
}
