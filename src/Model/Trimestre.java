package Model;

import java.util.Date;

/**
 * <b>classe de definiton d'un trimestre</b>
 * @author Victor
 * @version 1.0
 */
public class Trimestre {
    //attribut
    private int id_trimestre;
    private int numero;
    private Date debut_trimestre;
    private Date fin_trimestre;
    private int id_anneeScolaire;

    //getter

    /**
     * <b>getter id trimestre</b>
     * @return id trimestre
     */
    public int getId_trimestre() {return id_trimestre;}
    /**
     * <b>getter numero</b>
     * @return numero
     */
    public int getNumero() {return numero;}
    /**
     * <b>getter debut trimestre</b>
     * @return debut trimestre
     */
    public Date getDebut_trimestre() {return debut_trimestre;}
    /**
     * <b>getter fin trimestre</b>
     * @return fin trimestre
     */
    public Date getFin_trimestre() {return fin_trimestre;}
    /**
     * <b>getter id annee scolaire</b>
     * @return id annee scolaire
     */
    public int getId_anneeScolaire() {return id_anneeScolaire;}

    //setter
    /**
     * <b>setter id trimestre</b>
     * @param id_trimestre valeur a attribuer a id trimetre
     */
    public void setId_trimestre(int id_trimestre) {this.id_trimestre = id_trimestre;}
    /**
     * <b>setter numero</b>
     * @param numero valeur a attribuer a numero
     */
    public void setNumero(int numero) {this.numero = numero;}
    /**
     * <b>setter debut trimestre</b>
     * @param debut_trimestre valeur a attribuer a debut trimetre
     */
    public void setDebut_trimestre(Date debut_trimestre) {this.debut_trimestre = debut_trimestre;}
    /**
     * <b>setter fin trimestre</b>
     * @param fin_trimestre valeur a attribuer a fin trimetre
     */
    public void setFin_trimestre(Date fin_trimestre) {this.fin_trimestre = fin_trimestre;}
    /**
     * <b>setter id annee scolaire</b>
     * @param id_anneeScolaire valeur a attribuer a id annee scolaire
     */
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}

    //constructeur

    /**
     * <b>constructeur par defaut</b>
     */
    public Trimestre(){
        id_trimestre=0;
        numero=0;
        debut_trimestre=0;
        fin_trimestre=0;
        id_anneeScolaire=0;
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_trimestre_ valeur a attribuer a id trimestre
     * @param numero_ valeur a attribuer a numero
     * @param debut_trimestre_ valeur a attribuer a debut trimestre
     * @param fin_trimestre_ valeur a attribuer a fin trimestre
     * @param id_anneeScolaire_ valeur a attribuer a id annee scolaire
     */
    public Trimestre(int id_trimestre_, int numero_, Date debut_trimestre_, Date fin_trimestre_, int id_anneeScolaire_){
        id_trimestre=id_trimestre_;
        numero=numero_;
        debut_trimestre=debut_trimestre_;
        fin_trimestre=fin_trimestre_;
        id_anneeScolaire=id_anneeScolaire_;
    }

    /**
     * <b>constructeur surcharge sans id_trimestre</b>
     * @param numero_ valeur a attribuer a numero
     * @param debut_trimestre_ valeur a attribuer a debut trimestre
     * @param fin_trimestre_ valeur a attribuer a fin trimestre
     * @param id_anneeScolaire_ valeur a attribuer a id annee scolaire
     */
    public Trimestre(int numero_, Date debut_trimestre_, Date fin_trimestre_, int id_anneeScolaire_){
        id_trimestre=0;
        numero=numero_;
        debut_trimestre=debut_trimestre_;
        fin_trimestre=fin_trimestre_;
        id_anneeScolaire=id_anneeScolaire_;
    }

    //méthodes
}
