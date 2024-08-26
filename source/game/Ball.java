package source.game;

import java.awt.Graphics2D;

import source.engine.Actor;
import source.engine.Texture;
import source.engine.Transform;

public class Ball extends Actor
{
    private final int SPEED = 8;

    private Texture texture;
    private int speedX = SPEED,
        speedY = SPEED;

    public Ball(Texture texture, Transform transform)
    {
        super(transform, 25, 25);
        this.texture = texture;
    }

    @Override
    public void tick()
    {
        translate(-speedX, -speedY);

        final int MIN = 50;
        final int MAX = 825;

        if (getLocation().x <= MIN)
            speedX *= -1;

        else if (getLocation().x >= MAX)
            speedX *= -1;

        if (getLocation().y <= MIN)
            speedY *= -1;

        else if (getLocation().y >= MAX)
            speedY *= -1;
    }

    @Override
    public void draw(Graphics2D graphics)
    {
        graphics.drawImage(texture.getTile(18, 0, 18, 18),
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

        if (Math.abs(DX) > Math.abs(DY))
            speedX *= -1;

        else
            speedY *= -1;
    }

}
