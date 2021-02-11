package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Oval extends Element {

    public Oval(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        g2.drawOval(super.getX(), super.getY(), 100, 50);
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(super.getX()-5, super.getY()-5, 110, 60);
    }
    
}
