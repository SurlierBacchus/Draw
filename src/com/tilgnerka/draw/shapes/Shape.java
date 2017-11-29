package com.tilgnerka.draw.shapes;

import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public abstract class Shape {
    public abstract void draw(Graphics g);
    public abstract int getPositionX();
    public abstract int getPositionY();
    public abstract void setPositionX(int x);
    public abstract void setPositionY(int y);

}