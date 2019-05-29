package Model;

public class AnneeScolaire {
    //attribut
    private int id_anneeScolaire;
    private int debut_anneeScolaire;
    private int fin_anneeScolaire;

    //getter
    public int getId_anneeScolaire() {return id_anneeScolaire;}
    public int getDebut_anneeScolaire() {return debut_anneeScolaire;}
    public int getFin_anneeScolaire() {return fin_anneeScolaire;}

    //setter
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}
    public void setDebut_anneeScolaire(int debut_anneeScolaire) {this.debut_anneeScolaire = debut_anneeScolaire;}
    public void setFin_anneeScolaire(int fin_anneeScolaire) {this.fin_anneeScolaire = fin_anneeScolaire;}

    //constructeur
    public AnneeScolaire(){
        id_anneeScolaire=0;
        debut_anneeScolaire=0;
        fin_anneeScolaire=0;
    }
    public AnneeScolaire (int id_anneeScolaire_, int debut_anneeScolaire_, int fin_anneeScolaire_){
        id_anneeScolaire=id_anneeScolaire_;
        debut_anneeScolaire=debut_anneeScolaire_;
        fin_anneeScolaire=fin_anneeScolaire_;
    }
    public AnneeScolaire (int debut_anneeScolaire_, int fin_anneeScolaire_){
        id_anneeScolaire=0;
        debut_anneeScolaire=debut_anneeScolaire_;
        fin_anneeScolaire=fin_anneeScolaire_;
    }

    //méthode
}
