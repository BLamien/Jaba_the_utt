package Model;
/**
 * <b>classe de definiton d'un devoir</b>
 * @author Victor
 * @version 1.0
 */
public class Devoir {
    //attribut
    private int id_devoir;
    private int note;
    private String appreciation_evaluation;
    private int id_detailBulletin;

    //getter

    /**
     * <b>getter id devoir</b>
     * @return id devoir
     */
    public int getId_devoir() {return id_devoir;}
    /**
     * <b>getter note</b>
     * @return note
     */
    public int getNote() {return note;}
    /**
     * <b>getter appreciation</b>
     * @return appreciation
     */
    public String getAppreciation_evaluation() {return appreciation_evaluation;}
    /**
     * <b>getter id detail bulletin</b>
     * @return id detail bulletin
     */
    public int getId_detailBulletin() {return id_detailBulletin;}

    //setter

    /**
     * <b>setter id devoir</b>
     * @param id_devoir valeur a attribuer a l'id devoir
     */
    public void setId_devoir(int id_devoir) {this.id_devoir = id_devoir;}
    /**
     * <b>setter note</b>
     * @param note valeur a attribuer a la note
     */
    public void setNote(int note) {this.note = note;}
    /**
     * <b>setter appreciation</b>
     * @param appreciation_evaluation valeur a attribuer a l'appreciation
     */
    public void setAppreciation_evaluation(String appreciation_evaluation) {this.appreciation_evaluation = appreciation_evaluation;}
    /**
     * <b>setter detail bulletin</b>
     * @param id_detailBulletin valeur a attribuer au detail du bulletin
     */
    public void setId_detailBulletin(int id_detailBulletin) {this.id_detailBulletin = id_detailBulletin;}

    //constructeur
    /**
     * <b>constucteur par defaut</b>
     */
    public Devoir(){
        id_devoir=0;
        note=0;
        appreciation_evaluation="";
        id_detailBulletin=0;
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_devoir_ valeur a attribuer a l'id devoir
     * @param note_ valeur a attribuer a la note
     * @param appreciation_evaluation_ valeur a attribuer a l'appreciation
     * @param id_detailBulletin_ valeur a attribuer au detail du bulletin
     */
    public Devoir(int id_devoir_, int note_, String appreciation_evaluation_, int id_detailBulletin_){
        id_devoir=id_devoir_;
        note=note_;
        appreciation_evaluation=appreciation_evaluation_;
        id_detailBulletin=id_detailBulletin_;
    }
    /**
     * <b>constructeur surcharge sans id devoir</b>
     * @param note_ valeur a attribuer a la note
     * @param appreciation_evaluation_ valeur a attribuer a l'appreciation
     * @param id_detailBulletin_ valeur a attribuer au detail du bulletin
     */
    public Devoir(int note_, String appreciation_evaluation_, int id_detailBulletin_){
        id_devoir=0;
        note=note_;
        appreciation_evaluation=appreciation_evaluation_;
        id_detailBulletin=id_detailBulletin_;
    }

    //méthode

}
