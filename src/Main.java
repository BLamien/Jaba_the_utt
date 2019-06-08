import DAO.EleveDAO;
import Model.Personne;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //View.Acceuil.AccueilFrame acceuil = new AccueilFrame();

       //Test
        com.sdz.dao.DAO<Personne> eleveDao = new EleveDAO();
        Personne eleve = new Personne();
        for(int i = 1; i <= 3; i++){
             eleve = eleveDao.Connection(i);
            System.out.println("Elève N°" + eleve.getId_personne() +"\n- " + eleve.getType()+ "\n- " + eleve.getNom() + "\n- " + eleve.getPrenom()+"\n- "
                    + eleve.getLogin()+"\n- " + eleve.getMdp());
            //System.out.println(eleve.getBulletins().get(0).getMatieres().get(0).getNotes().get(0).getDiscipline());
        }

        //Test 2
        Personne eleve2 = new Personne("eleve", "Cabrel", "Francis", "FrancisCabrel", "couscous4");
        String classeeleve2 = "6emeB";
        com.sdz.dao.DAO<Personne> eleveDao2 = new EleveDAO();
        ((EleveDAO) eleveDao2).ajoutEleve(eleve2, classeeleve2);

        /*com.sdz.dao.DAO<Personne> eleveDao1 = new EleveDAO();
        Personne eleve1 = eleveDao1.Connection(0);
        System.out.println("Elève N°" + eleve1.getId_personne() + "\n- " + eleve1.getType() + "\n- " + eleve1.getNom() + "\n- " + eleve1.getPrenom() + "\n- "
                + eleve1.getLogin() + "\n- " + eleve1.getMdp());
        com.sdz.dao.DAO<Personne> eleveDao2 = new EleveDAO();
        Personne eleve2 = eleveDao2.Connection(1);
        System.out.println("Elève N°" + eleve2.getId_personne() + "\n- " + eleve2.getType() + "\n- " + eleve2.getNom() + "\n- " + eleve2.getPrenom() + "\n- "
                + eleve2.getLogin() + "\n- " + eleve2.getMdp());
        com.sdz.dao.DAO<Personne> eleveDao3 = new EleveDAO();
        Personne eleve3 = eleveDao3.Connection(2);
        System.out.println("Elève N°" + eleve3.getId_personne() + "\n- " + eleve3.getType() + "\n- " + eleve3.getNom() + "\n- " + eleve3.getPrenom() + "\n- "
                + eleve3.getLogin() + "\n- " + eleve3.getMdp());*/
    }
}
