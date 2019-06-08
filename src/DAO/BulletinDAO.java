package DAO;

import Model.Bulletin;
import Model.DetailBulletin;
import Model.Trimestre;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class BulletinDAO extends com.sdz.dao.DAO<Bulletin> {
    public BulletinDAO() {
        super();
    }

    public void create(Bulletin obj) {

    }

    public void delete(Bulletin obj) {

    }

    public void update(Bulletin obj) {

    }

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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE ID_Bulletin ="+id);
            if(result.first())
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_Bulletin ="+Bulletin.getId_bulletin() );
            while (result.next()) {
                com.sdz.dao.DAO<DetailBulletin> detailBulletinDAO = new DetailBulletinDAO();
                Bulletin.getMatieres().add(detailBulletinDAO.Connection(result.getInt("ID_DetailBulletin")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Bulletin;
    }


}