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
    private Ecole ecole;
    private String nom_niveau;
    private AnneeScolaire anneescolaire;
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
    public Ecole get_ecole() {return ecole;}
    /**
     * <b>getter id niveau</b>
     * @return nom niveau
     */
    public String getNom_niveau() {return nom_niveau;}
    /**
     * <b>getter id annee scolaire</b>
     * @return id annee scolaire
     */
    public AnneeScolaire get_anneescolaire() {return anneescolaire;}
    /**
     * <b>getter effectif</b>
     * @return effectif
     */
    public ArrayList<Personne> get_effectif() {return effectif;}



    //setter
    /**
     * <b>setter id classe</b>
     * @param id_classe valeur a attribuer a l'id de la classe
     */
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}
    /**
     * <b>setter id ecole</b>
     * @param ecole Objet ecole
     */
    public void set_ecole(Ecole ecole) {this.ecole = ecole;}
    /**
     * <b>setter nom niveau</b>
     * @param nom_niveau valeur a attribuer a le nom du niveau
     */
    public void setNom_niveau(String nom_niveau) {this.nom_niveau = nom_niveau;}



    /**
     * <b>setter annee scolaire</b>
     * @param anneescolaire valeur a attribuer a l'id de l'annee scolaire
     */
    public void setAnneeScolaire(AnneeScolaire anneescolaire) {this.anneescolaire = anneescolaire;}
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
        ecole=new Ecole();
        nom_niveau="";
        anneescolaire=new AnneeScolaire();
        effectif=new ArrayList<Personne>();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_classe_ valeur a atrribuer a l'id classe
     * @param ecole_ valeur a atrribuer a  ecole
     * @param nom_niveau_ valeur a atrribuer a l'id niveau
     * @param anneescolaire_ valeur a atrribuer a l'annee scolaire
     * @param effectif_ valeur a atrribuer a l'effectif
     */
    public Classe(int id_classe_, Ecole ecole_, String nom_niveau_, AnneeScolaire anneescolaire_, ArrayList<Personne> effectif_){
        id_classe=id_classe_;
        ecole=ecole_;
        nom_niveau=nom_niveau_;
        anneescolaire=anneescolaire_;
        effectif=effectif_;
    }
    /**
     * <b>constructeur surcharge sans les objets</b>
     * @param id_classe_ valeur a atrribuer a l'id classe
     * @param nom_niveau_ valeur a atrribuer a l'id niveau
     */
    public Classe(int id_classe_, String nom_niveau_){
        id_classe=id_classe_;
        ecole=new Ecole();
        nom_niveau=nom_niveau_;
        anneescolaire=new AnneeScolaire();
        effectif=new ArrayList<Personne>();

    }
    /**
     * <b>constructeur surcharge sans id classe</b>
     * @param ecole_ valeur a atrribuer a l'ecole
     * @param nom_niveau_ valeur a atrribuer a l'id niveau
     * @param anneescolaire_ valeur a atrribuer a l'annee scolaire
     * @param effectif_ valeur a atrribuer a l'effectif
     */
    public Classe(Ecole ecole_, String nom_niveau_, AnneeScolaire anneescolaire_,ArrayList<Personne> effectif_){
        ecole=ecole_;
        nom_niveau=nom_niveau_;
        anneescolaire=anneescolaire_;
        effectif=effectif_;
    }

    //méthodes

    /**
     * <b>permet l'ajout d'une personne eleve a l'effectif</b>
     * @param monEleve eleve
     */
    public void ajout_eleve(Personne monEleve){
        //on vérifie que la personne est un eleve
        if (monEleve.getType()=="eleve")
            effectif.add(monEleve);
    }
}
