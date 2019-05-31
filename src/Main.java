import Controller.Connexion;
import View.Acceuil.AcceuilCenter;
import View.Acceuil.AccueilFrame;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String nombdd = "projetjava";
        String user = "root";
        String passwd = "";
        View.Acceuil.AccueilFrame acceuil = new AccueilFrame();

        try {
            Connexion test = new Connexion(nombdd, user, passwd);
            System.out.println("Connexion réussi !");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
