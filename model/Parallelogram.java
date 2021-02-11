package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Parallelogram extends Element {

    public Parallelogram(int x, int y, Color color) {
        super(x, y, color);
    }

    public int[] parallelogramX(int x) {
        // int[] xCoordinates = { x, x + 75, x + 50, x - 25 };
        int[] xCoordinates = { x, x + 100, x + 75, x -25};
        return xCoordinates;
    }

    public int[] parallelogramY(int y) {
        int[] yCoordinates = { y, y, y+50, y+50};
        return yCoordinates;
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(super.getX() - 30, super.getY()-5, 135, 60);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        g2.drawPolygon(parallelogramX(super.getX()), parallelogramY(super.getY()), 4);
    }
    
}
