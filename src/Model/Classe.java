package Model;

import java.util.ArrayList;
//TODO ajouter un attribut niveau (string) et enlever la classe niveau
public class Classe {
    //attribut
    private int id_classe;
    private int id_ecole;
    private int id_niveau;
    private int id_anneeScolaire;
    private ArrayList<Personne> effectif; //cette variable doit contenir uniquement des élèves

    //getter
    public int getId_classe() {return id_classe;}
    public int getId_ecole() {return id_ecole;}
    public int getId_niveau() {return id_niveau;}
    public int getId_anneeScolaire() {return id_anneeScolaire;}
    public ArrayList<Personne> getEffectif() {return effectif;}

    //setter
    public void setId_classe(int id_classe) {this.id_classe = id_classe;}
    public void setId_ecole(int id_ecole) {this.id_ecole = id_ecole;}
    public void setId_niveau(int id_niveau) {this.id_niveau = id_niveau;}
    public void setId_anneeScolaire(int id_anneeScolaire) {this.id_anneeScolaire = id_anneeScolaire;}
    public void setEffectif(ArrayList<Personne> effectif) {this.effectif = effectif;}

    //constructeur
    public Classe(){
        id_classe=0;
        id_ecole=0;
        id_niveau=0;
        id_anneeScolaire=0;
        effectif=new ArrayList<Personne>();
    }
    public Classe(int id_classe_, int id_ecole_, int id_niveau_, int id_anneeScolaire_,ArrayList<Personne> effectif_){
        id_classe=id_classe_;
        id_ecole=id_ecole_;
        id_niveau=id_niveau_;
        id_anneeScolaire=id_anneeScolaire_;
        effectif=effectif_;
    }
    public Classe(int id_ecole_, int id_niveau_, int id_anneeScolaire_,ArrayList<Personne> effectif_){
        id_ecole=id_ecole_;
        id_niveau=id_niveau_;
        id_anneeScolaire=id_anneeScolaire_;
        effectif=effectif_;
    }

    //méthodes
    public void ajout_eleve(Eleve monEleve){
        effectif.add(monEleve);
    }
    public void ajout_eleve(Personne monEleve){
        //on vérifie que la personne est un eleve
        if (monEleve instanceof Eleve)
            effectif.add(monEleve);
    }
}
