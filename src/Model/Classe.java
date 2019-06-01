package Model;
/**
 * <b>classe de definition d'une classe</b>
 * @author Victor
 * @version 1.0
 */
import java.util.ArrayList;
//TODO ajouter un attribut niveau (string) et enlever la classe niveau
public class Classe {
    //attribut
    private int id_classe;
    private int id_ecole;
    private int id_niveau;
    private int id_anneeScolaire;
    private ArrayList<Personne> effectif; //cette variable doit contenir uniquement des élèves

    //getter

    /**
     * <b>getter id classe</b>
     * @return id classe
     */
    public int getId_classe() {return id_classe;}
    /**
     * <b>getter id ecole</b>
     * @return id ecole
     */
    public int getId_ecole() {return id_ecole;}
    /**
     * <b>getter id niveau</b>
     * @return id niveau
     */
    public int getId_niveau() {return id_niveau;}
    /**
     * <b>getter id annee scolaire</b>
     * @return id annee scolaire
     */
    public int getId_anneeScolaire() {return id_anneeScolaire;}
    /**
     * <b>getter effectif</b>
     * @return effectif
     */
    public ArrayList<Personne> getEffectif() {return effectif;}

    //setter
    /**
     * <b>setter id classe</b>
     * @param id_classe valeur a attribuer a l'id de la classe
     */
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}
    /**
     * <b>setter id ecole</b>
     * @param id_ecole valeur a attribuer a l'id de l'ecole
     */
    public void setId_ecole(int id_ecole) {this.id_ecole = id_ecole;}
    /**
     * <b>setter id niveau</b>
     * @param id_niveau valeur a attribuer a l'id du niveau
     */
    public void setId_niveau(int id_niveau) {this.id_niveau = id_niveau;}
    /**
     * <b>setter id annee scolaire</b>
     * @param id_anneeScolaire valeur a attribuer a l'id de l'annee scolaire
     */
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}
    /**
     * <b>setter effectif</b>
     * @param effectif valeur a attribuer a l'effectif
     */
    public void setEffectif(ArrayList<Personne> effectif) {this.effectif = effectif;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public Classe(){
        id_classe=0;
        id_ecole=0;
        id_niveau=0;
        id_anneeScolaire=0;
        effectif=new ArrayList<Personne>();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_classe_ valeur a atrribuer a l'id classe
     * @param id_ecole_ valeur a atrribuer a l'id ecole
     * @param id_niveau_ valeur a atrribuer a l'id niveau
     * @param id_anneeScolaire_ valeur a atrribuer a l'id annee scolaire
     * @param effectif_ valeur a atrribuer a l'effectif
     */
    public Classe(int id_classe_, int id_ecole_, int id_niveau_, int id_anneeScolaire_,ArrayList<Personne> effectif_){
        id_classe=id_classe_;
        id_ecole=id_ecole_;
        id_niveau=id_niveau_;
        id_anneeScolaire=id_anneeScolaire_;
        effectif=effectif_;
    }
    /**
     * <b>constructeur surcharge sans id classe</b>
     * @param id_ecole_ valeur a atrribuer a l'id ecole
     * @param id_niveau_ valeur a atrribuer a l'id niveau
     * @param id_anneeScolaire_ valeur a atrribuer a l'id annee scolaire
     * @param effectif_ valeur a atrribuer a l'effectif
     */
    public Classe(int id_ecole_, int id_niveau_, int id_anneeScolaire_,ArrayList<Personne> effectif_){
        id_ecole=id_ecole_;
        id_niveau=id_niveau_;
        id_anneeScolaire=id_anneeScolaire_;
        effectif=effectif_;
    }

    //méthodes

    /**
     * <b>permet l'ajout d'un eleve a l'effectif</b>
     * @param monEleve eleve
     */
    public void ajout_eleve(Eleve monEleve){
        effectif.add(monEleve);
    }

    /**
     * <b>permet l'ajout d'une personne eleve a l'effectif</b>
     * @param monEleve eleve
     */
    public void ajout_eleve(Personne monEleve){
        //on vérifie que la personne est un eleve
        if (monEleve instanceof Eleve)
            effectif.add(monEleve);
    }
}
