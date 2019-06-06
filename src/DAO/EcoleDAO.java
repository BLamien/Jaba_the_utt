package DAO;

import Model.Ecole;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class EcoleDAO extends com.sdz.dao.DAO<Ecole> {
    public EcoleDAO() {
        super();
    }

    public boolean create(Ecole obj) {
        return false;
    }

    public boolean delete(Ecole obj) {
        return false;
    }

    public boolean update(Ecole obj) {
        return false;
    }

    @Override
    public Ecole Connection(int id) {
        Ecole Ecole = new Ecole();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Ecole";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Ecole WHERE ID_Ecole ="+id);
            if(result.first())
                Ecole = new Ecole(result.getInt("ID_Ecole"),
                        result.getString("Nom_Ecole"),
                        result.getInt("Annee_Fondation")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Ecole;
    }

}