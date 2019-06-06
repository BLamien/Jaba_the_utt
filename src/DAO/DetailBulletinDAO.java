package DAO

import Model.DetailBulletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class DetailBulletinDAO extends com.sdz.dao.DAO<DetailBulletin> {
    public DetailBulletinDAO(Connection conn) {
        super(conn);
    }

    public boolean create(DetailBulletin obj) {
        return false;
    }

    public boolean delete(DetailBulletin obj) {
        return false;
    }

    public boolean update(DetailBulletin obj) {
        return false;
    }

    public DetailBulletin connection(int id) {
        DetailBulletin DetailBulletin = new DetailBulletin();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/DetailBulletin";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE Login ="+id);
            if(result.first())
                DetailBulletin = new DetailBulletin(result.getInt("ID_DetailBulletin"),
                        result.getFloat("Moyenne_Enseignement"),
                        result.getString("Appreciation_DetailBulletin")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DetailBulletin;
    }
}