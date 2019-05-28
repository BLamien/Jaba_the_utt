package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TabHeader extends JPanel {
    public final static String STATE_NORMAL = "default";
    public final static String STATE_SELECTED = "selected";
    public final static String STATE_ACTIVATED = "activated";
    public final static String STATE_HAS_CHANGED = "state_has_changed";

    //initialise propertyChangeSUpport
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private JLabel titleLabel;
    private String title;

    //constructeur
    public TabHeader(String title) {
        this.title = title;
    }

    private void init(String state) {
        titleLabel = new JLabel(title);
        setLayout(new GridLayout());
        setBorder(new EmptyBorder(10,0,10,0));
        add(titleLabel);
    }

    //Getters & Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Gestion du changement d'etat
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
}
