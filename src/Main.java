import Controller.Connexion;
import View.Acceuil.AcceuilCenter;
import View.Acceuil.AccueilFrame;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String nombdd = "projetjava";
        String user = "root";
        String passwd = "";
        View.Acceuil.AccueilFrame acceuil = new AccueilFrame();

        Connexion test = new Connexion(nombdd, user, passwd);

        ArrayList<String> Liste;
        String table = "eleve";
        Liste = test.remplirChampsTable(table);

        for(int i=0; i<Liste.size(); i++)
        {
            System.out.print(Liste.get(i)+ " ");
        }

    }
}
