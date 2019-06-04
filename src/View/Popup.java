package View;

import Model.Personne;

import javax.swing.*;

/**
 * <b>Classe qui organise l'utilisation de Popup</b>
 * @author Leonard
 * @version 1.0
 */
public class Popup
{

    /**
     * Methode qui lance l'affichage d'une infobox
     * @param infoMessage String : le message que l'on souhaite afficher
     * @param titleBar String : le nom que l'on souhaite donner à notre fenetre Popup
     */
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Methode qui lance l'affichage d'une popup qui demande à l'utilisateur de saisir une informations
     * @param message Message que l'on veut demander à l'utilisateur
     * @param title Titre que l'on souhaite donner à notre fenetre Popup
     * @return retourne le String qu'a rentré l'utilisateur
     */
    public static String ask(String message, String title) {
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom = jop.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        return nom;
    }

    /**
     * Methode qui lance l'affichage d'une fenetre qui demande à l'utilisateur si il est bien sur de ce qu'il s'apprete à faire
     * @param question Question que l'on va poser à l'utilisateur
     * @return la réponse de lutilisateur OUI ou NON / TRUE ou FALSE
     */
    public static Boolean check(String question){
        int choice = JOptionPane.showOptionDialog(null,
                question,
                "What to do ?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        if (choice == JOptionPane.YES_OPTION)
        {
            return true;
        }else{
            return false;
        }
    }

}
