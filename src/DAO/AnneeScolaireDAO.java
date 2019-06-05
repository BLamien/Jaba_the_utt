package DAO

import Model.AnneeScolaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends com.sdz.dao.DAO<AnneeScolaire> {
    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    public boolean create(AnneeScolaire obj) {
        return false;
    }

    public boolean delete(AnneeScolaire obj) {
        return false;
    }

    public boolean update(AnneeScolaire obj) {
        return false;
    }

    public AnneeScolaire connection(int id) {
        AnneeScolaire AnneeScolaire = new AnneeScolaire();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/AnneeScolaire";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM AnneeScolaire WHERE ID_AnneeScolaire ="+id);
            if(result.first())
                AnneeScolaire = new AnneeScolaire(result.getInt("ID_AnneeScolaire"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AnneeScolaire;
    }
}