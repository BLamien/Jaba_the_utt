package Model;
/**
 * <b>classe de definiton d'un d'une ecole</b>
 * @author Victor
 * @version 1.0
 */
public class Ecole {
    //attribut
    private int id_ecole;
    private String nom_ecole;
    private int anneefondation;

    /**
     * <b>Constructeur surcharge</b>
     * @param id_ecole veleur prise par l'id_ecole
     * @param nom_ecole valeur prise par le nom_ecole
     * @param anneefondation valeur prise par l'anneefondation
     */
    public Ecole(int id_ecole, String nom_ecole, int anneefondation) {
        this.id_ecole = id_ecole;
        this.nom_ecole = nom_ecole;
        this.anneefondation = anneefondation;
    }

    /**
     * <b>constructeur par defaut</b>
     */
    public Ecole() {
        id_ecole=0;
        nom_ecole="";
        anneefondation=0;
    }

    /**
     * <b>getter id_ecole</b>
     * @return id_ecole
     */
    public int getId_ecole() {
        return id_ecole;
    }

    /**
     * setter id_ecole
     * @param id_ecole nouvelle valeur id_ecole
     */
    public void setId_ecole(int id_ecole) {
        this.id_ecole = id_ecole;
    }

    /**
     * <b> getter nom_ecole</b>
     * @return nom_ecole
     */
    public String getNom_ecole() {
        return nom_ecole;
    }

    /**
     * <b>stter nom_ecole</b>
     * @param nom_ecole nouvelle valeur nom_ecole
     */
    public void setNom_ecole(String nom_ecole) {
        this.nom_ecole = nom_ecole;
    }

    /**
     * <b>getter anneefondation</b>
     * @return anneefondation
     */
    public int getAnneefondation() {
        return anneefondation;
    }

    /**
     * <b>setter anneefondation</b>
     * @param anneefondation nouvelle valeur anneefondation
     */
    public void setAnneefondation(int anneefondation) {
        this.anneefondation = anneefondation;
    }
    //Methodes
}
