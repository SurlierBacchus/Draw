package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Oval extends Shape {
    private int x, y, width, height;
    private boolean isFilled;

    /**
     * Render an oval/circle inscribed in a rectangle/square using {@link com.tilgnerka.draw.DrawHelper#draw(Shape)}
     * @param x top left corner of the rectangle x-coordinate
     * @param y top left corner of the rectangle y-coordinate
     * @param width width of the rectangle in pixels
     * @param height height of the rectangle in pixels
     * @param color color of the shape
     * @param isFilled specify to draw the full shape or just its outline
     */
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
        if (isFilled){
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }

    /**
     * Check if point [x, y] is inside this shape
     */
    @Override
    public boolean contains(int x, int y){
        int h = this.x + width/2;
        int k = this.y + height/2;

        return Math.pow(x - h, 2) / Math.pow(width / 2, 2)
                +
                Math.pow(y - k, 2) / Math.pow(height / 2, 2)
                <=
                1;
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