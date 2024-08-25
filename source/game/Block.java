package source.game;

import java.awt.Graphics;

import source.engine.Actor;
import source.engine.Texture;
import source.engine.Transform;

public class Block extends Actor
{
    private Texture texture;
    
    public Block(Texture texture, Transform transform)
    {
        super(transform);
        this.texture = texture;
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.drawImage(texture.getTile(0, 0, 18, 18),
        getLocation().x,
        getLocation().y,
        50, 50,
        null);
    }
}
