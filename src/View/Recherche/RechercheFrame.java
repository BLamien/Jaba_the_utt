package View.Recherche;

import Constants.Colors;
import Model.Classe;
import Model.Personne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class RechercheFrame extends JFrame {

    public RechercheFrame(ArrayList<Classe> mesClasses, ArrayList<Personne> personnes) throws HeadlessException {

        DefaultMutableTreeNode BDD = new DefaultMutableTreeNode("Arbre de recherche");
        DefaultMutableTreeNode personnesTree=new DefaultMutableTreeNode("Personnes");
        DefaultMutableTreeNode classesTree=new DefaultMutableTreeNode("Classes");
        BDD.add(personnesTree);
        BDD.add(classesTree);
        ArrayList<DefaultMutableTreeNode> treePersonne = new ArrayList<>();
        for(int i=0;i<personnes.size();i++){
            treePersonne.add(new DefaultMutableTreeNode(personnes.get(i).getNom()));
            personnesTree.add(treePersonne.get(i));
            ArrayList<DefaultMutableTreeNode> treeBulletinPersonne = new ArrayList<>();
            for (int j=0;j<personnes.get(i).getBulletins().size();j++){
                treeBulletinPersonne.add(new DefaultMutableTreeNode("Bulletin "+j));
                treeBulletinPersonne.get(j).add(new DefaultMutableTreeNode("Bulletin "+j));
                treeBulletinPersonne.get(j).add(new DefaultMutableTreeNode(personnes.get(i).getBulletins().get(j).getAppreciation_bulletin()));
                treeBulletinPersonne.get(j).add(new DefaultMutableTreeNode(personnes.get(i).getBulletins().get(j).getMoyenne()));
                personnesTree.getLastLeaf().add(treeBulletinPersonne.get(j));
            }
        }
        ArrayList<DefaultMutableTreeNode> treeClasses = new ArrayList<>();
        for(int i=0;i<mesClasses.size();i++){
            treeClasses.add(new DefaultMutableTreeNode(mesClasses.get(i).getNom_niveau()));
            treeClasses.get(i).add(new DefaultMutableTreeNode(mesClasses.get(i).get_anneescolaire()));
            treeClasses.get(i).add(new DefaultMutableTreeNode(mesClasses.get(i).get_ecole()));
            treeClasses.get(i).add(new DefaultMutableTreeNode(mesClasses.get(i).get_effectif()));
            treeClasses.get(i).add(new DefaultMutableTreeNode(mesClasses.get(i).getId_classe()));
            classesTree.add(treeClasses.get(i));
        }
        JTree jt=new JTree(BDD);

        jt.setBackground(Colors.green);
        jt.setBorder(new EmptyBorder(50,50,50,50));
        getContentPane().add(jt,BorderLayout.CENTER);
        // Frame init
        setBackground(Colors.green);
        setSize(new Dimension(400,800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(getOwner());
        setTitle("Bulletin");
        setVisible(true);
    }
}
