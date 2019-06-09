package DAO;

import Model.Bulletin;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Eleve permettant d'acceder aux informations de la table Eleve</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends com.sdz.dao.DAO<Personne> {
    public int taille;
    public ArrayList<Integer> ID_Eleve;

    /**
     * <b>Constructeur par defaut</b>
     */
    public EleveDAO() {
        super();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS taille FROM Eleve");
            result.first();
            this.taille = result.getInt("taille");

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve");
            while(result.next())
                ID_Eleve.add(result.getInt("ID_Eleve"));

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode d'ajout d'un eleve dans la table Eleve</b>
     * @param newEleve Objet contenant les informations du nouvel eleve
     * @param classenewEleve Nom de la classe du nouvel eleve
     */
    public void ajoutEleve(Personne newEleve, String classenewEleve) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE Niveau = '" + classenewEleve + "'");
            result.first();
            Statement result2 = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result2.executeUpdate("INSERT INTO Eleve (Nom, Prenom, Login, Mdp, ID_Classe)" +
                    "VALUES ('" + newEleve.getNom() + "', " +
                    "'" + newEleve.getPrenom() + "', " +
                    "'" + newEleve.getLogin() + "', " +
                    "'" + newEleve.getMdp() + "', " +
                    "" + result.getInt("ID_Classe") + ")");

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve HAVING ID_Eleve = (SELECT MAX(ID_Eleve) FROM Eleve)");
            if (result.first()) {
                com.sdz.dao.DAO<Bulletin> bulletinDAO = new BulletinDAO();
                ((BulletinDAO) bulletinDAO).ajouterBulletin(result.getInt("ID_Eleve"));
            }

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
     * <b>Methode de suppresion d'un eleve de la table Eleve</b>
     * @param ID_Eleve ID de l'eleve a supprimer
     */
    public void suppressionEleve(int ID_Eleve) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            Statement result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result.executeUpdate("DELETE FROM Eleve WHERE ID_Eleve = " + ID_Eleve);

            this.connect.close();
            result.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un eleve</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Personne obj) {

    }

    /**
     * <b>Methode permettant de récupérer les informations d'un eleve et de retourner un objet de type Personne</b>
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve WHERE ID_Eleve = " + id);
            if (result.first())
                Personne = new Personne(result.getInt("ID_Eleve"),
                        "eleve",
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Login"),
                        result.getString("Mdp")
                );

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE ID_Eleve =" + Personne.getId_personne());
            while (result.next()) {
                com.sdz.dao.DAO<Bulletin> bulletinDAO = new BulletinDAO();
                Personne.getBulletins().add(bulletinDAO.Connection(result.getInt("ID_Bulletin")));
            }

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