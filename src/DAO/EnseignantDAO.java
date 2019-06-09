package DAO;

import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Enseignant permettant d'acceder aux informations de la table Enseignant</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends com.sdz.dao.DAO<Personne> {
    public int taille;
    public ArrayList<Integer> ID_Enseignant;

    /**
     * <b>Contructeur par defaut</b>
     */
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

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignant");
            while(result.next())
                ID_Enseignant.add(result.getInt("ID_Enseignant"));

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un enseignant</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Personne obj) {

    }

    /**
     * <b>Methode permettant de recuperer les informations d'un enseignant et de retourner un objet de type Personne</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type Personne
     */
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