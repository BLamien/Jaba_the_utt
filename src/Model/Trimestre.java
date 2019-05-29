package Model;

public class Trimestre {
    //attribut
    private int id_trimestre;
    private int numero;
    private int debut_trimestre;
    private int fin_trimestre;
    private int id_anneeScolaire;

    //getter
    public int getId_trimestre() {return id_trimestre;}
    public int getNumero() {return numero;}
    public int getDebut_trimestre() {return debut_trimestre;}
    public int getFin_trimestre() {return fin_trimestre;}
    public int getId_anneeScolaire() {return id_anneeScolaire;}

    //setter
    public void setId_trimestre(int id_trimestre) {this.id_trimestre = id_trimestre;}
    public void setNumero(int numero) {this.numero = numero;}
    public void setDebut_trimestre(int debut_trimestre) {this.debut_trimestre = debut_trimestre;}
    public void setFin_trimestre(int fin_trimestre) {this.fin_trimestre = fin_trimestre;}
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}

    //constructeur
    public Trimestre(){
        id_trimestre=0;
        numero=0;
        debut_trimestre=0;
        fin_trimestre=0;
        id_anneeScolaire=0;
    }
    public Trimestre(int id_trimestre_, int numero_, int debut_trimestre_, int fin_trimestre_, int id_anneeScolaire_){
        id_trimestre=id_trimestre_;
        numero=numero_;
        debut_trimestre=debut_trimestre_;
        fin_trimestre=fin_trimestre_;
        id_anneeScolaire=id_anneeScolaire_;
    }
    public Trimestre(int numero_, int debut_trimestre_, int fin_trimestre_, int id_anneeScolaire_){
        id_trimestre=0;
        numero=numero_;
        debut_trimestre=debut_trimestre_;
        fin_trimestre=fin_trimestre_;
        id_anneeScolaire=id_anneeScolaire_;
    }

    //méthodes
}
