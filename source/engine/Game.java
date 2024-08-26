package source.engine;

import java.awt.Canvas;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable
{
    private Renderer renderer;
    private Input input;
    private Scene scene;

    public Game(int width, int height, String title)
    {
        renderer = new Renderer(width, height);
        Canvas canvas = renderer.getCanvas();

        add(canvas);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle(title);

        input = new Input();
        canvas.addKeyListener(input);

        renderer.createFramebuffer();
        scene = new Scene();
    }

    protected Scene getScene()
    {
        return scene;
    }

    @Override
    public Graphics2D getGraphics()
    {
        return (Graphics2D) renderer.getGraphics();
    }

    @Override
    public int getWidth()
    {
        return renderer.getCanvas().getWidth();
    }

    @Override
    public int getHeight()
    {
        return renderer.getCanvas().getHeight();
    }

    public void start()
    {
    }

    public void tick()
    {
        scene.tick();
        scene.collison();
    }

    public void draw()
    {
        scene.draw(getGraphics());
    }

    @Override
    public void run()
    {
        start();

        while(true)
        {
            input.pollEvents();
            tick();

            renderer.clear();
            
            draw();
            renderer.draw();

            try
            {
                Thread.sleep(16, 66);
            }
            
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
