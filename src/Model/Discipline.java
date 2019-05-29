package Model;

public class Discipline {
    //attribut
    private int id_discipline;
    private String nom_discipline;

    //getter
    public int getId_discipline() {return id_discipline;}
    public String getNom_discipline() {return nom_discipline;}

    //setter
    public void setId_discipline(int id_discipline) {this.id_discipline = id_discipline;}
    public void setNom_discipline(String nom_discipline) {this.nom_discipline = nom_discipline;}

    //constructeur
    public Discipline(){
        id_discipline=0;
        nom_discipline="";
    }
    public Discipline(int id_discipline_, String nom_discipline_){
        id_discipline=id_discipline_;
        nom_discipline=nom_discipline_;
    }
    public Discipline(String nom_discipline_){
        id_discipline=0;
        nom_discipline=nom_discipline_;
    }

    //méthodes

}
