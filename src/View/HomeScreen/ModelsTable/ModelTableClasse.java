package View.HomeScreen.ModelsTable;
//TODO : JavaDoc
import Model.Classe;
import Model.Ecole;
import Model.Personne;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * <b>Model de table pour l'affichage des informations sur la fenetre principale</b>
 * @author Leonard
 * @version 1.0
 */
public class ModelTableClasse extends AbstractTableModel {
    private ArrayList<Classe> classes;
    private ArrayList<Personne> personnes;
    private ArrayList<Ecole> ecoles;

    private String[] entetes = {"ID", "Ecole", "Niveau", "Année scolaire", "Taille effectif"};

    /**
     * <b>Constructeur du modèle de JTable</b>
     */
    public ModelTableClasse(ArrayList<Classe> classes_, ArrayList<Personne> personnes_, ArrayList<Ecole> ecoles_) {
        super();
        classes =classes_;
        personnes=personnes_;
        ecoles=ecoles_;
    }

    /**
     * <b>Getteur du nombre de ligne de la table</b>
     * @return int
     */
    public int getRowCount() {
        return classes.size();
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
                return classes.get(rowIndex).getId_classe();
            case 1:
                return classes.get(rowIndex).get_ecole().getNom_ecole();
            case 2:
                return classes.get(rowIndex).getNom_niveau();
            case 3:
                return classes.get(rowIndex).get_anneescolaire().getId_anneescolaire();
            case 4:
                return classes.get(rowIndex).get_effectif().size();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    /**
     * Methode qui permet l'ajout d'une personne
     * @param classe personne que l'on souhaite ajouter
     */
    public void addClasse(Classe classe) {
        classes.add(classe);
        fireTableRowsInserted(classes.size() -1, classes.size() -1);
    }

    /**
     * Methode qui permet de supprimer une personne
     * @param rowIndex index de la personne à supprimer
     */
    public void removeClasse(int rowIndex) {
        classes.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }
    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }
    public ArrayList<Ecole> getEcoles() {
        return ecoles;
    }
}
