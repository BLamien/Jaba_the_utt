package DAO

import Model.Devoir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class DevoirDAO extends com.sdz.dao.DAO<Devoir> {
    public DevoirDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Devoir obj) {
        return false;
    }

    public boolean delete(Devoir obj) {
        return false;
    }

    public boolean update(Devoir obj) {
        return false;
    }

    public Devoir connection(int id) {
        Devoir Devoir = new Devoir();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Devoir";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir WHERE Login ="+id);
            if(result.first())
                Devoir = new Devoir(result.getInt("ID_Devoir"),
                        result.getInt("Note"),
                        result.getString("Appreciation_Devoir")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Devoir;
    }
}