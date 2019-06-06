package View.Bulletin;

import Constants.Colors;
import Model.Bulletin;
import Model.DetailBulletin;
import Model.Personne;
import Model.Trimestre;

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

    ArrayList<DetailBulletin> detailBulletins = new ArrayList<>();
    ArrayList<Bulletin> bulletins = new ArrayList<>();
    Personne personne;


    public BulletinFrame(Personne personne) throws HeadlessException {
        initPersonnes(personne);
        init();
        setVisible(true);
    }

    private void initPersonnes(Personne personneSelect_) {
        personne=personneSelect_;
        detailBulletins.add(new DetailBulletin(1,17,"t'es un BV man"));
        detailBulletins.add(new DetailBulletin(1,11,"ca passe"));
        detailBulletins.add(new DetailBulletin(1,6,"excellent"));
        detailBulletins.add(new DetailBulletin(1,2,"plus nul que ma grand mere"));
        detailBulletins.add(new DetailBulletin(1,19,"t'es chaud comme léo"));
//    public Bulletin(int id_bulletin_, float moyenne_, Trimestre trimestre_, String appreciation_bulletin_, ArrayList<DetailBulletin> matieres_){
        bulletins.add(new Bulletin(1,13,new Trimestre(), "Super sympa !", detailBulletins));

        personne.setBulletins(bulletins);
        personne.setNom("Chaud");
        personne.setPrenom("Cacao");
    }

    public void init(){
        detailsBulletin.add(" Francais : 12/20 - Moyen");
        detailsBulletin.add(" Physique : 6/20 - Pitoyable...");
        detailsBulletin.add(" Flue traversière : 14/20 - ca passe");
        detailsBulletin.add(" Jaba : 19/20 - T'es chaud comme Léo");

        JTabbedPane jt = new JTabbedPane();

        jt.add("Trimestre 1", new formBulletin(personne));
        jt.add( "Trimestre 2", new formBulletin(personne));
        jt.add("Trimestre 3", new formBulletin(personne)) ;

        getContentPane().add(jt);


        // Frame init
        setBackground(Colors.green);
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Bulletin");
    }
}
