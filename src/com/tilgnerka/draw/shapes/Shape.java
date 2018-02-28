package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 *
 * Extend this class to create and render any geometric shape using {@link com.tilgnerka.draw.DrawHelper#draw(Shape)}
 */
public abstract class Shape {
    public Color color;

    protected Shape(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);
}