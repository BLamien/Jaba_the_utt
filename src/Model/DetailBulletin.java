package Model;

import java.util.ArrayList;

/**
 * <b>classe de definiton du detail du bulletin</b>
 * @author Victor & Thomas
 * @version 2.0
 */
public class DetailBulletin {
    //attributs
    private int id_detailBulletin;
    private float moyenne_matiere;
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
     * <b>getter moyenne_matiere</b>
     * @return moyenne_matiere
     */
    public float getMoyenne_matiere() {
        return moyenne_matiere;
    }
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
     * <b>seter moyenne_matiere</b>
     * @param moyenne_matiere valeur attribuer a moyenne_matiere
     */
    public void setMoyenne_matiere(float moyenne_matiere) {
        this.moyenne_matiere = moyenne_matiere;
    }
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
     * @param  notes arraylist a attribuer a notes
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
        moyenne_matiere=0;
        matiere=new Enseignement();
        appreciation_detailBulletin="";
        notes=new ArrayList<>();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_detailBulletin_ valeur a attribuer au detail du bulletin
     * @param moyenne_matiere_ valeur a attribuer a moyenne_matiere
     * @param matiere_ Objet a attribuer a matiere
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     * @param notes_ arraylist a attribuer a notes
     */
    public DetailBulletin(int id_detailBulletin_, float moyenne_matiere_, Enseignement matiere_, String appreciation_detailBulletin_, ArrayList<Devoir> notes_){
        id_detailBulletin=id_detailBulletin_;
        moyenne_matiere=moyenne_matiere_;
        matiere=matiere_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
        notes=notes_;
    }
    /**
     * <b>constructeur surcharge sans les objets ni arraylist</b>
     * @param id_detailBulletin_ valeur a attribuer a l'id bulletin
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     */
    public DetailBulletin(int id_detailBulletin_, float moyenne_matiere_, String appreciation_detailBulletin_){
        id_detailBulletin=id_detailBulletin_;
        moyenne_matiere=moyenne_matiere_;
        matiere=new Enseignement();
        appreciation_detailBulletin=appreciation_detailBulletin_;
        notes=new ArrayList<>();
    }

    //méthode
}
