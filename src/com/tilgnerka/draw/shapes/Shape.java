package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public abstract class Shape {
    protected Color color;

    protected Shape(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);
}