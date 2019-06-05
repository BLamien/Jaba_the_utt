package Model;
/**
 * <b>classe de definiton d'un enseigenment</b>
 * @author Victor
 * @version 1.0
 */
public class Enseignement {
    //attribut
    private int id_enseignement;
    private Discipline discipline;
    private Personne enseignant;
    private Classe classe;

    //getter
    /**
     *<b>getter id enseignement</b>
     * @return id enseignement
     */
    public int getId_enseignement() {return id_enseignement;}
    /**
     *<b>getter  discipline</b>
     * @return  discipline
     */
    public Discipline get_discipline() {return discipline;}
    /**
     *<b>getter  enseignant</b>
     * @return  enseignant
     */
    public Personne get_enseignant() {return enseignant;}
    /**
     *<b>getter classe</b>
     * @return  classe
     */
    public Classe get_classe() {return classe;}

    //setter
    /**
     * <b>setter id enseignement</b>
     * @param id_enseignement valeur a attribuer a id enseignement
     */
    public void setId_enseignement(int id_enseignement) {this.id_enseignement = id_enseignement;}
    /**
     * <b>setter discipline</b>
     * @param discipline Objet a attribuer a discipline
     */
    public void set_discipline(Discipline discipline) {this.discipline = discipline;}
    /**
     * <b>setter enseignant</b>
     * @param enseignant Objet a attribuer a enseignant
     */
    public void set_enseignant(Personne enseignant) {this.enseignant = enseignant;}
    /**
     * <b>setter classe</b>
     * @param classe valeur a attribuer a classe
     */
    public void setId_classe(Classe classe) {this.classe = classe;}

    //constructeur
    /**
     * <b>constructeur par defaut</b>
     */
    public Enseignement(){
        id_enseignement=0;
        discipline=new Discipline();
        enseignant=new Personne();
        classe=new Classe();
    }

    /**
     * <b>constructeur surcharge</b>
     * @param id_enseignement_ valeur a attribuer a l'id enseignement
     * @param discipline_ valeur a attribuer a discipline
     * @param enseignant_ valeur a attribuer a enseignant
     * @param classe_ valeur a attribuer a classe
     */
    public Enseignement(int id_enseignement_, Discipline discipline_, Personne enseignant_, Classe classe_){
        id_enseignement=id_enseignement_;
        discipline=discipline_;
        enseignant=enseignant_;
        classe=classe_;
    }

    //méthode
}
