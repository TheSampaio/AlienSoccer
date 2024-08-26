package source.game;

import java.awt.Graphics2D;

import source.engine.Entity;
import source.engine.Texture;
import source.engine.Transform;

public class Background extends Entity
{
    private Texture texture;

    public Background(Texture texture, Transform transform)
    {
        super(transform);
        this.texture = texture;
    }
    
    @Override
    public void draw(Graphics2D graphics)
    {
        graphics.drawImage(texture.getImage(), 0, 0, 900, 900, null);
    }
}
