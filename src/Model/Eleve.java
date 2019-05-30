package Model;

public class Eleve extends Personne{
    //attribut
    private int id_classe;

    //getter
    public int getId_classe() {return id_classe;}

    //setter
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}

    //constructeur
    public Eleve() {
        super();
        setType("eleve");
        id_classe=0;
    }

    public Eleve(int id_personne_, String prenom_, String login_, String mdp_, int id_classe_) {
        super(id_personne_, "eleve", prenom_, login_, mdp_);
        id_classe=id_classe_;
    }

    public Eleve(String prenom_, String login_, String mdp_, int id_classe_) {
        super("eleve", prenom_, login_, mdp_);
        id_classe=id_classe_;
    }

    //methode
}
