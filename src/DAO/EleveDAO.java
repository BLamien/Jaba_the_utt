package DAO

import Model.Personne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends com.sdz.dao.DAO<Personne> {
    public EleveDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Personne obj) {
        return false;
    }

    public boolean delete(Personne obj) {
        return false;
    }

    public boolean update(Personne obj) {
        return false;
    }

    public Personne connection(int id) {
        Personne Personne = new Personne();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Eleve";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve WHERE Login ="+id);
            if(result.first())
                Personne = new Personne(result.getInt("ID_Eleve"),
                        "eleve",
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Login"),
                        result.getString("Mdp")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Personne;
    }
}