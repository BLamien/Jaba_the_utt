package View.HomeScreen;
//TODO : JavaDoc

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <b>Jframe principal de la fenetre principal de l'application</b>
 * @author Leonard
 * @version 1.0
 */
public class MainFrame extends JFrame implements ActionListener {
    //Constantes
    public static final Dimension windowDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int widthSize = (int) windowDimension.getWidth();
    public static final int heightSize = (int) windowDimension.getHeight();

    //Attributs
    private HeaderV2 header = new HeaderV2();
    private ModelTable modele = new ModelTable();
    private JTable tableau;
    private ChoixStats stats = new ChoixStats();
    private JScrollPane tabs;
    private JPanel boutons;

    /**
     * <b>Constructeur par defaut</b>
     */
    public MainFrame() {
        init();
        setVisible(true);
    }

    /**
     * <b>Methode d'initialisation des composants</b>
     */
    private void init() {
        // initialisation header
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.GRAY);
        header.setSize(widthSize,heightSize/3);
        contentPane.add(header, BorderLayout.NORTH);

        //initiation de la table
        tableau = new JTable(modele);
        tabs = new JScrollPane(tableau);
        tabs.setBorder(new EmptyBorder(100,300,100,300));
        tabs.setBackground(Colors.green);
        tabs.addMouseListener( new MouseAdapter() {
            public void mouseClicked (MouseEvent e)  {
                if (e.getClickCount() == 2) {
                    // Do something
                }
            }
        } );
        contentPane.add(tabs, BorderLayout.CENTER);

        //bouton en bas
        boutons = new JPanel();
        JButton add = new JButton("Ajouter");
        add.addActionListener(this);
        JButton remove = new JButton("Supprimer");
        remove.addActionListener(this);
        boutons.add(add);
        boutons.add(remove);
        boutons.setBackground(Colors.gris);
        contentPane.add(boutons, BorderLayout.SOUTH);

        header.getStats().addActionListener(this);
        header.getMenu().addActionListener(this);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("JABA");
    }

    /**
     * Methode qui gere les actions des boutons lorsqu'on leurs clique dessus
     * @param e evenement lorsque l'on clique sur un des boutons
     */
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
            getContentPane().invalidate();
            getContentPane().remove(tabs);
            getContentPane().remove(boutons);
            getContentPane().add(stats,BorderLayout.CENTER);
            getContentPane().revalidate();
        }
        if(button.getText().equals("Menu")){
            getContentPane().invalidate();
            getContentPane().remove(stats);
            stats.setVisible(false);
            getContentPane().add(tabs,BorderLayout.CENTER);
            getContentPane().add(boutons,BorderLayout.SOUTH);
            getContentPane().revalidate();
        }


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
