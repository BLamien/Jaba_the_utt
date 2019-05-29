package Model;

public class Niveau {
    //attribut
    private int id_nibeau;
    private int nom_niveau;

    //getter
    public int getId_nibeau() {return id_nibeau;}
    public int getNom_niveau() {return nom_niveau;}

    //setter
    public void setId_nibeau(int id_nibeau) {this.id_nibeau = id_nibeau;}
    public void setNom_niveau(int nom_niveau) {this.nom_niveau = nom_niveau;}

    //constructeur
    public Niveau(){
        id_nibeau=0;
        nom_niveau=0;
    }
    public Niveau(int id_nibeau_, int nom_niveau_){
        id_nibeau=id_nibeau_;
        nom_niveau=nom_niveau_;
    }
    public Niveau(int nom_niveau_){
        id_nibeau=0;
        nom_niveau=nom_niveau_;
    }

    //méthodes
}
