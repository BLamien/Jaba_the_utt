package DAO;

import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends com.sdz.dao.DAO<Personne> {
    public int taille;

    public EnseignantDAO() {
        super();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS taille FROM Enseignant");
            result.first();
            this.taille = result.getInt("taille");

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(Personne obj) {


    }

    public void delete(Personne obj) {

    }

    public void update(Personne obj) {

    }

    @Override
    public Personne Connection(int id) {
        Personne Personne = new Personne();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignant WHERE ID_Enseignant =" + id);
            if (result.first())
                Personne = new Personne(result.getInt("ID_Enseignant"),
                        "enseignant",
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Login"),
                        result.getString("Mdp")
                );

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Personne;
    }

}