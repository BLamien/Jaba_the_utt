package Model;

public class Ecole {
    //attribut
    private int id_niveau;
    private String nom_niveau;

    //getter
    public int getId_niveau() {return id_niveau;}
    public String getNom_niveau() {return nom_niveau;}

    //setter
    public void setId_niveau(int id_niveau) {this.id_niveau = id_niveau;}
    public void setNom_niveau(String nom_niveau) {this.nom_niveau = nom_niveau;}

    //constructeur
    public Ecole(){
        id_niveau=0;
        nom_niveau="";
    }
    public Ecole(int id_niveau_, String nom_niveau_){
        id_niveau=id_niveau_;
        nom_niveau=nom_niveau_;
    }
    public Ecole(String nom_niveau_){
        id_niveau=0;
        nom_niveau=nom_niveau_;
    }

    //méthode
}
