package DAO;

import Model.DetailBulletin;
import Model.Devoir;
import Model.Enseignement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

//CTRL + SHIFT + O pour générer les imports
public class DetailBulletinDAO extends com.sdz.dao.DAO<DetailBulletin> {
    public DetailBulletinDAO() {
        super();
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

    @Override
    public DetailBulletin Connection(int id) {
        DetailBulletin DetailBulletin = new DetailBulletin();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");


            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_DetailBulletin ="+id);
            if(result.first())
                DetailBulletin = new DetailBulletin(result.getInt("ID_DetailBulletin"),
                        result.getFloat("Moyenne_Enseignement"),
                        result.getString("Appreciation_DetailBulletin")
                );

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Devoir WHERE ID_DetailBulletin ="+DetailBulletin.getId_detailBulletin() );
            if (result.next()) {
                com.sdz.dao.DAO<Devoir> devoirDAO = new DevoirDAO();
                DetailBulletin.getNotes().add(devoirDAO.Connection(result.getInt("ID_Devoir")));
            }

            ResultSet tamp = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE ID_DetailBulletin =" + DetailBulletin.getId_detailBulletin());
            tamp.first();
            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE ID_Enseignement ="+tamp.getInt("ID_Enseignement"));
            if (result.first()) {
                com.sdz.dao.DAO<Enseignement> enseignementDAO = new EnseignementDAO();
                DetailBulletin.set_matiere(enseignementDAO.Connection(result.getInt("ID_Enseignement")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DetailBulletin;
    }

}