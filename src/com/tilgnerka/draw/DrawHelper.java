package com.tilgnerka.draw;

import com.sun.istack.internal.Nullable;
import com.tilgnerka.draw.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Library to help with drawing geometric shapes in Java and initializing JFrame objects
 * @author Robert Gers
 */
public class DrawHelper {
    private JFrame frame;
    List<Shape> shapes;
    private List<RenderListener> renderListeners;

    /**
     * Initializes a default JFrame window
     * @param width x-size of the window
     * @param height y-size of the window
     * @param ui view group to be added to the frame
     * @return initialized JFrame
     */
    public static JFrame initializeDefaultFrame(int width, int height, JPanel ui) {
        return initializeDefaultFrame("", width, height, ui);
    }

    /**
     * Initializes a default JFrame window
     * @param ui view group to be added to the frame
     * @return initialized JFrame
     */
    public static JFrame initializeDefaultFrame(JPanel ui) {
        return initializeDefaultFrame("", 720, 480, ui);
    }

    /**
     * Initializes a default JFrame window
     * @param title title of the window
     * @param width x-size of the window
     * @param height y-size of the window
     * @param ui view group to be added to the frame
     * @return initialized JFrame
     */
    public static JFrame initializeDefaultFrame(String title, int width, int height, JPanel ui){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(ui, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setVisible(true);

        return frame;
    }

    /**
     * Initializes a fullscreen JFrame with {@param ui} and fills the remaining space with {@link RenderablePanel} to render custom {@link Shape}
     * @param title title of the window
     * @param ui view group to be added to the frame
     * @param position specifies position of {@param ui} relative to the renderable area
     */
    public DrawHelper(@Nullable String title, JPanel ui, Position position) {
        this(title, -1, -1, ui, position);
    }

    /**
     * Initializes a JFrame with {@param ui} and fills the remaining space with {@link RenderablePanel} to render custom {@link Shape}
     * @param title title of the window
     * @param width x-size of the window, -1 for fullscreen
     * @param height y-size of the window, -1 for fullscreen
     * @param ui view group to be added to the frame
     * @param position specifies position of {@param ui} relative to the renderable area
     */
    public DrawHelper(@Nullable String title, int width, int height, JPanel ui, Position position){
        if (title != null) frame = new JFrame(title);
        else frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(ui, position.toString());

        RenderablePanel renderablePanel = new RenderablePanel(this);
        mainPanel.add(renderablePanel, BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        if (width < 0 || height < 0){
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
        }
        else{
            frame.setPreferredSize(new Dimension(width, height));
        }

        frame.pack();
        frame.setVisible(true);

        shapes = new ArrayList<>();
        renderListeners = new ArrayList<>();
        renderListeners.add(renderablePanel::repaint);

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

    /**
     * Add a shape to be rendered every frame
     * @param shape object to be drawn
     */
    public void draw(Shape shape){
        shapes.add(shape);
    }

    /**
     * Remove the specified Shape
     * @param shape object to be removed
     */
    public void remove(Shape shape){
        shapes.remove(shape);
    }

    /**
     * Remove shape at the specified index
     * @param i index of the shape to be removed
     */
    public void remove(int i){
        shapes.remove(i);
    }

    /**
     * Register a listener launched every time a new frame is rendered
     * @param renderListener class with {@link RenderListener#render()} method called every frame
     */
    public void addRenderListener(RenderListener renderListener){
        if (renderListener == null) return;

        renderListeners.add(renderListener);
    }

    /**
     * Getter for the JFrame window with all contained components
     * @return current active JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    public enum Position {
        NORTH, SOUTH, WEST, EAST
    }
}