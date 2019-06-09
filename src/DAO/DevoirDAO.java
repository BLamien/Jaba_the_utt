package DAO;

import Model.Devoir;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class DevoirDAO extends com.sdz.dao.DAO<Devoir> {
    public DevoirDAO() {
        super();
    }

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

    public void create(Devoir obj) {

    }

    public void delete(Devoir obj) {

    }

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