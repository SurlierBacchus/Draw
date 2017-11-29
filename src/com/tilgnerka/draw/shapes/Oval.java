package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Oval extends Shape {
    private int x1, y1, width, height;
    private boolean isFilled;

    public Oval(int x1, int y1, int width, int height, boolean isFilled) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        this.isFilled = isFilled;
    }

    @Override
    public void draw(Graphics g) {
        if (isFilled){
            g.fillOval(x1, y1, width, height);
        } else {
            g.drawOval(x1, y1, width, height);
        }
    }

    @Override
    public int getPositionX() {
        return x1;
    }

    @Override
    public int getPositionY() {
        return y1;
    }

    @Override
    public void setPositionX(int x) {
        this.x1 = x;
    }

    @Override
    public void setPositionY(int y) {
        this.y1 = y;
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