package Model;
/**
 * <b>classe de definiton d'une discipline</b>
 * @author Victor
 * @version 2.0
 */
public class Discipline {
    //attribut
    private int id_discipline;
    private String nom_discipline;

    //getter

    /**
     * <b>getter ID_Discipline</b>
     * @return ID_Discipline
     */
    public int getId_discipline() {return id_discipline;}

    /**
     * <b>getter nom_discipline</b>
     * @return nom_discipline
     */
    public String getNom_discipline() {return nom_discipline;}

    //setter

    /**
     * <b>setter ID_Discipline</b>
     * @param id_discipline nouvelle valeur de l'ID_Discipline
     */
    public void setId_discipline(int id_discipline) {this.id_discipline = id_discipline;}

    /**
     * <b>setter nom_discipline</b>
     * @param nom_discipline nouvelle valeur du nom_discipline
     */
    public void setNom_discipline(String nom_discipline) {this.nom_discipline = nom_discipline;}

    //constructeur

    /**
     * <b>Constructeur par defaut</b>
     */
    public Discipline(){
        id_discipline=0;
        nom_discipline="";
    }

    /**
     * <b>Constructeur surcharge</b>
     * @param id_discipline_ valeur prise par id_discipline
     * @param nom_discipline_ valeur prise par nom_discipline
     */
    public Discipline(int id_discipline_, String nom_discipline_){
        id_discipline=id_discipline_;
        nom_discipline=nom_discipline_;
    }

    //méthodes

}
