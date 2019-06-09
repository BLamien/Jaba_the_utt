package DAO;

import Model.Ecole;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Ecole permettant d'acceder aux informations de la table Ecole</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class EcoleDAO extends com.sdz.dao.DAO<Ecole> {
    public int taille;

    /**
     * <b>Constructeur par defaut</b>
     */
    public EcoleDAO() {
        super();
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS taille FROM Ecole");
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

    /**
     * <b>Methode de maj d'une ecole</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Ecole obj) {

    }

    /**
     * <b>Methode permettant de recuperer les informations d'une ecole dans la table Ecole et de retourner un objet de type Ecole</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type Ecole
     */
    @Override
    public Ecole Connection(int id) {
        Ecole Ecole = new Ecole();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

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

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Ecole;
    }

}