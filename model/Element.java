package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Element implements IRender{

    // private String element;
    // private String text;

    private int x;
    private int y;
    private Color outlineColor;
    private Color fillColor;

    public Element(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.outlineColor = color;
        this.fillColor = null;
    }

    // public abstract void render(Graphics2D g2);

    // @Override
    // public Rectangle getBoundingBox() {
    //     return new Rectangle(x, y, 200, 200);
    // }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }
}
