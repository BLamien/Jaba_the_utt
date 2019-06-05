package Model;
/**
 * <b>classe de definiton d'une annee scolaire</b>
 * @author Victor
 * @version 1.0
 */
public class AnneeScolaire {
    //attribut
    private int id_anneescolaire;
    private Trimestre trimestre1;
    private Trimestre trimestre2;
    private Trimestre trimestre3;

    /**
     * <b>Constructeur surchargé</b>
     * @param id_anneescolaire valeur prise par id_anneescolaire
     * @param trimestre1 valeur prise par trimestre1
     * @param trimestre2 valeur prise par trimestre2
     * @param trimestre3 valeur prise par trimestre3
     */
    public AnneeScolaire(int id_anneescolaire, Trimestre trimestre1, Trimestre trimestre2, Trimestre trimestre3) {
        this.id_anneescolaire = id_anneescolaire;
        this.trimestre1 = trimestre1;
        this.trimestre2 = trimestre2;
        this.trimestre3 = trimestre3;
    }

    /**
     * <b>Constructeur surchargé sans les trimestres</b>
     * @param id_anneescolaire valeur prise par id_anneescolaire
     */
    public AnneeScolaire(int id_anneescolaire) {
        this.id_anneescolaire = id_anneescolaire;
        this.trimestre1 = new Trimestre();
        this.trimestre2 = new Trimestre();
        this.trimestre3 = new Trimestre();
    }

    /**
     * <b>getter id_anneescolaire</b>
     * @return id_anneescolaire
     */
    public int getId_anneescolaire() {
        return id_anneescolaire;
    }

    /**
     * <b>stter id_anneescolaire</b>
     * @param id_anneescolaire nouvelle valeur de id_anneescolaire
     */
    public void setId_anneescolaire(int id_anneescolaire) {
        this.id_anneescolaire = id_anneescolaire;
    }

    /**
     * <b>getter trimestre1</b>
     * @return trimestre1
     */
    public Trimestre getTrimestre1() {
        return trimestre1;
    }

    /**
     * <b>setter trimestre 1</b>
     * @param trimestre1 nouvelle valeur de trimestre1
     */
    public void setTrimestre1(Trimestre trimestre1) {
        this.trimestre1 = trimestre1;
    }

    /**
     * <b>getter trimestre2</b>
     * @return trimestre2
     */
    public Trimestre getTrimestre2() {
        return trimestre2;
    }

    /**
     * <b>setter trimestre2</b>
     * @param trimestre2 nouvelle valeur de trimestre2
     */
    public void setTrimestre2(Trimestre trimestre2) {
        this.trimestre2 = trimestre2;
    }

    /**
     * <b>getter trimestre3</b>
     * @return trimestre3
     */
    public Trimestre getTrimestre3() {
        return trimestre3;
    }

    /**
     * <b>setter trimestre3</b>
     * @param trimestre3 nouvelle valeur de trimestre3
     */
    public void setTrimestre3(Trimestre trimestre3) {
        this.trimestre3 = trimestre3;
    }

    //méthodes
}
