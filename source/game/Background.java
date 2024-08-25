package source.game;

import java.awt.Graphics;

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
    public void draw(Graphics graphics)
    {
        graphics.drawImage(texture.getImage(), 50, 50, 800, 800, null);
    }
}
