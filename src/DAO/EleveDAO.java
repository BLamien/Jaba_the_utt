package DAO;

import Model.Bulletin;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends com.sdz.dao.DAO<Personne> {
    public int taille;

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

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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