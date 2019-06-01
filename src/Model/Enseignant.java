package Model;
/**
 * <b>classe de definiton d'un enseignant</b>
 * un enseignant est une personne
 * @author Victor
 * @version 1.0
 */
public class Enseignant extends Personne{
    //attributs

    //getter

    //setter

    //constructeur

    /**
     * <b>onstructeur par defaut</b>
     */
    public Enseignant() {
        super();
        setType("enseignant");
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_personne_ valeur a attribuer a l'id personne
     * @param prenom_ valeur a attribuer au prenom
     * @param login_ valeur a attribuer au login
     * @param mdp_ valeur a attribuer au mot de passe
     */
    public Enseignant(int id_personne_, String prenom_, String login_, String mdp_) {
        super(id_personne_, "enseignant", prenom_, login_, mdp_);
    }
    /**
     * <b>constructeur surcharge sans l'id personne</b>
     * @param prenom_ valeur a attribuer au prenom
     * @param login_ valeur a attribuer au login
     * @param mdp_ valeur a attribuer au mot de passe
     */
    public Enseignant(String prenom_, String login_, String mdp_) {
        super("enseignant", prenom_, login_, mdp_);
    }

    //methodes
}
