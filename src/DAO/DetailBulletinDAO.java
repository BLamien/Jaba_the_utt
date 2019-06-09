package DAO;

import Model.DetailBulletin;
import Model.Devoir;
import Model.Enseignement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO DetailleBulletin permettant d'acceder a la table DetailBulletin</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class DetailBulletinDAO extends com.sdz.dao.DAO<DetailBulletin> {
    /**
     * <b>Constructeur par defaut</b>
     */
    public DetailBulletinDAO() {
        super();
    }

    /**
     * <b>Methode d'ajout d'un detailbulletin dans un bulletin</b>
     * @param ID_Bulletin ID du bulletin auquel sera lie le detailbulletin
     */
    public void ajouterDetailBulletin(int ID_Bulletin) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve HAVING ID_Eleve = (SELECT MAX(ID_Eleve) FROM Eleve)");
            result2.first();
            ResultSet result3 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE ID_Classe = " + result2.getInt("ID_Classe"));
            while (result3.next())
                result.executeUpdate("INSERT INTO DetailBulletin (Moyenne_Enseignement, ID_Bulletin, ID_Enseignement, Appreciation_DetailBulletin)" +
                        "VALUES (0," + ID_Bulletin + "," + result3.getInt("ID_Enseignement") + ", '')");

            this.connect.close();
            result.close();
            result2.close();
            result3.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un detail bulletin</b>
     * @param updateDetailBulletin Objet detailbulletin contenant les information a maj
     */
    public void update(DetailBulletin updateDetailBulletin) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE DetailBulletin SET Note = " + updateDetailBulletin.getAppreciation_detailBulletin() +
                    " WHERE ID_DetailBulletin = " + updateDetailBulletin.getId_detailBulletin());

            this.connect.close();
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode permettant de recuperer les informations d'un detail bulletin et de retourner un objet de type DetailBulletin</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type DetailBulletin
     */
    @Override
    public DetailBulletin Connection(int id) {
        DetailBulletin DetailBulletin = new DetailBulletin();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_DetailBulletin =" + id);
            if (result.first())
                DetailBulletin = new DetailBulletin(result.getInt("ID_DetailBulletin"),
                        result.getFloat("Moyenne_Enseignement"),
                        result.getString("Appreciation_DetailBulletin")
                );

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir WHERE ID_DetailBulletin =" + DetailBulletin.getId_detailBulletin());
            while (result.next()) {
                com.sdz.dao.DAO<Devoir> devoirDAO = new DevoirDAO();
                DetailBulletin.getNotes().add(devoirDAO.Connection(result.getInt("ID_Devoir")));
            }

            ResultSet tamp = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_DetailBulletin =" + DetailBulletin.getId_detailBulletin());
            tamp.first();
            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE ID_Enseignement =" + tamp.getInt("ID_Enseignement"));
            if (result.first()) {
                com.sdz.dao.DAO<Enseignement> enseignementDAO = new EnseignementDAO();
                DetailBulletin.set_matiere(enseignementDAO.Connection(result.getInt("ID_Enseignement")));
            }

            this.connect.close();
            result.close();
            tamp.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DetailBulletin;
    }

}