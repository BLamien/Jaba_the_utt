package DAO;

import Model.Bulletin;
import Model.DetailBulletin;
import Model.Trimestre;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Bulletin permettant d'accéder a la bdd de Bulletin</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class BulletinDAO extends com.sdz.dao.DAO<Bulletin> {
    /**
     * <b>COnstructeur par defaut appellant celui de la classe mère</b>
     */
    public BulletinDAO() {
        super();
    }

    /**
     * <b>Methode d'ajout d'un bulletin dans la bdd</b>
     * @param ID_Eleve valeur de l'ID_Eleve a qui attribuer le bulletin
     */
    public void ajouterBulletin(int ID_Eleve) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet taille = null;
            ResultSet result2 = null;
            for (int i = 1; i <= 3; i++) {
                result.executeUpdate("INSERT INTO Bulletin (Moyenne_Trimestre, ID_Trimestre, ID_Eleve, Appreciation_Bulletin)" +
                        "VALUES (0," + i + "," + ID_Eleve + ", '')");

                taille = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Discipline");
                result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                        .executeQuery("SELECT * FROM Bulletin HAVING ID_Bulletin = (SELECT MAX(ID_Bulletin) FROM Bulletin)");
                result2.first();
                while (taille.next()) {
                    com.sdz.dao.DAO<DetailBulletin> detailBulletinDAO = new DetailBulletinDAO();
                    ((DetailBulletinDAO) detailBulletinDAO).ajouterDetailBulletin(result2.getInt("ID_Bulletin"));
                }
            }

            this.connect.close();
            result.close();
            result2.close();
            taille.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un bulletin</b>
     * @param updateBulletin Bulletin contenant les information a maj
     */
    public void update(Bulletin updateBulletin) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("UPDATE Bulletin SET Appreciation_Bulletin = " + updateBulletin.getAppreciation_bulletin() +
                    " WHERE ID_Bulletin = " + updateBulletin.getId_bulletin());

            this.connect.close();
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode permettant de recuperer les donnees des bulletins depuis la bdd et retourner une variable objet de type bulletin</b>
     * @param id ID permettant de choisir depuis la bdd quel bulletin retourner
     * @return Objet de type bulletin
     */
    @Override
    public Bulletin Connection(int id) {
        Bulletin Bulletin = new Bulletin();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");


            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE ID_Bulletin =" + id);
            if (result.first())
                Bulletin = new Bulletin(result.getInt("ID_Bulletin"),
                        result.getFloat("Moyenne_Trimestre"),
                        result.getString("Appreciation_Bulletin")
                );

            ResultSet tamp = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE ID_Bulletin =" + Bulletin.getId_bulletin());
            tamp.first();
            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Trimestre WHERE ID_Trimestre =" + tamp.getInt("ID_Trimestre"));
            if (result.first()) {
                com.sdz.dao.DAO<Trimestre> trimestreDAO = new TrimestreDAO();
                Bulletin.set_trimestre(trimestreDAO.Connection(result.getInt("ID_Trimestre")));
            }

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_Bulletin =" + Bulletin.getId_bulletin());
            while (result.next()) {
                com.sdz.dao.DAO<DetailBulletin> detailBulletinDAO = new DetailBulletinDAO();
                Bulletin.getMatieres().add(detailBulletinDAO.Connection(result.getInt("ID_DetailBulletin")));
            }

            this.connect.close();
            result.close();
            tamp.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Bulletin;
    }


}