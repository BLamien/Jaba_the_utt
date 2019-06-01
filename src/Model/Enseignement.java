package Model;
/**
 * <b>classe de definiton d'un enseigenment</b>
 * @author Victor
 * @version 1.0
 */
public class Enseignement {
    //attribut
    private int id_enseignement;
    private int id_discipline;
    private int id_enseignant;
    private int id_classe;

    //getter
    /**
     *<b>getter id enseignement</b>
     * @return id enseignement
     */
    public int getId_enseignement() {return id_enseignement;}
    /**
     *<b>getter id discipline</b>
     * @return id discipline
     */
    public int getId_discipline() {return id_discipline;}
    /**
     *<b>getter id enseignant</b>
     * @return id enseignant
     */
    public int getId_enseignant() {return id_enseignant;}
    /**
     *<b>getter id classe</b>
     * @return id classe
     */
    public int getId_classe() {return id_classe;}

    //setter
    /**
     * <b>setter id enseignement</b>
     * @param id_enseignement valeur a attribuer a id enseignement
     */
    public void setId_enseignement(int id_enseignement) {this.id_enseignement = id_enseignement;}
    /**
     * <b>setter id discipline</b>
     * @param id_discipline valeur a attribuer a id discipline
     */
    public void setId_discipline(int id_discipline) {this.id_discipline = id_discipline;}
    /**
     * <b>setter id enseignant</b>
     * @param id_enseignant valeur a attribuer a id enseignant
     */
    public void setId_enseignant(int id_enseignant) {this.id_enseignant = id_enseignant;}
    /**
     * <b>setter id classe</b>
     * @param id_classe valeur a attribuer a id classe
     */
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public Enseignement(){
        id_enseignement=0;
        id_discipline=0;
        id_enseignant=0;
        id_classe=0;
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_enseignement_ valeur a attribuer a l'id enseignement
     * @param id_discipline_ valeur a attribuer a l'id discipline
     * @param id_enseignant_ valeur a attribuer a l'id enseignant
     * @param id_classe_ valeur a attribuer a l'id classe
     */
    public Enseignement(int id_enseignement_, int id_discipline_, int id_enseignant_, int id_classe_){
        id_enseignement=id_enseignement_;
        id_discipline=id_discipline_;
        id_enseignant=id_enseignant_;
        id_classe=id_classe_;
    }
    /**
     * <b>constructeur surcharge</b>
     * @param id_discipline_ valeur a attribuer a l'id discipline
     * @param id_enseignant_ valeur a attribuer a l'id enseignant
     * @param id_classe_ valeur a attribuer a l'id classe
     */
    public Enseignement(int id_discipline_, int id_enseignant_, int id_classe_){
        id_enseignement=0;
        id_discipline=id_discipline_;
        id_enseignant=id_enseignant_;
        id_classe=id_classe_;
    }

    //méthode
}
