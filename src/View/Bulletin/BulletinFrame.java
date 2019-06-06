package View.Bulletin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BulletinFrame extends JFrame {
    public static final Dimension windowDimension = new Dimension(800,1000);
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    //Variables à gérer dynamiquement
    String nomPersonne = "le petit Victor";
    String prenomPersonne = "monocheck";
    String dateDebutBulletin = "12/09/2019";
    String dateFinBulletin = "23/12/2019";

    //Il s'agirat d'une Arraylist de <DetailBulletin>
    //Contient : moyenne trimestrielle pour cet enseignement (calculée) et appréciation
    ArrayList<String> detailsBulletin = new ArrayList<>();

    public BulletinFrame() throws HeadlessException {
        init();
        setVisible(true);
    }

    public void init(){
        detailsBulletin.add(" Francais : 12/20 - Moyen");
        detailsBulletin.add(" Physique : 6/20 - Pitoyable...");
        detailsBulletin.add(" Flue traversière : 14/20 - ca passe");
        detailsBulletin.add(" Jaba : 19/20 - T'es chaud comme Léo");

        JTabbedPane jt = new JTabbedPane();

        jt.add("Trimestre 1", new formBulletin());
        jt.add( "Trimestre 2", new formBulletin());
        jt.add("Trimestre 3", new formBulletin()) ;

        getContentPane().add(jt);


        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Bulletin");
    }
}
