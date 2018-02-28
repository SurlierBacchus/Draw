package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Line extends Shape {
    private int x1, y1, x2, y2;

    /**
     * Render a line using {@link com.tilgnerka.draw.DrawHelper#draw(Shape)}
     * @param x1 start point of the line x-coordinate
     * @param y1 start point of the line y-coordinate
     * @param x2 end point of the line x-coordinate
     * @param y2 end point of the line y-coordinate
     * @param color color of the shape
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}