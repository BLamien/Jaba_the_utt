/**
 * Problem avec les import
 * clic droit sur Jaba_the_utt.. dans l'arboressance
 * --> scroll en bas--> open Module settings --> clic sur le "+"
 * --> puis sur JARs or directories.. --> ajouter tous les fichiers du dossier à l'adresse
 * Jaba_the_utt\lib\JFreeChart--> clique sur apply, puis sur ok
 */



package View;

import Model.Classe;
import Model.Eleve;
import Model.Enseignant;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;


/**
 * <b>Reporting est la classe dedie a l'affichage de statistiques</b>
 *  <br>
 *
 *     Les statistiques vont etre affichees de plusieurs manieres :
 *      <ul>
 *          <li>sous forme de pie chart</li>
 *          <li>sous forme de diagramme en barre</li>
 *          <li>sous forme de diagramme batton</li>
 *      </ul>
 *
 * @author Victor
 * @version 1.1
 */
//TODO des charts dynamiques qui ont un nombre de pics variables
public class Reporting  {


    /**
     * <b>Fonction test des graphiques</b>
     * <br>
     *     <p>Cette fonction permet de tester les differents graphiques qu il est possible de realiser</p>
     * @param args
     *              parametre de base de la fonction main
     */
    public static void main(String[] args) {


        //test pieChart3parts
        /*pieChart3parts("categorie1", 43.2,
                        "categorie2", 27.9,
                        "categorie3", 79.5,
                        "titreFenetre",
                        "titreChart", true, true, false);*/

        //test pieChart2parts
        /*pieChart2parts("categorie1", 43.2,
                        "categorie2", 27.9,
                        "titreFenetre",
                        "titreChart", true, true, false);*/

        //test barChartDouble3parts
        /*barChartDouble3parts("categorie1", "categorie2",
                "column1", "column2", "column3",
                1.0, 5.0, 3.0,
                2.0, 3.0, 2.0,
                "titrefenetre", "titreChart", "xLabel", "ylLabel",
                true, true, false);*/

        //test barChartSimple3parts
        /*barChartSimple3parts("categorie1", "categorie2",
                "column1", "column2", "column3",
                1.0, 5.0, 3.0,
                2.0, 3.0, 2.0,
                "titrefenetre", "titreChart", "xLabel", "ylLabel",
                true, true, false);*/



        ArrayList<Classe> ok = new ArrayList<Classe>();
        Classe okk = new Classe();
        ArrayList<Eleve> effectif = new ArrayList<Eleve>();
        okk.setNom_niveau("6");
        Eleve okkk= new Eleve();
        effectif.add(okkk);
        Eleve okkk1= new Eleve();
        effectif.add(okkk1);
        okk.setEffectif(effectif);


        Classe okk2 = new Classe();
        ArrayList<Eleve> effectif2 = new ArrayList<Eleve>();
        okk2.setNom_niveau("5");
        Eleve okkk2= new Eleve();
        effectif.add(okkk2);
        Eleve okkk12= new Eleve();
        effectif2.add(okkk12);
        Eleve okkk123= new Eleve();
        effectif2.add(okkk123);
        okk2.setEffectif(effectif2);

        ok.add(okk);
        ok.add(okk2);

        System.out.println(okk2.getEffectif().size());


        graphEleveNiveau(ok);

    }



    //méthodes

