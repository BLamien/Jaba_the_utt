package Controller;

import View.TabHeader;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TabHeaderViewController implements MouseListener {
    //attributs
    TabHeader tabHeader;

    //Constructeur
    public TabHeaderViewController(TabHeader tabHeader) {
        this.tabHeader = tabHeader;
    }

    //Getters & Setters
    public TabHeader getTabHeader() {
        return tabHeader;
    }
    public void setTabHeader(TabHeader tabHeader) {
        this.tabHeader = tabHeader;
    }

    //Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
