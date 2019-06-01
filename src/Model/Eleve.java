package Model;
/**
 * <b>classe de definiton d'un eleve</b>
 * un eleve est une personne
 * @author Victor
 * @version 1.0
 */
public class Eleve extends Personne{
    //attribut
    private int id_classe;

    //getter

    /**
     * <b>getter id classe</b>
     * @return l'id de classe
     */
    public int getId_classe() {return id_classe;}

    //setter

    /**
     * <b>setter id classe</b>
     * @param id_classe valeur a attribuer a l'id classe
     */
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public Eleve() {
        super();
        setType("eleve");
        id_classe=0;
    }
    /**
     * <b>constructeur surcharge</b>
     * @param id_personne_ valeur a attribuer a l'id personne
     * @param prenom_ valeur a attribuer au prenom
     * @param login_ valeur a attribuer au login
     * @param mdp_ valeur a attribuer au mot de passe
     * @param id_classe_ valeur a attribuer a l'id classe
     */
    public Eleve(int id_personne_, String prenom_, String login_, String mdp_, int id_classe_) {
        super(id_personne_, "eleve", prenom_, login_, mdp_);
        id_classe=id_classe_;
    }
    /**
     * <b>constructeur surcharge sans l'id personne</b>
     * @param prenom_ valeur a attribuer au prenom
     * @param login_ valeur a attribuer au login
     * @param mdp_ valeur a attribuer au mot de passe
     * @param id_classe_ valeur a attribuer a l'id classe
     */
    public Eleve(String prenom_, String login_, String mdp_, int id_classe_) {
        super("eleve", prenom_, login_, mdp_);
        id_classe=id_classe_;
    }

    //methode
}
