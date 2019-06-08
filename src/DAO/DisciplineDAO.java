package DAO;

import Model.Discipline;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class DisciplineDAO extends com.sdz.dao.DAO<Discipline> {
    public DisciplineDAO() {
        super();
    }

    public void create(Discipline obj) {

    }

    public void delete(Discipline obj) {

    }

    public void update(Discipline obj) {

    }

    @Override
    public Discipline Connection(int id) {
        Discipline Discipline = new Discipline();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Discipline WHERE ID_Discipline ="+id);
            if(result.first())
                Discipline = new Discipline(result.getInt("ID_Discipline"),
                        result.getString("Nom_Discipline")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Discipline;
    }

}