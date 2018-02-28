package com.tilgnerka.draw;

/**
 * Created by Robert Gers on 30.11.2017.
 *
 * A class implementing this interface is launched every time a new frame is rendered
 * Register your class at {@link DrawHelper#addRenderListener(RenderListener)}
 */
public interface RenderListener {
    public void render();
}
