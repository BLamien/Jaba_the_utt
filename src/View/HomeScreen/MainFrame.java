package View.HomeScreen;

import Controller.HeaderViewController;
import Model.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    //Attributs
    private HeaderViewController header = new HeaderViewController(new Header());
    private ModelTable modele = new ModelTable();
    private JTable tableau;

    //Constructor
    public MainFrame() {
        init();
        setVisible(true);
    }

    private void init() {
        // initialisation header
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);
        JPanel h = header.getHeader();
        h.setSize(widthSize,heightSize/3);
        contentPane.add(h, BorderLayout.NORTH);

        //initiation de la table
        tableau = new JTable(modele);
        contentPane.add(new JScrollPane(tableau), BorderLayout.CENTER);

        //bouton en bas
        JPanel boutons = new JPanel();
        JButton add = new JButton("Ajouter");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.addPersonne(new Personne(233, "ajout", "d'un", "nouvel", "ami"));
            }
        });
        JButton remove = new JButton("Supprimer");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(View.Popup.check("Etes-vous sur de vouloir supprimer cette personne ?")){
                    int[] selection = tableau.getSelectedRows();
                    for(int i = selection.length - 1; i >= 0; i--){
                        modele.removePersonne(selection[i]);
                    }
                }
            }
        });
        boutons.add(add);
        boutons.add(remove);
        contentPane.add(boutons, BorderLayout.SOUTH);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("JABA");
    }

    public void CheckActionPopup (){

    }

    //Getters & Setters
    public static Dimension getWindowDimension() {
        return windowDimension;
    }
    public static int getWidthSize() {
        return widthSize;
    }
    public static int getHeightSize() {
        return heightSize;
    }
    public HeaderViewController getHeader() {
        return header;
    }
    public void setHeader(HeaderViewController header) {
        this.header = header;
    }
}
