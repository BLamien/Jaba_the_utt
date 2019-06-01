package View;

import javax.swing.*;


public class Popup
{

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String ask(String message, String title) {
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom = jop.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        return nom;
    }

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
