package DAO;

import Model.Enseignement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class EnseignementDAO extends com.sdz.dao.DAO<Enseignement> {
    public EnseignementDAO() {
        super();
    }

    public boolean create(Enseignement obj) {
        return false;
    }

    public boolean delete(Enseignement obj) {
        return false;
    }

    public boolean update(Enseignement obj) {
        return false;
    }

    @Override
    public Enseignement Connection(int id) {
        Enseignement Enseignement = new Enseignement();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Enseignement";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE Login ="+id);
            if(result.first())
                Enseignement = new Enseignement(result.getInt("ID_Enseignement")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Enseignement;
    }

}