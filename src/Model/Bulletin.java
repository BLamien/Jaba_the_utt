package Model;

import java.util.ArrayList;

/**
 * <b>classe de definiton d'un bulletin</b>
 * @author Victor
 * @version 1.0
 */
public class Bulletin {
    //attribut
    private int id_bulletin;
    private float moyenne;
    private Trimestre trimestre;
    private String appreciation_bulletin;
    private Personne eleve;
    ArrayList<DetailBulletin> matieres;

    //getter
    /**
     * <b>getter id bulletin</b>
     * @return id bulletin
     */
    public int getId_bulletin() {return id_bulletin;}

    /**
     * <b>getter moyenne</b>
     * @return moyenne
     */
    public float getMoyenne() {
        return moyenne;
    }
    /**
     * <b>getter id trimestre</b>
     * @return id trimestre
     */
    public Trimestre get_trimestre() {return trimestre;}
    /**
     * <b>getter appreciation</b>
     * @return appreciation
     */
    public String getAppreciation_bulletin() {
        return appreciation_bulletin;
    }
    /**
     * <b>getter eleve</b>
     * @return eleve
     */
    public Personne get_eleve() {return eleve; }

    /**
     * <b>getter des matieres</b>
     * @return matieres
     */
    public ArrayList<DetailBulletin> getMatieres() {
        return matieres;
    }
    //setter
    /**
     * <b>setter id bulletin</b>
     * @param id_bulletin valeur a ttribuer a l'id bulletin
     */
    public void setId_bulletin(int id_bulletin) {this.id_bulletin = id_bulletin; }
    /**
     * <b>setter moyenne</b>
     * @param moyenne valeur attribuer a moyenne
     */
    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }
    /**
     * <b>setter trimestre</b>
     * @param trimestre Objet attribuer au trimestre
     */
    public void set_trimestre(Trimestre trimestre) {this.trimestre = trimestre;}
    /**
     * <b>setter appreciation</b>
     * @param appreciation_bulletin valeur attribuer a l'appreciation
     */
    public void setAppreciation_bulletin(String appreciation_bulletin) {this.appreciation_bulletin = appreciation_bulletin;}
    /**
     * <b>setter eleve</b>
     * @param eleve Objet attribuer a eleve
     */
    public void set_eleve(Personne eleve) {this.eleve = eleve;}

    /**
     * <b>setter de matières</b>
     * @param matieres nouvelle arraylist a attribuer a matieres
     */
    public void setMatieres(ArrayList<DetailBulletin> matieres) {
        this.matieres = matieres;
    }

    //constructeur

    /**
     * <b>constructeur par defaut</b>
     */
    public Bulletin(){
        id_bulletin=0;
        moyenne=0;
        trimestre=new Trimestre();
        appreciation_bulletin="";
        eleve=new Personne();
        matieres= new ArrayList<>();
    }

    /**
     * <b>constructeur surcharge sans objets ni arraylist</b>
     * @param id_bulletin_ valeur a attribuer a l'id bulletin
     * @param moyenne_ valeur a attribuer a moyenne
     * @param appreciation_bulletin_ valeur a attribuer a l'appreciation du bulletin
     */
    public Bulletin(int id_bulletin_, float moyenne_, String appreciation_bulletin_){
        id_bulletin=id_bulletin_;
        moyenne=moyenne_;
        trimestre=new Trimestre();
        appreciation_bulletin=appreciation_bulletin_;
        eleve=new Personne();
        matieres=new ArrayList<>();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_bulletin_ valeur a attribuer a l'id bulletin
     * @param moyenne_ valeur a attribuer a moyenne
     * @param trimestre_ Objet a attribuer a trimestre
     * @param eleve_ Objet a attribuer a eleve
     * @param appreciation_bulletin_ valeur a attribuer a l'appreciation du bulletin
     * @param matieres_ arraylist a attribuer a matieres
     */
    public Bulletin(int id_bulletin_, float moyenne_, Trimestre trimestre_, Personne eleve_, String appreciation_bulletin_, ArrayList<DetailBulletin> matieres_){
        id_bulletin=id_bulletin_;
        moyenne=moyenne_
        trimestre=trimestre_;
        appreciation_bulletin=appreciation_bulletin_;
        eleve=eleve_;
        matieres=matieres_;
    }
    //methode
}



