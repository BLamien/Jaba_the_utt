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

    ArrayList<String> detailsBulletin = new ArrayList<>();

    ArrayList<Bulletin> bulletins = new ArrayList<>();
    Personne personne;


    public BulletinFrame(Personne personne_) throws HeadlessException {
        //initPersonnes(personne);
        personne=personne_;
        init();
        setVisible(true);
    }

    private void initPersonnes(Personne personneSelect_) {
        personne=personneSelect_;
        ArrayList<DetailBulletin> detailBulletins1 = new ArrayList<>();

        detailBulletins1.add(new DetailBulletin(1,17,"t'es un BV man"));
        detailBulletins1.add(new DetailBulletin(1,11,"ca passe"));
        detailBulletins1.add(new DetailBulletin(1,6,"excellent"));
        detailBulletins1.add(new DetailBulletin(1,2,"plus nul que ma grand mere"));
        detailBulletins1.add(new DetailBulletin(1,19,"t'es chaud comme léo"));
        bulletins.add(new Bulletin(1,13,new Trimestre(), "Super sympa !", detailBulletins1));
        ArrayList<DetailBulletin> detailBulletins = new ArrayList<>();

        detailBulletins.add(new DetailBulletin(1,18,"Bien ouej"));
        detailBulletins.add(new DetailBulletin(1,17,"Le petit thomas est un bon élève"));
        detailBulletins.add(new DetailBulletin(1,2,"tu peux pas etre bon partour mggle"));
        detailBulletins.add(new DetailBulletin(1,20,"je crois que j'ai mis un 2 devant le 0..."));
        detailBulletins.add(new DetailBulletin(1,19,"Possède une marge de progression significative"));

        bulletins.add(new Bulletin(1,16,new Trimestre(), "Incroyable bulletin", detailBulletins));


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

        for(int i=0;i<personne.getBulletins().size();i++){
            jt.add("Bulletin "+i, new formBulletin(personne, i));
        }

        getContentPane().add(jt);


        // Frame init
        setBackground(Colors.green);
        setSize(new Dimension(1000,1000));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Bulletin");
    }
}
