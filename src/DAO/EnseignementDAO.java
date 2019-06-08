package DAO;

import Model.Classe;
import Model.Discipline;
import Model.Enseignement;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Constants.ConstConnexion.urlDatabase;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Enseignement;
    }

}