    /**
     * <b>Creation d'un diagramme en barre double avec 3 instances (en x)</b>
     * <br>
     * <p>Ce diagramme compare deux entitees sur 3 instances differentes
     * <br>Par exemple, professeur et eleves sur 3 années différentes</p>
     * @param categorie1 premiere categoreie d'entite
     * @param categorie2 seconde categorie d'entite
     * @param column1 premiere instance
     * @param column2 seconde instance
     * @param column3 troisieme instance
     * @param valueCat1Col1 valeur de la categorie 1 colonne 1
     * @param valueCat1Col2 valeur de la categorie 1 colonne 2
     * @param valueCat1Col3 valeur de la categorie 1 colonne 3
     * @param valueCat2Col1 valeur de la categorie 2 colonne 1
     * @param valueCat2Col2 valeur de la categorie 2 colonne 2
     * @param valueCat2Col3 valeur de la categorie 2 colonne 3
     * @param titrefenetre titre de la fenetre ou est represente le graphique
     * @param titreChart titre du graphique
     * @param xLabel legende de l'axe de abscisses
     * @param ylLabel legende de l'axe de ordonnees
     * @param legend booleen d'affiche des legendes
     * @param tooltips booleen d'affiche des outils
     * @param urls booleen d'affiche de urls
     */
    public static void barChartDouble3parts(String categorie1, String categorie2,
                                            String column1, String column2, String column3,
                                            double valueCat1Col1, double valueCat1Col2, double valueCat1Col3,
                                            double valueCat2Col1, double valueCat2Col2, double valueCat2Col3,
                                            String titrefenetre, String titreChart, String xLabel, String ylLabel,
                                            boolean legend, boolean tooltips, boolean urls){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(valueCat1Col1, categorie1, column1);
        dataset.addValue(valueCat1Col2, categorie1, column2);
        dataset.addValue(valueCat1Col3, categorie1, column3);
        dataset.addValue(valueCat2Col1, categorie2, column1);
        dataset.addValue(valueCat2Col2, categorie2, column2);
        dataset.addValue(valueCat2Col3, categorie2, column3);

        JFreeChart chart = ChartFactory.createBarChart(
                titreChart, // chart title
                xLabel, // domain axis label
                ylLabel, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                legend, // include legend
                tooltips, // tooltips?
                urls // URLs?
        );
        ChartFrame frame = new ChartFrame(titrefenetre, chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * <b>Creation d'un diagramme en barre simple avec 3 instances (en x)</b>
     *      * <br>
     *      * <p>Ce diagramme indique une entite sur 3 instances differentes
     *      * <br>Par exemple, les eleves sur 3 années différentes</p>
     *
     * @param categorie1 premiere categoreie d'entite
     * @param categorie2 seconde categorie d'entite
     * @param column1 premiere instance
     * @param column2 seconde instance
     * @param column3 troisieme instance
     * @param valueCat1Col1 valeur de la categorie 1 colonne 1
     * @param valueCat1Col2 valeur de la categorie 1 colonne 2
     * @param valueCat1Col3 valeur de la categorie 1 colonne 3
     * @param titrefenetre titre de la fenetre ou est represente le graphique
     * @param titreChart titre du graphique
     * @param xLabel legende de l'axe de abscisses
     * @param ylLabel legende de l'axe de ordonnees
     * @param legend booleen d'affiche des legendes
     * @param tooltips booleen d'affiche des outils
     * @param urls booleen d'affiche de urls
     */
    public static void barChartSimple3parts(String categorie1, String categorie2,
                                            String column1, String column2, String column3,
                                            double valueCat1Col1, double valueCat1Col2, double valueCat1Col3,
                                            String titrefenetre, String titreChart, String xLabel, String ylLabel,
                                            boolean legend, boolean tooltips, boolean urls){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(valueCat1Col1, categorie1, column1);
        dataset.addValue(valueCat1Col2, categorie1, column2);
        dataset.addValue(valueCat1Col3, categorie1, column3);


        JFreeChart chart = ChartFactory.createBarChart(
                titreChart, // chart title
                xLabel, // domain axis label
                ylLabel, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                legend, // include legend
                tooltips, // tooltips?
                urls // URLs?
        );
        ChartFrame frame = new ChartFrame(titrefenetre, chart);
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * <b>Creation d'un diagramme circulaire (camembert) avec 2 instances</b>
     * <br>
     * <p>Ce diagramme compare deux entitees sur 2 instances differentes</p>
     * @param categorie1 premiere categoreie d'entite
     * @param value1 valeur de liee a la premiere categorie d'entite
     * @param categorie2 seconde categoreie d'entite
     * @param value2 valeur de liee a la seconde categorie d'entite
     * @param titreFenetre titre de la fenetre ou est represente le graphique
     * @param titreChart titre du graphique
     * @param legend booleen d'affiche des legendes
     * @param tooltips booleen d'affiche des outils
     * @param urls booleen d'affiche de urls
     */
    public static void pieChart2parts(String categorie1, double value1,
                                      String categorie2, double value2,
                                      String titreFenetre,
                                      String titreChart, boolean legend, boolean tooltips, boolean urls) {
        // create a dataset...
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(categorie1, value1);
        dataset.setValue(categorie2, value2);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                titreChart,
                dataset,
                legend, // legend?
                tooltips, // tooltips?
                urls // URLs?
        );
        // create and display a frame...
        ChartFrame frame = new ChartFrame(titreFenetre, chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * <b>Creation d'un diagramme circulaire (camembert) avec 3 instances</b>
     * <br>
     * <p>Ce diagramme compare deux entitees sur 3 instances differentes</p>
     *
     * @param categorie1 premiere categoreie d'entite
     * @param value1 valeur de liee a la premiere categorie d'entite
     * @param categorie2 seconde categoreie d'entite
     * @param value2 valeur de liee a la seconde categorie d'entite
     * @param categorie3 troisieme categoreie d'entite
     * @param value3  valeur de liee a la seconde categorie d'entite
     * @param titreFenetre titre de la fenetre ou est represente le graphique
     * @param titreChart titre du graphique
     * @param legend booleen d'affiche des legendes
     * @param tooltips booleen d'affiche des outils
     * @param urls booleen d'affiche de urls
     */
    public static void pieChart3parts(String categorie1, double value1,
                                      String categorie2, double value2,
                                      String categorie3, double value3,
                                      String titreFenetre,
                                      String titreChart, boolean legend, boolean tooltips, boolean urls) {
        // create a dataset...
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(categorie1, value1);
        dataset.setValue(categorie2, value2);
        dataset.setValue(categorie3, value3);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                titreChart,
                dataset,
                legend, // legend?
                tooltips, // tooltips?
                urls // URLs?
        );
        // create and display a frame...
        ChartFrame frame = new ChartFrame(titreFenetre, chart);
        frame.pack();
        frame.setVisible(true);
    }










    public static void barChartSimpleNparts(String categorie1,
                                            ArrayList<Classe> mesClasses,
                                            String titrefenetre, String titreChart, String xLabel, String ylLabel,
                                            boolean legend, boolean tooltips, boolean urls){



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //on ajoute toutes les valeurs de notre arrayList
        for(int i=0; i<mesClasses.size();i++){
            dataset.addValue(mesClasses.get(i).getEffectif().size(), categorie1, mesClasses.get(i).getNom_niveau());
        }



        JFreeChart chart = ChartFactory.createBarChart(
                titreChart, // chart title
                xLabel, // domain axis label
                ylLabel, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                legend, // include legend
                tooltips, // tooltips?
                urls // URLs?
        );
        ChartFrame frame = new ChartFrame(titrefenetre, chart);
        frame.pack();
        frame.setVisible(true);
    }













    //----------------------- partie utile --------------------------------//

    //nb moyen d'eleve par niveau
    public static void graphEleveNiveau(ArrayList<Classe> mesClasses){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //on ajoute toutes les valeurs de notre arrayList
        for(int i=0; i<mesClasses.size();i++){
            dataset.addValue(mesClasses.get(i).getEffectif().size(), "nb eleves", mesClasses.get(i).getNom_niveau());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "nombre d'eleves par niveau", // chart title
                "niveau", // domain axis label
                "nombre d'eleves", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );
        ChartFrame frame = new ChartFrame("nombre deleves par niveau", chart);
        frame.pack();
        frame.setVisible(true);
    }

    // proportion de profs et d'élèves dans l'école
    //TODO : la classe école devrait peut etre contenir une arraylist de porf et d eleves
    public static void garphEleveProf(ArrayList<Eleve> mesEleves, ArrayList<Enseignant> mesProfs) {

        // create a dataset...
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("enseignants",mesProfs.size());
        dataset.setValue("eleves",mesEleves.size());
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                "rapport du nombre d'eleves par rapport à celui du nombre d'enseignants au sein d'une ecole",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
        );
        // create and display a frame...
        ChartFrame frame = new ChartFrame("Proportion eleves enseignants", chart);
        frame.pack();
        frame.setVisible(true);
    }




    // proportion de profs et d'élèves par école
    public static void graphEleveProf_ecole(ArrayList<Eleve> mesEleves, ArrayList<Enseignant> mesProfs, String column1, String column2){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(mesEleves.size(), "eleve", "el");
        dataset.addValue(mesProfs.size(), "enseignant", "ei");


        JFreeChart chart = ChartFactory.createBarChart(
                "rapport du nombre d'eleves par rapport au nombre d'enseignants par ecole", // chart title
                "ecole", // domain axis label
                "nombre de personnes", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );
        ChartFrame frame = new ChartFrame("porportion d'eleves et de profs par ecole", chart);
        frame.pack();
        frame.setVisible(true);
    }


    // TODO : classement des elèves
    // TODO : répartiotion des moyennes des élèves d'une école

}