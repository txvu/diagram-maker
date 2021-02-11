package model;

import java.awt.Graphics2D;
// import java.awt.Rectangle;

import java.awt.Color;
import java.awt.BasicStroke;

public class Rectangle extends Element {

    public Rectangle(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        g2.drawRect(super.getX(), super.getY(), 100, 50);
    }

    @Override
    public java.awt.Rectangle getBoundingBox() {
        return new java.awt.Rectangle(super.getX()-5, super.getY()-5, 110, 60);
    }
    
}
