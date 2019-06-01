package Model;
/**
 * <b>classe de definiton d'un d'une ecole</b>
 * @author Victor
 * @version 1.0
 */
public class Ecole {
    //attribut
    private int id_niveau;
    private String nom_niveau;

    //getter

    /**
     * <b>getter id niveau</b>
     * @return id niveau
     */
    public int getId_niveau() {return id_niveau;}

    /**
     * <b>getter nom niveau</b>
     * @return nom niveau
     */
    public String getNom_niveau() {return nom_niveau;}

    //setter

    /**
     * <b>setter id niveau</b>
     * @param id_niveau valeur a attribuer a l'id du niveau
     */
    public void setId_niveau(int id_niveau) {this.id_niveau = id_niveau;}

    /**
     * <b>setter nom niveau</b>
     * @param nom_niveau valeur a attribuer au no du niveau
     */
    public void setNom_niveau(String nom_niveau) {this.nom_niveau = nom_niveau;}

    //constructeur

    /**
     * <b>constructeur par defaut</b>
     */
    public Ecole(){
        id_niveau=0;
        nom_niveau="";
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_niveau_ valeur a attribuer a l'id du niveau
     * @param nom_niveau_ valeur a attribuer au nom du niveau
     */
    public Ecole(int id_niveau_, String nom_niveau_){
        id_niveau=id_niveau_;
        nom_niveau=nom_niveau_;
    }
    /**
     * <b>constructeur surcharge sans l'id du niveau</b>
     * @param nom_niveau_ valeur a attribuer au nom du niveau
     */
    public Ecole(String nom_niveau_){
        id_niveau=0;
        nom_niveau=nom_niveau_;
    }

    //méthode
}
