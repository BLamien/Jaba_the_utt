package Model;

import java.util.ArrayList;

/**
 * <b>classe de definiton du detail du bulletin</b>
 * @author Victor
 * @version 1.0
 */
public class DetailBulletin {
    //attributs
    private int id_detailBulletin;
    private Enseignement matiere;
    private String appreciation_detailBulletin;
    private ArrayList<Devoir> notes;

    //getter

    /**
     * <b>getter id detail bulletin</b>
     * @return id detail bulletin
     */
    public int getId_detailBulletin() {return id_detailBulletin;}
    /**
     * <b>getter matiere</b>
     * @return matiere
     */
    public Enseignement get_matiere() {return matiere;}
    /**
     * <b>getter appreciation</b>
     * @return appreciation
     */
    public String getAppreciation_detailBulletin() {return appreciation_detailBulletin;}

    /**
     * <b>getter notes</b>
     * @return notes
     */
    public ArrayList<Devoir> getNotes() {
        return notes;
    }

    //setter
    /**
     * <b>setter id detail bulletin</b>
     * @param id_detailBulletin valeur a attribuer au detail du bulletin
     */
    public void setId_detailBulletin(int id_detailBulletin) {this.id_detailBulletin = id_detailBulletin;}
    /**
     * <b>setter matiere</b>
     * @param matiere Objet a attribuer a matiere
     */
    public void set_matiere(Enseignement matiere) {this.matiere = matiere;}
    /**
     * <b>setter apprecaiton</b>
     * @param appreciation_detailBulletin valeur a attribuer a l'appreciation
     */
    public void setAppreciation_detailBulletin(String appreciation_detailBulletin) {this.appreciation_detailBulletin = appreciation_detailBulletin;}

    /**
     * <b>setter notes</b>
     * @param  nouvelle arraylist a attribuer a notes
     */
    public void setNotes(ArrayList<Devoir> notes) {
        this.notes = notes;
    }

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public DetailBulletin(){
        id_detailBulletin=0;
        matiere=new Enseignement();
        appreciation_detailBulletin="";
        notes=new ArrayList<>();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_detailBulletin_ valeur a attribuer au detail du bulletin
     * @param matiere_ Objet a attribuer a matiere
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     * @param notes_ arraylist a attribuer a notes
     */
    public DetailBulletin(int id_detailBulletin_, Enseignement matiere_, String appreciation_detailBulletin_, ArrayList<Devoir> notes_){
        id_detailBulletin=id_detailBulletin_;
        matiere=matiere_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
        notes=notes_;
    }
    /**
     * <b>constructeur surcharge sans les objets ni arraylist</b>
     * @param id_detailBulletin_ valeur a attribuer a l'id bulletin
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     */
    public DetailBulletin(int id_detailBulletin_, String appreciation_detailBulletin_){
        id_detailBulletin=id_detailBulletin_;
        matiere=new Enseignement();
        appreciation_detailBulletin=appreciation_detailBulletin_;
        notes=new ArrayList<>();
    }

    //méthode
}
