/**
 * Problem avec les import
 * clic droit sur Jaba_the_utt.. dans l'arboressance
 * --> scroll en bas--> open Module settings --> clic sur le "+"
 * --> puis sur JARs or directories.. --> ajouter tous les fichiers du dossier à l'adresse
 * Jaba_the_utt\lib\JFreeChart--> clique sur apply, puis sur ok
 */

package View;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

//TODO des charts dynamiques qui ont un nombre de pics variables
public class Reporting  {






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






    }



    //méthodes
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


    public static void barChartSimple3parts(String categorie1, String categorie2,
                                            String column1, String column2, String column3,
                                            double valueCat1Col1, double valueCat1Col2, double valueCat1Col3,
                                            double valueCat2Col1, double valueCat2Col2, double valueCat2Col3,
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
}