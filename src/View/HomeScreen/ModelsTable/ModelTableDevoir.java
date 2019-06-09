package View.HomeScreen.ModelsTable;
//TODO : JavaDoc
import Model.Devoir;
import Model.Personne;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import View.Popup;


/**
 * <b>Model de table pour l'affichage des informations sur la fenetre principale</b>
 * @author Leonard
 * @version 1.0
 */
public class ModelTableDevoir extends AbstractTableModel {
    private ArrayList<Devoir> devoir;

    private String[] entetes = {"ID", "Note", "Commentaire"};

    /**
     * <b>Constructeur du modèle de JTable</b>
     */
    public ModelTableDevoir(ArrayList<Devoir> devoir_) {
        super();
        devoir =devoir_;
    }

    /**
     * <b>Getteur du nombre de ligne de la table</b>
     * @return int
     */
    public int getRowCount() {
        return devoir.size();
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
                return devoir.get(rowIndex).getId_devoir();
            case 1:
                return devoir.get(rowIndex).getNote();
            case 2:
                return devoir.get(rowIndex).getAppreciation_evaluation();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    /**
     * Methode qui permet l'ajout d'une personne
     * @param devoir_ personne que l'on souhaite ajouter
     */
    public void addDevoir(Devoir devoir_) {
        devoir.add(devoir_);
        fireTableRowsInserted(devoir.size() -1, devoir.size() -1);
    }

    /**
     * Methode qui permet de supprimer une personne
     * @param rowIndex index de la personne à supprimer
     */
    public void removeDevoir(int rowIndex) {
        devoir.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void update(int rowIndex1, int rowIndex2) {
        String value = Popup.ask("Ecrivez la nouvelle valeur", "Update");
        setValueAt(value,rowIndex1,rowIndex2);
        fireTableCellUpdated(rowIndex1,rowIndex2);
    }
}
