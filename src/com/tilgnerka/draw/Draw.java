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
    private List<RenderListener> renderListeners;

    public Draw(String title, int width, int height){
        frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        customPanel = new CustomPanel(this);
        frame.getContentPane().add(customPanel, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);

        shapes = new ArrayList<>();
        renderListeners = new ArrayList<>();
        renderListeners.add(customPanel::repaint);

        new Thread(() -> {
            while(true) {
                for (int i = renderListeners.size() - 1; i >= 0; i--) renderListeners.get(i).render();

                try {
                    Thread.sleep((long) (1_000.0 / 30.0));
                } catch (InterruptedException ignored) {
                    break;
                }
            }
        }).start();
    }

    public void draw(Shape shape){
        shapes.add(shape);
    }

    public void remove(Shape shape){
        shapes.remove(shape);
    }

    public void remove(int i){
        shapes.remove(i);
    }

    public void addRenderListener(RenderListener renderListener){
        if (renderListener == null) return;

        renderListeners.add(renderListener);
    }

    public JFrame getFrame() {
        return frame;
    }
}