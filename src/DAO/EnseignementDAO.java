package DAO;

import Model.Classe;
import Model.Discipline;
import Model.Enseignement;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

/**
 * <b>DAO Enseignement permettant d'acceder aux informations de la table Enseignement</b>
 * @author Thomas
 * @version 1.0
 */

//CTRL + SHIFT + O pour générer les imports
public class EnseignementDAO extends com.sdz.dao.DAO<Enseignement> {
    public int taille;

    /**
     * <b>Constructeur par defaut</b>
     */
    public EnseignementDAO() {
        super();
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) AS taille FROM Enseignement");
            result.first();
            this.taille = result.getInt("taille");

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>Methode de maj d'un Enseignement</b>
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public void update(Enseignement obj) {

    }

    /**
     * <b>Methode permettant de recuperer les informations d'un enseignement et de retourner un objet de type Enseignement</b>
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return objet de type Enseignement
     */
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

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE ID_Enseignement ="+id);
            if(result.first())
                Enseignement = new Enseignement(result.getInt("ID_Enseignement")
                );

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE ID_Enseignement ="+Enseignement.getId_enseignement());
            if (result.first()) {
                com.sdz.dao.DAO<Discipline> disciplineDAO = new DisciplineDAO();
                Enseignement.set_discipline(disciplineDAO.Connection(result.getInt("ID_Discipline")));

                com.sdz.dao.DAO<Personne> enseignantDAO = new EnseignantDAO();
                Enseignement.set_enseignant(enseignantDAO.Connection(result.getInt("ID_Enseignant")));

                com.sdz.dao.DAO<Classe> classeDAO = new ClasseDAO();
                Enseignement.set_classe(classeDAO.Connection(result.getInt("ID_Classe")));
            }

            this.connect.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Enseignement;
    }

}