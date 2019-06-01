package View.HomeScreen;
//TODO : JavaDoc
import Constants.Colors;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
    private String state;

    //constructeur
    public TabHeader(String title) {
        init(title);
    }

    private void init(String title) {
        titleLabel = new JLabel(title);
        GridLayout gridLayout = new GridLayout();
        setLayout(gridLayout);

        setBorder(new CompoundBorder(new LineBorder(Colors.white), new EmptyBorder(30,0,30,0)));
        add(titleLabel);
    }

    //Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }
    public JLabel getTitleLabel() {
        return titleLabel;
    }
    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
    public String getState() { return state; }
    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        if(state.equals(STATE_ACTIVATED)){
            this.pcs.firePropertyChange(STATE_HAS_CHANGED, oldState, this.state);
        }
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
