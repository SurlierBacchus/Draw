package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Rectangle extends Shape {
    private int x, y, width, height;
    private boolean isFilled;

    /**
     * Render a rectangle using {@link com.tilgnerka.draw.DrawHelper#draw(Shape)}
     * @param x top left corner x-coordinate
     * @param y top left corner y-coordinate
     * @param width width of the rectangle in pixels
     * @param height height of the rectangle in pixels
     * @param color color of the shape
     * @param isFilled specify to draw the full shape or just its outline
     */
    public Rectangle(int x, int y, int width, int height, Color color, boolean isFilled) {
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
            g.fillRect(x, y, width, height);
        }else {
            g.drawRect(x, y, width, height);
        }
    }

    /**
     * Check if point [x, y] is inside this shape
     */
    @Override
    public boolean contains(int x, int y) {
        return (x - this.x <= width && x - this.x >= 0)
                &&
                (y - this.y <= height && y - this.y >= 0);
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