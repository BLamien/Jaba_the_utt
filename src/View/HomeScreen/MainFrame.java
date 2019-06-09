package View.HomeScreen;
//TODO : JavaDoc

import Constants.Colors;
import DAO.*;
import Model.*;
import View.Bulletin.BulletinFrame;
import View.HomeScreen.Ajout.AjoutClasse;
import View.HomeScreen.Ajout.AjoutDevoir;
import View.HomeScreen.Ajout.AjoutEnseignement;
import View.HomeScreen.Ajout.AjoutPersonne;
import View.HomeScreen.ModelsTable.ModelTableClasse;
import View.HomeScreen.ModelsTable.ModelTableDevoir;
import View.HomeScreen.ModelsTable.ModelTableEnseignement;
import View.HomeScreen.ModelsTable.ModelTablePersonne;
import View.Popup;
import View.Recherche.RechercheFrame;
import View.Statistique.ChoixStats;
import View.Statistique.StatsFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
    private JScrollPane tabPersonne;
    private JScrollPane tabDevoir;
    private JScrollPane tabClasse;
    private JScrollPane tabEnseignement;
    private JScrollPane actualScrollPane;
    private JPanel boutons;
    ArrayList<Personne> personnes = new ArrayList<>();
    ArrayList<Devoir> devoirs = new ArrayList<>();
    ArrayList<Classe> classes = new ArrayList<>();
    ArrayList<Enseignement> enseignements = new ArrayList<>();
    ArrayList<Ecole> ecoles = new ArrayList<>();
    JButton update;


    /**
     * <b>Constructeur par defaut</b>
     */
    public MainFrame() {
        initComponent();
        init();
        setVisible(true);
    }

    private void initComponent() {

        com.sdz.dao.DAO<Personne> eleveDao = new EleveDAO();
        for(int i = 1; i <= ((EleveDAO) eleveDao).taille; i++){
            try {
                personnes.add(eleveDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modelePersonne = new ModelTablePersonne(personnes,classes);

        com.sdz.dao.DAO<Devoir> devoirDao = new DevoirDAO();
        for(int i = 1; i <= ((DevoirDAO) devoirDao).taille; i++){
            try {
                devoirs.add(devoirDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modeleDevoir = new ModelTableDevoir(devoirs);

        com.sdz.dao.DAO<Ecole> ecoleDao = new EcoleDAO();
        for(int i = 1; i <= ((EcoleDAO) ecoleDao).taille; i++){
            try {
                ecoles.add(ecoleDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        com.sdz.dao.DAO<Classe> classeDao = new ClasseDAO();
        for(int i = 1; i <= ((ClasseDAO) classeDao).taille; i++){
            try {
                classes.add(classeDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modelClasse = new ModelTableClasse(classes,personnes,ecoles);

        com.sdz.dao.DAO<Enseignement> enseignementDao = new EnseignementDAO();
        for(int i = 1; i <= ((EnseignementDAO) enseignementDao).taille; i++){
            try {
                enseignements.add(enseignementDao.Connection(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modelEnseignement = new ModelTableEnseignement(enseignements);

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
        update = new JButton("Update");
        update.addActionListener(this);
        boutons.add(add);
        boutons.add(remove);
        boutons.add(update);
        boutons.setBackground(Colors.gris);
        contentPane.add(boutons, BorderLayout.SOUTH);

        header.getStats().addActionListener(this);
        header.getMenu().addActionListener(this);
        header.getRecherche().addActionListener(this);

        // Frame init
        setSize(windowDimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setTitle("JABA");
    }

    private void resetTables(){
        tableauPersonne.removeAll();
        tableauDevoir.removeAll();
        tabDevoir.removeAll();
        tabPersonne.removeAll();
    }

    /**
     * <b>Methode qui intialise les modeles de tables</b>
     */
    private void initTables() {
        //initiation de la table Personne
        tableauPersonne = new JTable(modelePersonne);
        tabPersonne = new JScrollPane(tableauPersonne);
        tabPersonne.setBorder(new EmptyBorder(50,150,50,150));
        tabPersonne.setBackground(Colors.green);
        tableauPersonne.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {//This line prevents double events
                    BulletinFrame bulletinFrame = new BulletinFrame(personnes.get(tableauPersonne.getSelectedRow()));
                    System.out.println(tableauPersonne.getValueAt(tableauPersonne.getSelectedRow(), tableauPersonne.getSelectedColumn()).toString());
                }
            }
        });
        //initiation de la table Devoir
        tableauDevoir = new JTable(modeleDevoir);
        tabDevoir = new JScrollPane(tableauDevoir);
        tabDevoir.setBorder(new EmptyBorder(50,150,50,150));
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
        tabClasse.setBorder(new EmptyBorder(50,150,50,150));
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
        tabEnseignement.setBorder(new EmptyBorder(50,150,50,150));
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
            if(View.Popup.check("Etes-vous sur de vouloir supprimer ?")){
                if(actualScrollPane==tabPersonne){
                    int[] selection = tableauPersonne.getSelectedRows();
                    for(int i = selection.length - 1; i >= 0; i--){
                        System.out.println(personnes.get(selection[i]).getId_personne());
                        new EleveDAO().suppressionEleve(personnes.get(selection[i]).getId_personne());
                        DefaultTableModel dm = (DefaultTableModel)tableauPersonne.getModel();
                        dm.getDataVector().removeAllElements();
                        dm.fireTableDataChanged();
                        initComponent();
                        initTables();
                        getContentPane().revalidate();
                    }
                }
                if(actualScrollPane==tabDevoir){
                    int[] selection = tableauDevoir.getSelectedRows();
                    for(int i = selection.length - 1; i >= 0; i--){
                        new DevoirDAO().delete(devoirs.get(selection[i]));
                        DefaultTableModel dm = (DefaultTableModel)tableauPersonne.getModel();
                        dm.getDataVector().removeAllElements();
                        dm.fireTableDataChanged();
                        initComponent();
                        initTables();
                        getContentPane().revalidate();
                    }
                }
                if(actualScrollPane==tabClasse){

                }
                if(actualScrollPane==tabEnseignement){

                }
                getContentPane().revalidate();
            }
        }
        if(button.getText().equals("Ajouter")){
            if(actualScrollPane==tabPersonne){
                AjoutPersonne ap = new AjoutPersonne(modelePersonne);
                DefaultTableModel dm = (DefaultTableModel)tableauPersonne.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
                initComponent();
                initTables();
                revalidate();
            }
            if(actualScrollPane==tabDevoir){
                AjoutDevoir ap = new AjoutDevoir(modeleDevoir);
                DefaultTableModel dm = (DefaultTableModel)tableauDevoir.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();
                initComponent();
                initTables();
                revalidate();
            }
            if(actualScrollPane==tabClasse){
                //AjoutClasse ap = new AjoutClasse(modelClasse);
            }
            if(actualScrollPane==tabEnseignement){
                //AjoutEnseignement ap = new AjoutEnseignement(modelEnseignement);
            }
            getContentPane().revalidate();
        }
        if(button.getText().equals("Update")){
            if(actualScrollPane==tabPersonne){
                int selection1 = tableauPersonne.getSelectedRow();
                int selection2 = tableauPersonne.getSelectedColumn();
                String value = Popup.ask("Ecrivez la nouvelle valeur", "Update");

                modelePersonne.update(selection1,selection2);
            }
            if(actualScrollPane==tabDevoir){
                int selection = tableauDevoir.getSelectedRow();
                int selection2 = tableauDevoir.getSelectedColumn();
                modeleDevoir.update(selection,selection2);
            }
            if(actualScrollPane==tabClasse){

            }
            if(actualScrollPane==tabEnseignement){

            }
            getContentPane().revalidate();
        }
        if(button.getText().equals("Statistiques")){
            StatsFrame statsFrame = new StatsFrame(classes,personnes);
        }
        if(button.getText().equals("Rechercher")){
            RechercheFrame rechercheFrame = new RechercheFrame(classes,personnes);
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
    public JScrollPane getTabPersonne() {
        return tabPersonne;
    }
    public void setTabPersonne(JScrollPane tabPersonne) {
        this.tabPersonne = tabPersonne;
    }
}
