package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Line extends Shape {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
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

    public int getEndpointX() {
        return x2;
    }

    public void setEndpointX(int x2) {
        this.x2 = x2;
    }

    public int getEndpointY() {
        return y2;
    }

    public void setEndpointY(int y2) {
        this.y2 = y2;
    }
}