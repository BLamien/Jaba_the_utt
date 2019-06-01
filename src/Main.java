import Controller.Connexion;
import View.Acceuil.AcceuilCenter;
import View.Acceuil.AccueilFrame;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String nombdd = "projetjava";
        String user = "root";
        String passwd = "";
        View.Acceuil.AccueilFrame acceuil = new AccueilFrame();

        Connexion test = new Connexion(nombdd, user, passwd);

    }
}
