package source.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Renderer
{
    private BufferStrategy bufferStrategy;
    private Graphics2D graphics;
    private Canvas canvas;

    public Renderer(int width, int height)
    {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public Graphics2D getGraphics()
    {
        return graphics;
    }

    public void createFramebuffer()
    {
        canvas.createBufferStrategy(3);
    }

    public void clear()
    {
        bufferStrategy = canvas.getBufferStrategy();
        graphics = (Graphics2D) bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void draw()
    {
        graphics.dispose();
        bufferStrategy.show();
    }
}
