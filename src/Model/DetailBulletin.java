package Model;
/**
 * <b>classe de definiton du detail du bulletin</b>
 * @author Victor
 * @version 1.0
 */
public class DetailBulletin {
    //attributs
    private int id_detailBulletin;
    private int id_bulletin;
    private int id_enseignant;
    private String appreciation_detailBulletin;

    //getter

    /**
     * <b>getter id detail bulletin</b>
     * @return id detail bulletin
     */
    public int getId_detailBulletin() {return id_detailBulletin;}
    /**
     * <b>getter id bulletin</b>
     * @return id bulletin
     */
    public int getId_bulletin() {return id_bulletin;}
    /**
     * <b>getter id enseignant</b>
     * @return id enseignant
     */
    public int getId_enseignant() {return id_enseignant;}
    /**
     * <b>getter appreciation</b>
     * @return appreciation
     */
    public String getAppreciation_detailBulletin() {return appreciation_detailBulletin;}


    //setter

    /**
     * <b>setter id detail bulletin</b>
     * @param id_detailBulletin valeur a attribuer au detail du bulletin
     */
    public void setId_detailBulletin(int id_detailBulletin) {this.id_detailBulletin = id_detailBulletin;}
    /**
     * <b>setter id bulletin</b>
     * @param id_bulletin valeur a attribuer a l'id du bulletin
     */
    public void setId_bulletin(int id_bulletin) {this.id_bulletin = id_bulletin;}
    /**
     * <b>setter id ensignant</b>
     * @param id_enseignant valeur a attribuer a l'id de l'enseignant
     */
    public void setId_enseignant(int id_enseignant) {this.id_enseignant = id_enseignant;}
    /**
     * <b>setter apprecaiton</b>
     * @param appreciation_detailBulletin valeur a attribuer a l'appreciation
     */
    public void setAppreciation_detailBulletin(String appreciation_detailBulletin) {this.appreciation_detailBulletin = appreciation_detailBulletin;}

    //constructeur

    /**
     * <b>constructeur par defaut</b>
     */
    public DetailBulletin(){
        id_bulletin=0;
        id_detailBulletin=0;
        id_enseignant=0;
        appreciation_detailBulletin="";
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_detailBulletin_ valeur a attribuer au detail du bulletin
     * @param id_bulletin_ valeur a attribuer a l'id bulletin
     * @param id_enseignant_ valeur a attribuer a l'id de l'enseignant
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     */
    public DetailBulletin(int id_detailBulletin_, int id_bulletin_, int id_enseignant_, String appreciation_detailBulletin_){
        id_detailBulletin=id_detailBulletin_;
        id_bulletin=id_bulletin_;
        id_enseignant=id_enseignant_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
    }
    /**
     * <b>constructeur surcharge sans id detail bulletin</b>
     * @param id_bulletin_ valeur a attribuer a l'id bulletin
     * @param id_enseignant_ valeur a attribuer a l'id de l'enseignant
     * @param appreciation_detailBulletin_ valeur a attribuer a l'apprecation
     */
    public DetailBulletin(int id_bulletin_, int id_enseignant_, String appreciation_detailBulletin_){
        id_detailBulletin=0;
        id_bulletin=id_bulletin_;
        id_enseignant=id_enseignant_;
        appreciation_detailBulletin=appreciation_detailBulletin_;
    }

    //méthode
}
