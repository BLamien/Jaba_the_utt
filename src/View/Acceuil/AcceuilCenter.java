package View.Acceuil;
//TODO : JavaDoc
import Constants.Colors;
import Controller.Connexion;
import DAO.EleveDAO;
import DAO.EnseignantDAO;
import Model.Personne;
import View.HomeScreen.MainFrame;
import View.HomeScreen.ModelsTable.ModelTablePersonne;
import View.ImagePanel;
import View.Popup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <b>Jpanel de la partie central de la fenetre d'acceuil</b>
 * @author Leonard
 * @version 1.0
 */
public class AcceuilCenter extends JPanel {
    //Attributs
    JButton connexion;
    JTextField addrServer;
    JTextField nombdd;
    JTextField userName;
    JPasswordField password;
    ArrayList<Personne> profs = new ArrayList<>();
    Boolean succed=false;


    /**
     * <b>Constructeur par defaut</b>
     */
    public AcceuilCenter() {
        initComponent();
        init();
    }

    private void initComponent(){
        com.sdz.dao.DAO<Personne> profsDao = new EnseignantDAO();
        for(int i = 1; i <= ((EnseignantDAO) profsDao).taille; i++){
            try {
                profs.add(profsDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    public void init(){
        addrServer = new JTextField();
        nombdd = new JTextField();
        nombdd.setBounds(0,0,50,10);
        userName = new JTextField();
        password = new JPasswordField();
        connexion = new JButton("Connection");connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<profs.size();i++){
                    System.out.println(profs.get(i).getLogin());
                    System.out.println(userName.getText());
                    System.out.println(profs.get(i).getMdp());
                    System.out.println(password.getText());
                    if((profs.get(i).getLogin().equals(userName.getText()))&&(profs.get(i).getMdp().equals(password.getText()))){
                        succed=true;
                    }
                }
                if (succed){
                    System.out.println("Connexion réussi !");
                    Popup.infoBox("La connexion à la base de donnée à réussi !", "Connexion réussi !");
                    MainFrame mainFrame = new MainFrame();
                }else {
                    Popup.infoBox("La connexion à la base de donnée à échoué ! Vous n'avez pas pu être identifié.", "Connexion echoué !");
                    succed=false;
                }

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
