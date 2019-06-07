package View.HomeScreen;
//TODO : JavaDoc

import Constants.Colors;
import Model.Devoir;
import Model.Personne;
import View.Bulletin.BulletinFrame;
import View.HomeScreen.ModelsTable.ModelTableClasse;
import View.HomeScreen.ModelsTable.ModelTableDevoir;
import View.HomeScreen.ModelsTable.ModelTableEnseignement;
import View.HomeScreen.ModelsTable.ModelTablePersonne;
import View.Statistique.ChoixStats;
import View.Statistique.StatsFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private ModelTablePersonne modelePersonne;
    private ModelTableDevoir modeleDevoir;
    private ModelTableClasse modelClasse;
    private ModelTableEnseignement modelEnseignement;
    private JTable tableauPersonne;
    private JTable tableauDevoir;
    private JTable tableauClasse;
    private JTable tableauEnseignement;
    private ChoixStats stats = new ChoixStats();
    private JScrollPane tabPersonne;
    private JScrollPane tabDevoir;
    private JScrollPane tabClasse;
    private JScrollPane tabEnseignement;
    private JScrollPane actualScrollPane;
    private JPanel boutons;

    /**
     * <b>Constructeur par defaut</b>
     */
    public MainFrame() {
        initComponent();
        init();
        setVisible(true);
    }

    private void initComponent() {
        ArrayList<Personne> personnes = new ArrayList<Personne>();
        personnes.add(new Personne(12,"eleves" ,"dev","leo","lifao", "cacacac"));
        personnes.add(new Personne(1,"eleves" ,"huh","t","truc", "fzef"));
        personnes.add(new Personne(22,"eleves" ,"kjl","thibault","bidule", "fe"));
        personnes.add(new Personne(32,"eleves" ,"nlhl","xav","chouette", "cacactjqhac"));
        personnes.add(new Personne(10,"eleves" ,"nljhln","antoine","madk", "htqhw"));
        personnes.add(new Personne(13,"eleves" ,"kjpmih","paul","lifdsfao", "gqe"));
        personnes.add(new Personne(8,"eleves" ,"jnlkij","jb","fzfe", "gqrge"));
        modelePersonne = new ModelTablePersonne(personnes);

        ArrayList<Devoir> devoirs = new ArrayList<Devoir>();
        devoirs.add(new Devoir(1,8,"Faites mieux pour le prochain DS"));
        devoirs.add(new Devoir(2,16,"Bien ouej"));
        devoirs.add(new Devoir(3,19,"Ca serait pas une copie de Léo ca ?"));
        modeleDevoir = new ModelTableDevoir(devoirs);
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

        initTables();
        actualScrollPane=tabPersonne;
        contentPane.add(actualScrollPane, BorderLayout.CENTER);

        //ajout bouton de gauche
        BoutonLeft boutonLeft = new BoutonLeft();
        boutonLeft.getDevoir().addActionListener(this);
        boutonLeft.getPersonne().addActionListener(this);
        boutonLeft.getClasse().addActionListener(this);
        boutonLeft.getEnseignement().addActionListener(this);

        contentPane.add(boutonLeft,BorderLayout.WEST);

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

    private void initTables() {
        //initiation de la table Personne
        tableauPersonne = new JTable(modelePersonne);
        tabPersonne = new JScrollPane(tableauPersonne);
        tabPersonne.setBorder(new EmptyBorder(100,300,100,300));
        tabPersonne.setBackground(Colors.green);
        tableauPersonne.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {//This line prevents double events
                    BulletinFrame bulletinFrame = new BulletinFrame(new Personne());
                    System.out.println(tableauPersonne.getValueAt(tableauPersonne.getSelectedRow(), tableauPersonne.getSelectedColumn()).toString());
                }
            }
        });
        //initiation de la table Devoir
        tableauDevoir = new JTable(modeleDevoir);
        tabDevoir = new JScrollPane(tableauDevoir);
        tabDevoir.setBorder(new EmptyBorder(100,300,100,300));
        tabDevoir.setBackground(Colors.green);
        tableauDevoir.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {//This line prevents double events
                    System.out.println(tableauDevoir.getValueAt(tableauDevoir.getSelectedRow(), tableauDevoir.getSelectedColumn()).toString());
                }
            }
        });
        //initiation de la table Classe
        tableauClasse = new JTable(modelClasse);
        tabClasse = new JScrollPane(tableauClasse);
        tabClasse.setBorder(new EmptyBorder(100,300,100,300));
        tabClasse.setBackground(Colors.green);
        tableauClasse.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {//This line prevents double events
                    System.out.println(tableauClasse.getValueAt(tableauClasse.getSelectedRow(), tableauClasse.getSelectedColumn()).toString());
                }
            }
        });
        //initiation de la table Enseignement
        tableauEnseignement = new JTable(modelEnseignement);
        tabEnseignement = new JScrollPane(tableauEnseignement);
        tabEnseignement.setBorder(new EmptyBorder(100,300,100,300));
        tabEnseignement.setBackground(Colors.green);
        tableauEnseignement.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {//This line prevents double events
                    System.out.println(tableauEnseignement.getValueAt(tableauEnseignement.getSelectedRow(), tableauEnseignement.getSelectedColumn()).toString());
                }
            }
        });

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
                int[] selection = tableauPersonne.getSelectedRows();
                for(int i = selection.length - 1; i >= 0; i--){
                    modelePersonne.removePersonne(selection[i]);
                }
            }
        }
        if(button.getText().equals("Ajouter")){
            AjoutPersonne ap = new AjoutPersonne(modelePersonne);
            getContentPane().revalidate();
        }
        if(button.getText().equals("Statistiques")){
            StatsFrame statsFrame = new StatsFrame();
        }
        if(button.getText().equals("Menu")){
            //a voir
        }
        if(button.getText().equals("Personne")){
            getContentPane().remove(actualScrollPane);
            actualScrollPane=tabPersonne;
            getContentPane().add(actualScrollPane);
            getContentPane().revalidate();
        }
        if (button.getText().equals("Devoir")){
            getContentPane().remove(actualScrollPane);
            actualScrollPane=tabDevoir;
            getContentPane().add(actualScrollPane);
            getContentPane().revalidate();
        }
        if (button.getText().equals("Classe")){
            getContentPane().remove(actualScrollPane);
            actualScrollPane=tabClasse;
            getContentPane().add(actualScrollPane);
            getContentPane().revalidate();
        }
        if (button.getText().equals("Enseignement")){
            getContentPane().remove(actualScrollPane);
            actualScrollPane=tabEnseignement;
            getContentPane().add(actualScrollPane);
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
    public JTable getTableauPersonne() {
        return tableauPersonne;
    }
    public void setTableauPersonne(JTable tableauPersonne) {
        this.tableauPersonne = tableauPersonne;
    }
    public ModelTablePersonne getModelePersonne() {
        return modelePersonne;
    }
    public void setModelePersonne(ModelTablePersonne modelePersonne) {
        this.modelePersonne = modelePersonne;
    }
    public ChoixStats getStats() {
        return stats;
    }
    public void setStats(ChoixStats stats) {
        this.stats = stats;
    }
    public JScrollPane getTabPersonne() {
        return tabPersonne;
    }
    public void setTabPersonne(JScrollPane tabPersonne) {
        this.tabPersonne = tabPersonne;
    }
}
