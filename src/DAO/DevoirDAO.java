package DAO;

import Model.Devoir;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class DevoirDAO extends com.sdz.dao.DAO<Devoir> {
    public DevoirDAO() {
        super();
    }

    public void create(Devoir newDevoir) {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Devoir obj) {

    }

    public void update(Devoir obj) {

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir WHERE ID_Devoir ="+id);
            if(result.first())
                Devoir = new Devoir(result.getInt("ID_Devoir"),
                        result.getInt("Note"),
                        result.getString("Appreciation_Devoir")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Devoir;
    }

}