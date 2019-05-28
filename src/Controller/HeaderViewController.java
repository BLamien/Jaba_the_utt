package Controller;

import View.Header;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaderViewController implements PropertyChangeListener {
    //Attributs
    private Header header;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    //Getters & Setters

    public Header getHeader() {
        return header;
    }
    public void setHeader(Header header) {
        this.header = header;
    }
}
