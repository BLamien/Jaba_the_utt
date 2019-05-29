package Model;

public class Devoir {
    //attribut
    private int id_devoir;
    private int note;
    private String appreciation_evaluation;
    private int id_detailBulletin;

    //getter
    public int getId_devoir() {return id_devoir;}
    public int getNote() {return note;}
    public String getAppreciation_evaluation() {return appreciation_evaluation;}
    public int getId_detailBulletin() {return id_detailBulletin;}

    //setter
    public void setId_devoir(int id_devoir) {this.id_devoir = id_devoir;}
    public void setNote(int note) {this.note = note;}
    public void setAppreciation_evaluation(String appreciation_evaluation) {this.appreciation_evaluation = appreciation_evaluation;}
    public void setId_detailBulletin(int id_detailBulletin) {this.id_detailBulletin = id_detailBulletin;}

    //constructeur
    public Devoir(){
        id_devoir=0;
        note=0;
        appreciation_evaluation="";
        id_detailBulletin=0;
    }
    public Devoir(int id_devoir_, int note_, String appreciation_evaluation_, int id_detailBulletin_){
        id_devoir=id_devoir_;
        note=note_;
        appreciation_evaluation=appreciation_evaluation_;
        id_detailBulletin=id_detailBulletin_;
    }
    public Devoir(int note_, String appreciation_evaluation_, int id_detailBulletin_){
        id_devoir=0;
        note=note_;
        appreciation_evaluation=appreciation_evaluation_;
        id_detailBulletin=id_detailBulletin_;
    }

    //méthode

}
