package DAO;

import Model.AnneeScolaire;
import Model.Trimestre;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO AnneeScolaire permettant d'acceder a la bdd de AnneeScolaire</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class AnneeScolaireDAO extends com.sdz.dao.DAO<AnneeScolaire> {
    /**
     * <b>COnstructeur par defaut appellant celui de la classe mère</b>
     */
    public AnneeScolaireDAO() {
        super();
    }

    /**
     * <b>Methode de maj d'objet</b>
     * @param obj objet que l'on va modifier dans la BDD
     */
    public void update(AnneeScolaire obj) {

    }

    /**
     * <b>Methode de recuperation des informations sur la BDD pour les attribuer a des variables objets</b>
     * @param id id de l'element a charger depuis la bdd
     * @return variable objet de type AnneeScolaire
     */
    @Override
    public AnneeScolaire Connection(int id) {
        AnneeScolaire AnneeScolaire = new AnneeScolaire();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");


            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM AnneeScolaire WHERE ID_AnneeScolaire ="+id);
            if(result.first())
                AnneeScolaire = new AnneeScolaire(result.getInt("ID_AnneeScolaire"));

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Trimestre WHERE ID_AnneeScolaire =" + AnneeScolaire.getId_anneescolaire()+" AND Numero = 1");
            if (result.first()) {
                com.sdz.dao.DAO<Trimestre> trimestreDAO = new TrimestreDAO();
                AnneeScolaire.setTrimestre1(trimestreDAO.Connection(result.getInt("ID_Trimestre")));
            }

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Trimestre WHERE ID_AnneeScolaire =" + AnneeScolaire.getId_anneescolaire()+" AND Numero = 2");
            if (result.first()) {
                com.sdz.dao.DAO<Trimestre> trimestreDAO = new TrimestreDAO();
                AnneeScolaire.setTrimestre2(trimestreDAO.Connection(result.getInt("ID_Trimestre")));
            }

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Trimestre WHERE ID_AnneeScolaire =" + AnneeScolaire.getId_anneescolaire()+" AND Numero = 3");
            if (result.first()) {
                com.sdz.dao.DAO<Trimestre> trimestreDAO = new TrimestreDAO();
                AnneeScolaire.setTrimestre3(trimestreDAO.Connection(result.getInt("ID_Trimestre")));
            }
            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return AnneeScolaire;
    }

}