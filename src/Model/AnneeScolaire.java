package Model;
/**
 * <b>classe de definiton d'une annee scolaire</b>
 * @author Victor
 * @version 1.0
 */
public class AnneeScolaire {
    //attribut
    private int id_anneeScolaire;
    private int debut_anneeScolaire;
    private int fin_anneeScolaire;

    //getter
    /**
     * <b>getter id annee scolaire</b>
     * @return id annee scolaire
     */
    public int getId_anneeScolaire() {return id_anneeScolaire;}
    /**
     * <b>getter debut annee scolaire</b>
     * @return debut annee scolaire
     */
    public int getDebut_anneeScolaire() {return debut_anneeScolaire;}
    /**
     * <b>getter fin annee scolaire</b>
     * @return fin annee scolaire
     */
    public int getFin_anneeScolaire() {return fin_anneeScolaire;}

    //setter
    /**
     * <b>setter id annee scolaire</b>
     * @param id_anneeScolaire valeur a attribuer a l'id annee scolaire
     */
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}
    /**
     * <b>setter debut annee scolaire</b>
     * @param debut_anneeScolaire valeur a attribuer a la date de debut annee scolaire
     */
    public void setDebut_anneeScolaire(int debut_anneeScolaire) {this.debut_anneeScolaire = debut_anneeScolaire;}
    /**
     * <b>setter id annee scolaire</b>
     * @param fin_anneeScolaire valeur a attribuer a la date de fin annee scolaire
     */
    public void setFin_anneeScolaire(int fin_anneeScolaire) {this.fin_anneeScolaire = fin_anneeScolaire;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public AnneeScolaire(){
        id_anneeScolaire=0;
        debut_anneeScolaire=0;
        fin_anneeScolaire=0;
    }
    /**
     * <b>constructeur surcharge</b>
     * @param id_anneeScolaire_ valeur a attribuer a l'id annee scolaire
     * @param debut_anneeScolaire_ valeur a attribuer a la date de debut annee scolaire
     * @param fin_anneeScolaire_ valeur a attribuer a la date de fin annee scolaire
     */
    public AnneeScolaire (int id_anneeScolaire_, int debut_anneeScolaire_, int fin_anneeScolaire_){
        id_anneeScolaire=id_anneeScolaire_;
        debut_anneeScolaire=debut_anneeScolaire_;
        fin_anneeScolaire=fin_anneeScolaire_;
    }
    /**
     * <b>constructeur surcharge sans l'id annee scolaire</b>
     * @param debut_anneeScolaire_ valeur a attribuer a la date de debut annee scolaire
     * @param fin_anneeScolaire_ valeur a attribuer a la date de fin annee scolaire
     */
    public AnneeScolaire (int debut_anneeScolaire_, int fin_anneeScolaire_){
        id_anneeScolaire=0;
        debut_anneeScolaire=debut_anneeScolaire_;
        fin_anneeScolaire=fin_anneeScolaire_;
    }

    //méthode
}
