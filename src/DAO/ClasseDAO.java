package DAO

import Model.Classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends com.sdz.dao.DAO<Classe> {
    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Classe obj) {
        return false;
    }

    public boolean delete(Classe obj) {
        return false;
    }

    public boolean update(Classe obj) {
        return false;
    }

    public Classe connection(int id) {
        Classe Classe = new Classe();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Classe";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE ID_Classe ="+id);
            if(result.first())
                Classe = new Classe(result.getInt("ID_Classe"),
                        result.getString("Niveau")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Classe;
    }
}