package Model;

public class Enseignement {
    //attribut
    private int id_enseignement;
    private int id_discipline;
    private int id_enseignant;
    private int id_classe;

    //getter
    public int getId_enseignement() {return id_enseignement;}
    public int getId_discipline() {return id_discipline;}
    public int getId_enseignant() {return id_enseignant;}
    public int getId_classe() {return id_classe;}

    //setter
    public void setId_enseignement(int id_enseignement) {this.id_enseignement = id_enseignement;}
    public void setId_discipline(int id_discipline) {this.id_discipline = id_discipline;}
    public void setId_enseignant(int id_enseignant) {this.id_enseignant = id_enseignant;}
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}

    //constructeur
    public Enseignement(){
        id_enseignement=0;
        id_discipline=0;
        id_enseignant=0;
        id_classe=0;
    }
    public Enseignement(int id_enseignement_, int id_discipline_, int id_enseignant_, int id_classe_){
        id_enseignement=id_enseignement_;
        id_discipline=id_discipline_;
        id_enseignant=id_enseignant_;
        id_classe=id_classe_;
    }
    public Enseignement(int id_discipline_, int id_enseignant_, int id_classe_){
        id_enseignement=0;
        id_discipline=id_discipline_;
        id_enseignant=id_enseignant_;
        id_classe=id_classe_;
    }

    //méthode
}
