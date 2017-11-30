package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Oval extends Shape {
    private int x, y, width, height;
    private boolean isFilled;

    public Oval(int x, int y, int width, int height, Color color, boolean isFilled) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isFilled = isFilled;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        if (isFilled){
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}