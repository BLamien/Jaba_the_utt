package Model;
/**
 * <b>classe de definiton d'un bulletin</b>
 * @author Victor
 * @version 1.0
 */
public class Bulletin {
    //attribut
    private int id_bulletin;
    private int id_trimestre;
    private String appreciation_bulletin;
    private int id_eleve;

    //getter
    /**
     * <b>getter id bulletin</b>
     * @return id bulletin
     */
    public int getId_bulletin() {return id_bulletin;}
    /**
     * <b>getter id trimestre</b>
     * @return id trimestre
     */
    public int getId_trimestre() {return id_trimestre;}
    /**
     * <b>getter appreciation</b>
     * @return appreciation
     */
    public String getAppreciation_bulletin() {
        return appreciation_bulletin;
    }
    /**
     * <b>getter id eleve</b>
     * @return id eleve
     */
    public int getId_eleve() {return id_eleve; }

    //setter
    /**
     * <b>setter id bulletin</b>
     * @param id_bulletin valeur a ttribuer a l'id bulletin
     */
    public void setId_bulletin(int id_bulletin) {this.id_bulletin = id_bulletin; }
    /**
     * <b>setter id trimestre</b>
     * @param id_trimestre valeur a ttribuer a l'id trimestre
     */
    public void setId_trimestre(int id_trimestre) {this.id_trimestre = id_trimestre;}
    /**
     * <b>setter appreciation</b>
     * @param appreciation_bulletin valeur a ttribuer a l'appreciation
     */
    public void setAppreciation_bulletin(String appreciation_bulletin) {this.appreciation_bulletin = appreciation_bulletin;}
    /**
     * <b>setter id eleve</b>
     * @param id_eleve valeur a ttribuer a l'id eleve
     */
    public void setId_eleve(int id_eleve) {this.id_eleve = id_eleve;}

    //constructeur

    /**
     * <b>constructeur par defaut</b>
     */
    public Bulletin(){
        id_bulletin=0;
        id_trimestre=0;
        appreciation_bulletin="";
        id_eleve=0;
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_bulletin_ valeur a attribuer a l'id bulletin
     * @param id_trimestre_ valeur a attribuer a l'id trimestre
     * @param id_eleve_ valeur a attribuer a l'id eleve
     * @param appreciation_bulletin_ valeur a attribuer a l'appreciation du bulletin
     */
    public Bulletin(int id_bulletin_, int id_trimestre_, int id_eleve_, String appreciation_bulletin_){
        id_bulletin=id_bulletin_;
        id_trimestre=id_trimestre_;
        appreciation_bulletin=appreciation_bulletin_;
        id_eleve=id_eleve_;
    }
    /**
     * <b>constructeur surcharge sans id bulletin</b>
     * @param id_trimestre_ valeur a attribuer a l'id trimestre
     * @param id_eleve_ valeur a attribuer a l'id eleve
     * @param appreciation_bulletin_ valeur a attribuer a l'appreciation du bulletin
     */
    public Bulletin(int id_trimestre_, int id_eleve_, String appreciation_bulletin_){
        id_bulletin=0;
        id_trimestre=id_trimestre_;
        appreciation_bulletin=appreciation_bulletin_;
        id_eleve=id_eleve_;
    }
    //methode
}



