package DAO;

import Model.Discipline;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Discipline permettant d'acceder aux informations de la table Discipline</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class DisciplineDAO extends com.sdz.dao.DAO<Discipline> {
    /**
     * <b>Constructeur par defaut</b>
     */
    public DisciplineDAO() {
        super();
    }

    /**
     * <b>Methode de maj d'une discipline</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Discipline obj) {

    }

    /**
     * <b>Methode permettant de recuperer les informations d'une discipline et de retourner un objet de type discipline</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type discipline
     */
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

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Discipline;
    }

}