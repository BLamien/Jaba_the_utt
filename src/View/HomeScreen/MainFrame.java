package View.HomeScreen;
//TODO : JavaDoc
import Controller.HeaderViewController;

import Constants.Colors;
import Model.Personne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    //Attributs
    //private HeaderViewController header = new HeaderViewController(new Header());
    private HeaderV2 header = new HeaderV2();
    private ModelTable modele = new ModelTable();
    private JTable tableau;
    private ChoixStats stats = new ChoixStats();
    private JScrollPane tabs;
    private JPanel boutons;

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
        header.setSize(widthSize,heightSize/3);
        contentPane.add(header, BorderLayout.NORTH);

        //initiation de la table
        tableau = new JTable(modele);
        JScrollPane tabs = new JScrollPane(tableau);
        tabs.setBorder(new EmptyBorder(100,300,100,300));
        tabs.setBackground(Colors.green);
        contentPane.add(tabs, BorderLayout.CENTER);

        //bouton en bas
        JPanel boutons = new JPanel();
        JButton add = new JButton("Ajouter");
        add.addActionListener(this);
        JButton remove = new JButton("Supprimer");
        remove.addActionListener(this);
        boutons.add(add);
        boutons.add(remove);
        contentPane.add(boutons, BorderLayout.SOUTH);

        header.getStats().addActionListener(this);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("JABA");
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
    public HeaderV2 getHeader() {
        return header;
    }
    public void setHeader(HeaderV2 header) {
        this.header = header;
    }
    public JTable getTableau() {
        return tableau;
    }
    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Supprimer")){
            if(View.Popup.check("Etes-vous sur de vouloir supprimer cette personne ?")){
                int[] selection = tableau.getSelectedRows();
                for(int i = selection.length - 1; i >= 0; i--){
                    modele.removePersonne(selection[i]);
                }
            }
        }
        if(button.getText().equals("Ajouter")){
            AjoutPersonne ap = new AjoutPersonne(modele);
            getContentPane().revalidate();
        }
        if(button.getText().equals("Statistiques")){
            getContentPane().remove(tabs);
            getContentPane().remove(boutons);
            getContentPane().add(stats,BorderLayout.CENTER);
            getContentPane().repaint();
        }


    }


    //Getter & Setter
    public ModelTable getModele() {
        return modele;
    }
    public void setModele(ModelTable modele) {
        this.modele = modele;
    }
    public ChoixStats getStats() {
        return stats;
    }
    public void setStats(ChoixStats stats) {
        this.stats = stats;
    }
    public JScrollPane getTabs() {
        return tabs;
    }
    public void setTabs(JScrollPane tabs) {
        this.tabs = tabs;
    }
}
