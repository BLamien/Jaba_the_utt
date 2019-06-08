package View.HomeScreen.ModelsTable;
//TODO : JavaDoc
import Model.Personne;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * <b>Model de table pour l'affichage des informations sur la fenetre principale</b>
 * @author Leonard
 * @version 1.0
 */
public class ModelTablePersonne extends AbstractTableModel {
    private ArrayList<Personne> personnes;

    private String[] entetes = {"ID", "type", "Nom", "Prenom", "login", "password"};

    /**
     * <b>Constructeur du modèle de JTable</b>
     */
    public ModelTablePersonne(ArrayList<Personne> personnes_) {
        super();
        personnes=personnes_;
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
                return personnes.get(rowIndex).getNom();
            case 3:
                return personnes.get(rowIndex).getPrenom();
            case 4:
                return personnes.get(rowIndex).getLogin();
            case 5:
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
