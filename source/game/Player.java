package source.game;

import java.awt.Graphics2D;

import source.engine.Actor;
import source.engine.Input;
import source.engine.Keyboard;
import source.engine.Texture;
import source.engine.Transform;

public class Player extends Actor
{
    private Texture texture;
    private int speed = 8;

    public Player(Texture texture, Transform transform)
    {
        super(transform);
        this.texture = texture;
    }

    @Override
    public void tick()
    {
        // Inputs
        if (Input.getKeyPress(Keyboard.W))
            translate(0, -speed);

        if (Input.getKeyPress(Keyboard.S))
            translate(0, speed);

        if (Input.getKeyPress(Keyboard.D))  
            translate(speed, 0);

        if (Input.getKeyPress(Keyboard.A))
            translate(-speed, 0);

        // Screen position
        final int MIN = 50;
        final int MAX = 800;

        if (getLocation().x <= MIN)
           setLocation(MIN, getLocation().y);

        else if (getLocation().x >= MAX)
            setLocation(MAX, getLocation().y);

        if (getLocation().y <= MIN)
            setLocation(getLocation().x, MIN);
 
         else if (getLocation().y >= MAX)
             setLocation(getLocation().x, MAX);
    }
    
    @Override
    public void draw(Graphics2D graphics)
    {
        graphics.drawImage(texture.getTile(0, 50, 22, 24),
        getLocation().x,
        getLocation().y,
        getSize().x,
        getSize().y,
        null);
    }

    @Override
    public void collision(Actor actor)
    {
        final int DX = actor.getLocation().x - getLocation().x;
        final int DY = actor.getLocation().y - getLocation().y;
        final int ABS_DX = Math.abs(DX);
        final int ABS_DY = Math.abs(DY);

        if (ABS_DX > ABS_DY)
        {
            if (DX > 0)
                setLocation(actor.getLocation().x - getSize().x, getLocation().y);
            
            else
                setLocation(actor.getLocation().x + actor.getSize().x, getLocation().y);
        }

        else if (ABS_DX < ABS_DY)
        {
            if (DY > 0)
                setLocation(getLocation().x, actor.getLocation().y - getSize().y);
            
            else
                setLocation(getLocation().x, actor.getLocation().y + actor.getSize().y);
        }
    }
}
