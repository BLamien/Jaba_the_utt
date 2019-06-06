package DAO;

import Model.AnneeScolaire;
import Model.Classe;
import Model.Ecole;
import Model.Personne;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//CTRL + SHIFT + O pour générer les imports
public class ClasseDAO extends com.sdz.dao.DAO<Classe> {
    public ClasseDAO() {
        super();
    }

    public boolean create(Classe obj) {
        return false;
    }

    public boolean delete(Classe obj) {
        return false;
    }

    public boolean update(Classe obj) {
        return false;
    }

    @Override
    public Classe Connection(int id) throws SQLException {
        Classe Classe = new Classe();

        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/Classe";

            //création d'une connexion JDBC à la base
            this.connect = DriverManager.getConnection(urlDatabase, "root", "");

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE ID_Classe =" + id);
            if (result.first())
                Classe = new Classe(result.getInt("ID_Classe"),
                        result.getString("Niveau")
                );

            result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Eleve WHERE ID_Classe =" + Classe.getId_classe());
            if (result.next()) {
                Classe.get_effectif().add(new Personne(result.getInt("ID_Eleve"),
                        "eleve",
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Login"),
                        result.getString("Mdp"))
                );

                result = this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE ID_Classe =" + Classe.getId_classe());
                if (result.first()) {
                    com.sdz.dao.DAO<AnneeScolaire> anneeScolaireDAO = new AnneeScolaireDAO();
                    Classe.setAnneeScolaire(anneeScolaireDAO.Connection(result.getInt("ID_AnneeScolaire")));
                }

                result = this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE ID_Classe =" + Classe.getId_classe());
                if (result.first()) {
                    com.sdz.dao.DAO<Ecole> ecoleDAO = new EcoleDAO();
                    Classe.set_ecole(ecoleDAO.Connection(result.getInt("ID_Ecole")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Classe;
    }

}