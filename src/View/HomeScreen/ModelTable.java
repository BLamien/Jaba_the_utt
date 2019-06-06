package View.HomeScreen;
//TODO : JavaDoc
import Model.Personne;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * <b>Model de table pour l'affichage des informations sur la fenetre principale</b>
 * @author Leonard
 * @version 1.0
 */
public class ModelTable extends AbstractTableModel {
    private ArrayList<Personne> personnes = new ArrayList<Personne>();

    private String[] entetes = {"ID", "type", "Prenom", "login", "password"};

    /**
     * <b>Constructeur du modèle de JTable</b>
     */
    public ModelTable() {
        super();
        initTest();
    }

    private void initTest(){
        personnes.add(new Personne(12,"eleves" ,"leo","lifao", "cacacac"));
        personnes.add(new Personne(1,"eleves" ,"t","truc", "fzef"));
        personnes.add(new Personne(22,"eleves" ,"thibault","bidule", "fe"));
        personnes.add(new Personne(32,"eleves" ,"xav","chouette", "cacactjqhac"));
        personnes.add(new Personne(10,"eleves" ,"antoine","madk", "htqhw"));
        personnes.add(new Personne(13,"eleves" ,"paul","lifdsfao", "gqe"));
        personnes.add(new Personne(8,"eleves" ,"jb","fzfe", "gqrge"));
    }

    /**
     * <b>Getteur du nombre de ligne de la table</b>
     * @return int
     */
    public int getRowCount() {
        return personnes.size();
    }

    /**
     * <b>Getteur du nombre de colonne de la table</b>
     * @return int
     */
    public int getColumnCount() {
        return entetes.length;
    }

    /**
     * <b>Getteur du nom d'une colonne de la table</b>
     * @param columnIndex index de la colonne en  question
     * @return String
     */
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    /**
     * Retourne la valeur choisis du tableau
     * @param rowIndex index de la ligne que l'on souhaite recevoir
     * @param columnIndex index de la colonne que l'on souaite recevoir
     * @return la valeur désiré
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return personnes.get(rowIndex).getId_personne();
            case 1:
                return personnes.get(rowIndex).getType();
            case 2:
                return personnes.get(rowIndex).getPrenom();
            case 3:
                return personnes.get(rowIndex).getLogin();
            case 4:
                return personnes.get(rowIndex).getMdp();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    /**
     * Methode qui permet l'ajout d'une personne
     * @param personne personne que l'on souhaite ajouter
     */
    public void addPersonne(Personne personne) {
        personnes.add(personne);
        fireTableRowsInserted(personnes.size() -1, personnes.size() -1);
    }

    /**
     * Methode qui permet de supprimer une personne
     * @param rowIndex index de la personne à supprimer
     */
    public void removePersonne(int rowIndex) {
        personnes.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
