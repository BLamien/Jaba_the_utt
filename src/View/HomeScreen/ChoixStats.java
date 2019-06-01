package View.HomeScreen;

import Constants.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChoixStats extends JPanel {
    //attributs
    private JButton camembert;
    private JButton graphBaton;

    //constructuer
    public ChoixStats() {
        init();
    }

    public void init(){
        camembert = new JButton("Grape Camembert");
        graphBaton = new JButton("Graphe baton");
        // Layout
        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(300);
        setLayout(layout);
        setBorder(new EmptyBorder(30, 30,30,30));
        setBackground(Colors.green);

        this.add(camembert);
        this.add(graphBaton);
    }

    public JButton getCamembert() {
        return camembert;
    }
    public void setCamembert(JButton camembert) {
        this.camembert = camembert;
    }
    public JButton getGraphBaton() {
        return graphBaton;
    }
    public void setGraphBaton(JButton graphBaton) {
        this.graphBaton = graphBaton;
    }
}
