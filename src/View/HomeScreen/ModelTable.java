package View.HomeScreen;

import Model.Personne;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;


public class ModelTable extends AbstractTableModel {
    private ArrayList<Personne> personnes = new ArrayList<Personne>();

    private String[] entetes = {"ID", "type", "Prenom", "login", "password"};

    public ModelTable() {
        super();

        personnes.add(new Personne(12,"eleves" ,"leo","lifao", "cacacac"));
        personnes.add(new Personne(1,"eleves" ,"t","truc", "fzef"));
        personnes.add(new Personne(22,"eleves" ,"thibault","bidule", "fe"));
        personnes.add(new Personne(32,"eleves" ,"xav","chouette", "cacactjqhac"));
        personnes.add(new Personne(10,"eleves" ,"antoine","madk", "htqhw"));
        personnes.add(new Personne(13,"eleves" ,"paul","lifdsfao", "gqe"));
        personnes.add(new Personne(8,"eleves" ,"jb","fzfe", "gqrge"));

    }

    public int getRowCount() {
        return personnes.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

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

    public void addPersonne(Personne personne) {
        personnes.add(personne);

        fireTableRowsInserted(personnes.size() -1, personnes.size() -1);
    }

    public void removePersonne(int rowIndex) {
        personnes.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
