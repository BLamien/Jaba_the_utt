import DAO.EleveDAO;
import DAO.EnseignantDAO;
import Model.Personne;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //View.Acceuil.AccueilFrame acceuil = new AccueilFrame();


        //Test
        com.sdz.dao.DAO<Personne> eleveDao = new EleveDAO();
        Personne eleve = new Personne();
        for (int i = 1; i <= ((EleveDAO) eleveDao).taille; i++) {
            eleve = eleveDao.Connection(i);
            System.out.println("Elève N°" + eleve.getId_personne() + "\n- " + eleve.getType() + "\n- " + eleve.getNom() + "\n- " + eleve.getPrenom() + "\n- "
                    + eleve.getLogin() + "\n- " + eleve.getMdp());
            //System.out.println(eleve.getBulletins().get(0).getMatieres().get(0).getNotes().get(0).getNote());
        }

        //Test 2
        /*Personne eleve2 = new Personne("eleve", "Cabrel", "Francis", "FrancisCabrel", "couscous4");
        String classeeleve2 = "6emeB";
        com.sdz.dao.DAO<Personne> eleveDao2 = new EleveDAO();
        ((EleveDAO) eleveDao2).ajoutEleve(eleve2, classeeleve2);*/

        //Test 3
        /*com.sdz.dao.DAO<Personne> eleveDao3 = new EleveDAO();
        ((EleveDAO) eleveDao3).suppressionEleve(5);*/

        //Test 4
        /*com.sdz.dao.DAO<Devoir> devoirDao = new DevoirDAO();
        Devoir devoir = new Devoir(16, "Tres Bien");
        ((DevoirDAO) devoirDao).ajoutDevoir(devoir, 4);*/

        //Test 5
        /*com.sdz.dao.DAO<Devoir> devoirDao2 = new DevoirDAO();
        ((DevoirDAO) devoirDao2).suppressionDevoir(10);*/

        //Test 6
        com.sdz.dao.DAO<Personne> enseignantDao = new EnseignantDAO();
        Personne enseignant = new Personne();
        for (int i = 1; i <= ((EnseignantDAO) enseignantDao).taille; i++) {
            enseignant = enseignantDao.Connection(i);
            System.out.println("Prof N°" + enseignant.getId_personne() + "\n- " + enseignant.getType() + "\n- " + enseignant.getNom() + "\n- " + enseignant.getPrenom() + "\n- "
                    + enseignant.getLogin() + "\n- " + enseignant.getMdp());
        }
    }
}
