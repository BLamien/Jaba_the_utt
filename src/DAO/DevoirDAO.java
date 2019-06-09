package DAO;

import Model.Devoir;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO de Devoir permettant d'acceder a la table Devoir</b>
 * @author Thomas
 * @version 1.0
 */
//CTRL + SHIFT + O pour générer les imports
public class DevoirDAO extends com.sdz.dao.DAO<Devoir> {
    public int taille;
    public ArrayList<Integer> ID_Devoir= new ArrayList<>();

    /**
     * <b>Constructeur par defaut</b>
     */
    public DevoirDAO() {
        super();
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS taille FROM Devoir");
            result.first();
            this.taille = result.getInt("taille");

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir");
            while(result.next())
                ID_Devoir.add(result.getInt("ID_Devoir"));

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode d'ajout d'un devoir dans la table Devoir</b>
     * @param newDevoir variable de type Devoir contenant les informations du nouveaux devoir
     * @param ID_DetailBulletin ID du detailbulletin auquel le devoir sera lie
     */
    public void ajoutDevoir(Devoir newDevoir, int ID_DetailBulletin) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("INSERT INTO Devoir (ID_DetailBulletin, Note, Appreciation_Devoir)" +
                    "VALUES (" + ID_DetailBulletin + ", " + newDevoir.getNote() + ", '" + newDevoir.getAppreciation_evaluation() + "')");

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE DetailBulletin SET Moyenne_Enseignement = (SELECT AVG(Note)FROM Devoir WHERE ID_DetailBulletin = " + ID_DetailBulletin + ") " +
                    "WHERE ID_DetailBulletin = " + ID_DetailBulletin);

            ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT ID_Bulletin AS ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin);
            result2.first();
            int ID_Bulletin = result2.getInt("ID_Bulletin");

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Bulletin SET Moyenne_Trimestre = (SELECT AVG(Moyenne_Enseignement)FROM DetailBulletin WHERE ID_Bulletin = " + ID_Bulletin + ") " +
                    "WHERE ID_Bulletin = (SELECT ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin + ")");

            this.connect.close();
            result.close();
            result2.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de suppresion d'un devoir de la table Devoir</b>
     * @param ID_Devoir ID de devoir a supprimer dans la table Devoir
     */
    public void suppressionDevoir(int ID_Devoir) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT ID_DetailBulletin AS ID_DetailBulletin FROM Devoir WHERE ID_Devoir = " + ID_Devoir);
            result2.first();
            int ID_DetailBulletin = result2.getInt("ID_DetailBulletin");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("DELETE FROM Devoir WHERE ID_Devoir = " + ID_Devoir);

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE DetailBulletin SET Moyenne_Enseignement = (SELECT AVG(Note)FROM Devoir WHERE ID_DetailBulletin = " + ID_DetailBulletin + ") " +
                    "WHERE ID_DetailBulletin = " + ID_DetailBulletin);

            result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT ID_Bulletin AS ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin);
            result2.first();
            int ID_Bulletin = result2.getInt("ID_Bulletin");

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Bulletin SET Moyenne_Trimestre = (SELECT AVG(Moyenne_Enseignement)FROM DetailBulletin WHERE ID_Bulletin = " + ID_Bulletin + ") " +
                    "WHERE ID_Bulletin = (SELECT ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin + ")");

            this.connect.close();
            result.close();
            result2.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un devoir</b>
     * @param updateDevoir Objet de type Devoir contenant les informations a maj
     */
    public void update(Devoir updateDevoir) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Devoir SET Note = " + updateDevoir.getNote() + " WHERE ID_Devoir = " + updateDevoir.getId_devoir());

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Devoir SET Appreciation_Devoir = " + updateDevoir.getAppreciation_evaluation() + " WHERE ID_Devoir = " + updateDevoir.getId_devoir());

            ResultSet result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT ID_DetailBulletin AS ID_DetailBulletin FROM Devoir WHERE ID_Devoir = " + updateDevoir.getId_devoir());
            result2.first();
            int ID_DetailBulletin = result2.getInt("ID_DetailBulletin");

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE DetailBulletin SET Moyenne_Enseignement = (SELECT AVG(Note)FROM Devoir WHERE ID_DetailBulletin = " + ID_DetailBulletin + ") " +
                    "WHERE ID_DetailBulletin = " + ID_DetailBulletin);

            result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT ID_Bulletin AS ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin);
            result2.first();
            int ID_Bulletin = result2.getInt("ID_Bulletin");

            result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Bulletin SET Moyenne_Trimestre = (SELECT AVG(Moyenne_Enseignement)FROM DetailBulletin WHERE ID_Bulletin = " + ID_Bulletin + ") " +
                    "WHERE ID_Bulletin = (SELECT ID_Bulletin FROM DetailBulletin WHERE ID_DetailBulletin = " + ID_DetailBulletin + ")");

            this.connect.close();
            result.close();
            result2.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode permettant de recuperer les informations d'un devoir dans la table et de retourner un objet de type Devoir</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type Devoir
     */
    @Override
    public Devoir Connection(int id) {
        Devoir Devoir = new Devoir();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir WHERE ID_Devoir =" + id);
            if (result.first())
                Devoir = new Devoir(result.getInt("ID_Devoir"),
                        result.getInt("Note"),
                        result.getString("Appreciation_Devoir")
                );

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Devoir;
    }

}