package source.game;

import java.awt.Graphics2D;

import source.engine.Entity;
import source.engine.Texture;
import source.engine.Transform;

public class Block extends Entity
{
    private Texture texture;
    
    public Block(Texture texture, Transform transform)
    {
        super(transform);
        this.texture = texture;
    }

    @Override
    public void draw(Graphics2D graphics)
    {
        graphics.drawImage(texture.getTile(0, 0, 18, 18),
        getLocation().x,
        getLocation().y,
        50,
        50,
        null);
    }
}
