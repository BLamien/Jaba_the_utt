package DAO;

import Model.Bulletin;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends com.sdz.dao.DAO<Personne> {
    public EleveDAO() {
        super();
    }

    public boolean create(Personne newEleve) {
        return false;
    }

    public boolean delete(Personne obj) {
        return false;
    }

    public boolean update(Personne obj) {
        return false;
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Personne;
    }

}