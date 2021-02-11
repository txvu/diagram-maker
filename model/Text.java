package model;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Text extends Element {

    private String text;

    public Text(int x, int y, String text, Color color) {
        super(x, y, color);
        this.text = text;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getOutlineColor());
        g2.drawString(text, super.getX(), super.getY());
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(super.getX()-5, super.getY()-15, text.length()*8, 20);
    }
    
}
