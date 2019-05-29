package Model;

public class DetailBulletin {
    //attributs
    private int id_detailBulletin;
    private int id_bulletin;
    private int id_enseignant;
    private String appreciation_detailBulletin;

    //getter
    public int getId_detailBulletin() {return id_detailBulletin;}
    public int getId_bulletin() {return id_bulletin;}
    public int getId_enseignant() {return id_enseignant;}
    public String getAppreciation_detailBulletin() {return appreciation_detailBulletin;}


    //setter
    public void setId_detailBulletin(int id_detailBulletin) {this.id_detailBulletin = id_detailBulletin;}
    public void setId_bulletin(int id_bulletin) {this.id_bulletin = id_bulletin;}
    public void setId_enseignant(int id_enseignant) {this.id_enseignant = id_enseignant;}
    public void setAppreciation_detailBulletin(String appreciation_detailBulletin) {this.appreciation_detailBulletin = appreciation_detailBulletin;}

    //constructeur
    public DetailBulletin(){
        id_bulletin=0;
        id_detailBulletin=0;
        id_enseignant=0;
        appreciation_detailBulletin="";
    }
    public DetailBulletin(int id_detailBulletin_, int id_bulletin_, int id_enseignant_, String appreciation_detailBulletin_){
        id_detailBulletin=id_detailBulletin_;
        id_bulletin=id_bulletin_;
        id_enseignant=id_enseignant_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
    }
    public DetailBulletin(int id_bulletin_, int id_enseignant_, String appreciation_detailBulletin_){
        id_detailBulletin=0;
        id_bulletin=id_bulletin_;
        id_enseignant=id_enseignant_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
    }

    //méthode
}
