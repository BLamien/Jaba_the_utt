package Model;

public class Bulletin {
    //attribut
    private int id_bulletin;
    private int id_trimestre;
    private String appreciation_bulletin;
    private int id_eleve;

    //getter
    public int getId_bulletin() {return id_bulletin;}
    public int getId_trimestre() {return id_trimestre;}
    public String getAppreciation_bulletin() {
        return appreciation_bulletin;
    }
    public int getId_eleve() {return id_eleve; }

    //setter
    public void setId_bulletin(int id_bulletin) {this.id_bulletin = id_bulletin; }
    public void setId_trimestre(int id_trimestre) {this.id_trimestre = id_trimestre;}
    public void setAppreciation_bulletin(String appreciation_bulletin) {this.appreciation_bulletin = appreciation_bulletin;}
    public void setId_eleve(int id_eleve) {this.id_eleve = id_eleve;}

    //constructeur
    public Bulletin(){
        id_bulletin=0;
        id_trimestre=0;
        appreciation_bulletin="";
        id_eleve=0;
    }
    public Bulletin(int id_bulletin_, int id_trimestre_, int id_eleve_, String appreciation_bulletin_){
        id_bulletin=id_bulletin_;
        id_trimestre=id_trimestre_;
        appreciation_bulletin=appreciation_bulletin_;
        id_eleve=id_eleve_;
    }
    public Bulletin(int id_trimestre_, int id_eleve_, String appreciation_bulletin_){
        id_bulletin=0;
        id_trimestre=id_trimestre_;
        appreciation_bulletin=appreciation_bulletin_;
        id_eleve=id_eleve_;
    }
    //methode
}



