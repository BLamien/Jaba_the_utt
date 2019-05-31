package Model;

public class Personne {
    //attributs
    protected int id_personne;
    protected String type;
    protected String prenom;
    protected String login;
    protected String mdp;

    //getter
    public int getId_personne() {return id_personne;}
    public String getType() {return type;}
    public String getPrenom() {return prenom;}
    public String getLogin() {return login;}
    public String getMdp() {return mdp;}

    //setter
    public void setId_personne(int id_personne) {this.id_personne = id_personne;}
    public void setType(String type) {this.type = type;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setLogin(String login) {this.login = login;}
    public void setMdp(String mdp) {this.mdp = mdp;}

    //constructeur
    Personne(){
        id_personne=0;
        type="";
        prenom="";
        login="";
        mdp="";
    }
    public Personne(int id_personne_,String type_ ,String prenom_ ,String login_, String mdp_){
        id_personne=id_personne_;
        type=type_;
        prenom=prenom_;
        login=login_;
        mdp=mdp_;
    }
    Personne(String type_ ,String prenom_ ,String login_, String mdp_){
        id_personne=0;
        type=type_;
        prenom=prenom_;
        login=login_;
        mdp=mdp_;
    }

    //methode
}
