package Model;
/**
 * <b>classe de definiton d'un niveau</b>
 * @author Victor
 * @version 1.0
 */
public class Niveau {
    //attribut
    private int id_nibeau;
    private int nom_niveau;

    //getter
    /**
     * <b>getter id niveau</b>
     * @return id niveau
     */
    public int getId_nibeau() {return id_nibeau;}
    /**
     * <b>getter nom niveau</b>
     * @return nom niveau
     */
    public int getNom_niveau() {return nom_niveau;}

    //setter
    /**
     * <b>setter id niveau</b>
     * @param id_nibeau valeur a attribuer au niveau
     */
    public void setId_nibeau(int id_nibeau) {this.id_nibeau = id_nibeau;}
    /**
     * <b>setter nom niveau</b>
     * @param nom_niveau valeur a attribuer au nom du niveau
     */
    public void setNom_niveau(int nom_niveau) {this.nom_niveau = nom_niveau;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public Niveau(){
        id_nibeau=0;
        nom_niveau=0;
    }
    /**
     * <b>constructeur surcharge</b>
     * @param id_nibeau_ valeur a attribuer a l'id du niveau
     * @param nom_niveau_ valeur a attribuer au nom du niveau
     */
    public Niveau(int id_nibeau_, int nom_niveau_){
        id_nibeau=id_nibeau_;
        nom_niveau=nom_niveau_;
    }
    /**
     * <b>constructeur surcharge sans id niveau</b>
     * @param nom_niveau_ valeur a attribuer au nom du niveau
     */
    public Niveau(int nom_niveau_){
        id_nibeau=0;
        nom_niveau=nom_niveau_;
    }

    //méthodes
}
