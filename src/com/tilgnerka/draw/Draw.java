package com.tilgnerka.draw;

import com.tilgnerka.draw.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert Gers on 29.11.2017.
 */
public class Draw {
    private final JFrame frame;
    private final CustomPanel customPanel;
    List<Shape> shapes;
    private final boolean isDynamic;

    public Draw(String title, int width, int height, boolean isDynamic){
        this.isDynamic = isDynamic;

        frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        customPanel = new CustomPanel(this);
        frame.getContentPane().add(customPanel, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);

        shapes = new ArrayList<>();

        if (isDynamic){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        customPanel.repaint();

                        try {
                            Thread.sleep((long) (1_000.0 / 60.0));
                        } catch (InterruptedException ignored) {
                            break;
                        }
                    }
                }
            }).start();
        }
    }

    public void draw(Shape shape){
        shapes.add(shape);
        customPanel.repaint();
    }

    public boolean isDynamic() {
        return isDynamic;
    }

    public JFrame getFrame() {
        return frame;
    }
}