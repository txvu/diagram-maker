package model;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.lang.Math;

public class Line extends Element {

    int x2 = 0;
    int y2 = 0;

    public Line(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        if (super.getX() == 0 && x2 == 0) {
            return;
        } else if (super.getX() != 0 && x2 == 0) {
            g2.fillOval(super.getX(), super.getY(), 4, 4);
        } else {
            if (java.lang.Math.abs(super.getX()-x2) < 20) x2 = super.getX();
            if (java.lang.Math.abs(super.getY()-y2) < 20) y2 = super.getY();
            g2.drawLine(super.getX(), super.getY(), x2, y2);
        }
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(super.getX(), super.getY(), 4, 4);
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }
    
    public void setY2(int y2) {
        this.y2 = y2;
    }

}
