package Model;
/**
 * <b>classe de definiton d'une personne</b>
 * @author Victor
 * @version 1.1
 */
public class Personne {
    //attributs
    protected int id_personne;
    protected String type;
    protected String nom;
    protected String prenom;
    protected String login;
    protected String mdp;

    //constructeur
    /**
     *<b>constructeur par defaut</b>
     */
    public Personne(){
        id_personne=0;
        type="";
        nom="";
        prenom="";
        login="";
        mdp="";
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_personne_ valaur a attribuer a id personne
     * @param type_ valaur a attribuer a type
     * @param nom_ valeur a attribuer a nom
     * @param prenom_ valaur a attribuer au prenom
     * @param login_ valaur a attribuer au login
     * @param mdp_ valaur a attribuer au mot de passe
     */
    public Personne(int id_personne_,String type_ ,String nom_, String prenom_ ,String login_, String mdp_){
        id_personne=id_personne_;
        type=type_;
        nom=nom_;
        prenom=prenom_;
        login=login_;
        mdp=mdp_;
    }
    /**
     * <b>constructeur surcharge sans id personne</b>
     * @param type_ valaur a attribuer a type
     * @param nom_ valeur a attribuer a nom
     * @param prenom_ valaur a attribuer au prenom
     * @param login_ valaur a attribuer au login
     * @param mdp_ valaur a attribuer au mot de passe
     */
    public Personne(String type_ ,String nom_, String prenom_ ,String login_, String mdp_){
        id_personne=0;
        type=type_;
        nom=nom_;
        prenom=prenom_;
        login=login_;
        mdp=mdp_;
    }

    //methode


    //getter

    /**
     * <b>getter id personne</b>
     * @return id personne
     */
    public int getId_personne() {return id_personne;}
    /**
     * <b>getter type</b>
     * @return type
     */
    public String getType() {return type;}

    public String getNom() {
        return nom;
    }

    /**
     * <b>getter prenom</b>
     * @return prenom
     */
    public String getPrenom() {return prenom;}
    /**
     * <b>getter login</b>
     * @return login
     */
    public String getLogin() {return login;}
    /**
     * <b>getter mot de passe</b>
     * @return le mot de passe
     */
    public String getMdp() {return mdp;}

    //setter
    /**
     * <b>setter id personne</b>
     * @param id_personne valaur a attribuer a id personne
     */
    public void setId_personne(int id_personne) {this.id_personne = id_personne;}
    /**
     * <b>setter type</b>
     * @param type valaur a attribuer a type
     */
    public void setType(String type) {this.type = type;}

    /**
     * <b>setter type</b>
     * @param nom valaur a attribuer a nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * <b>setter prenom</b>
     * @param prenom valaur a attribuer a prenom
     */
    public void setPrenom(String prenom) {this.prenom = prenom;}
    /**
     * <b>setter login</b>
     * @param login valaur a attribuer a login
     */
    public void setLogin(String login) {this.login = login;}
    /**
     * <b>setter mot de passe</b>
     * @param mdp valaur a attribuer au mot de passe
     */
    public void setMdp(String mdp) {this.mdp = mdp;}

}
