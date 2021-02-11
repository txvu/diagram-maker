package view;

import javax.swing.JPanel;

import model.Element;
import model.Grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MiniCanvas extends JPanel{
    private MainScreen panel;
    private Element element;
 
    public MiniCanvas(MainScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        element.render(g2);
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

}
