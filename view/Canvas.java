package view;

import javax.swing.JPanel;

import model.Element;
import model.Grid;
import model.IRender;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private MainScreen panel;
    private ArrayList<IRender> shapes = new ArrayList<>();
    private Grid grid;
    private boolean gridOn = true;
    private int selectedIndex = -1;
    private boolean movingMode = false;

    public Canvas(MainScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gridOn) {
            grid = new Grid();
            grid.render(g2);
        }

        // if (!shapes.isEmpty()) {
        //     for (var s : shapes) {
        //         s.render(g2);
        //     }
        // }

        for (int i = 0; i < shapes.size(); i++) {
            IRender element = shapes.get(i);
            g2.setStroke(new BasicStroke(2));
            element.render(g2);
            if (i == selectedIndex && movingMode == true) {
                Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 },
                        0);
                // g2.setStroke(new BasicStroke(5));
                g2.setStroke(dashed);
                g2.setColor(Color.CYAN);
                g2.draw(element.getBoundingBox());
            }
        }
    }

    public ArrayList<IRender> getShapes() {
        return shapes;
    }

    public void setGridOn(boolean gridOn) {
        this.gridOn = gridOn;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void setMovingMode(boolean movingMode) {
        this.movingMode = movingMode;
    }

    public boolean getMovingMode() {
        return movingMode;
    }
}

