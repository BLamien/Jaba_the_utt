package Model;

public class Enseignant extends Personne{
    //attributs

    //getter

    //setter

    //constructeur
    public Enseignant() {
        super();
        setType("enseignant");
    }

    public Enseignant(int id_personne_, String prenom_, String login_, String mdp_) {
        super(id_personne_, "enseignant", prenom_, login_, mdp_);
    }

    public Enseignant(String prenom_, String login_, String mdp_) {
        super("enseignant", prenom_, login_, mdp_);
    }

    //methodes
}
