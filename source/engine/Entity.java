package source.engine;

import java.awt.Graphics2D;
import java.awt.Point;

public class Entity
{
    private Transform transform;

    public Entity(Transform transform)
    {
        this.transform = transform;
    }

    public Point getLocation()
    {
        return transform.getLocation();
    }

    public void setLocation(int x, int y)
    {
        transform.x = x;
        transform.y = y;
    }
    
    public void tick()
    {
    }
    
    public void draw(Graphics2D graphics)
    {
    }

    public void translate(int x, int y)
    {
        transform.translate(x, y);
    }
}
