package DAO;

import Model.Bulletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class BulletinDAO extends com.sdz.dao.DAO<Bulletin> {
    public BulletinDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Bulletin obj) {
        return false;
    }

    public boolean delete(Bulletin obj) {
        return false;
    }

    public boolean update(Bulletin obj) {
        return false;
    }

    @Override
    public Bulletin Connection(int id) {
        Bulletin Bulletin = new Bulletin();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Bulletin";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE Login ="+id);
            if(result.first())
                Bulletin = new Bulletin(result.getInt("ID_Bulletin"),
                        result.getFloat("Moyenne_Trimestre"),
                        result.getString("Appreciation_Bulletin")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Bulletin;
    }


}