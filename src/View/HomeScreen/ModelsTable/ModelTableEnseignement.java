package View.HomeScreen.ModelsTable;
//TODO : JavaDoc
import Model.Enseignement;
import Model.Personne;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * <b>Model de table pour l'affichage des informations sur la fenetre principale</b>
 * @author Leonard
 * @version 1.0
 */
public class ModelTableEnseignement extends AbstractTableModel {
    private ArrayList<Enseignement> enseignements;

    private String[] entetes = {"ID", "Discipline", "Enseignant", "ID classe"};

    /**
     * <b>Constructeur du modèle de JTable</b>
     */
    public ModelTableEnseignement(ArrayList<Enseignement> enseignements_) {
        super();
        enseignements =enseignements_;
    }

    /**
     * <b>Getteur du nombre de ligne de la table</b>
     * @return int
     */
    public int getRowCount() {
        return enseignements.size();
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
                return enseignements.get(rowIndex).getId_enseignement();
            case 1:
                return enseignements.get(rowIndex).get_discipline().getNom_discipline();
            case 2:
                return enseignements.get(rowIndex).get_enseignant().getNom();
            case 3:
                return enseignements.get(rowIndex).get_classe().getId_classe();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    /**
     * Methode qui permet l'ajout d'une personne
     * @param enseignement personne que l'on souhaite ajouter
     */
    public void addEnseignement(Enseignement enseignement) {
        enseignements.add(enseignement);
        fireTableRowsInserted(enseignements.size() -1, enseignements.size() -1);
    }

    /**
     * Methode qui permet de supprimer une personne
     * @param rowIndex index de la personne à supprimer
     */
    public void removeEnseignement(int rowIndex) {
        enseignements.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
