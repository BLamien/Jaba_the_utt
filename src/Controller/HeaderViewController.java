package Controller;

import View.Header;
import View.TabHeader;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaderViewController implements PropertyChangeListener {
    //Attributs
    private Header header;

    //Constructeur
    public HeaderViewController(Header _header) {
        this.header = _header;
        this.header.getHeader1().getTabHeader().addPropertyChangeListener(this);
        this.header.getHeader2().getTabHeader().addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if (TabHeader.STATE_HAS_CHANGED.equals(propertyName)) {
            TabHeader source = (TabHeader) evt.getSource();
            changeTabStateExcept(source);
        }
    }

    private void changeTabStateExcept(TabHeader source) {
        if (this.header.getHeader1().getTabHeader().equals(source)) {
            this.header.getHeader2().changePanelState(TabHeader.STATE_NORMAL);
        } else if (this.header.getHeader2().getTabHeader().equals(source)) {
            this.header.getHeader1().changePanelState(TabHeader.STATE_NORMAL);
        }
    }

    //Getters & Setters
    public Header getHeader() {
        return header;
    }
    public void setHeader(Header header) {
        this.header = header;
    }
}
