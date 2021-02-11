package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Rhombus extends Element {

    public Rhombus(int x, int y, Color color) {
        super(x, y, color);
    }

    public int[] rhombusX(int x) {
        int[] xCoordinates = { x, x - 40, x, x + 40 };
        return xCoordinates;
    }

    public int[] rhombusY(int y) {
        int[] yCoordinates = { y, y + 40, y + 80, y + 40 };
        return yCoordinates;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        g2.drawPolygon(rhombusX(super.getX()), rhombusY(super.getY()), 4);
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(super.getX()-45, super.getY()-5, 90, 90);
    }
    
}
