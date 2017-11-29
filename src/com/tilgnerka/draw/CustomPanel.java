package com.tilgnerka.draw;

import com.tilgnerka.draw.shapes.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
class CustomPanel extends JPanel{
    private Draw draw;

    CustomPanel(Draw draw) {
        super();

        this.draw = draw;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : draw.shapes){
            shape.draw(g);
        }
    }
}