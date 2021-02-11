package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Grid {

    public Grid() {}

    public void render(Graphics2D g2) {
        g2.setColor(Color.GRAY);

        for (int x = 50; x <= 500; x+=50) {
            g2.drawLine(x, 0, x, 500);
        }

        for (int y = 50; y <= 500; y+=50) {
            g2.drawLine(0, y, 500, y);
        }
    }

    
}
