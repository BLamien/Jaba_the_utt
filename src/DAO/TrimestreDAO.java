package DAO;

import Model.Trimestre;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Trimestre permettant d'acceder aux informations de la table Trimestre</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class TrimestreDAO extends com.sdz.dao.DAO<Trimestre> {
    /**
     * <b>Constructeur par defaut</b>
     */
    public TrimestreDAO() {
        super();
    }

    /**
     * <b>Methode de maj d'un Trimestre</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Trimestre obj) {

    }

    /**
     * <b>Methode permettant de recuperer les informations d'un trimestre et de retourner un objet de type Trimestre</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type Trimestre
     */
    @Override
    public Trimestre Connection(int id) {
        Trimestre Trimestre = new Trimestre();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Trimestre WHERE ID_Trimestre ="+id);
            if(result.first())
                Trimestre = new Trimestre(result.getInt("ID_Trimestre"),
                        result.getInt("Numero"),
                        result.getDate("Debut_Trimestre"),
                        result.getDate("Fin_Trimestre"),
                        result.getInt("ID_AnneeScolaire")
                );

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Trimestre;
    }

}