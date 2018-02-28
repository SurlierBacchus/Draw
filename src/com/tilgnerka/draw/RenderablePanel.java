package com.tilgnerka.draw;

import com.tilgnerka.draw.shapes.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Robert Gers on 29.11.2017.
 */
class RenderablePanel extends JPanel{
    private DrawHelper drawHelper;

    RenderablePanel(DrawHelper drawHelper) {
        super();
        this.drawHelper = drawHelper;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : drawHelper.shapes){
            g.setColor(shape.color);
            shape.draw(g);
        }
    }
}