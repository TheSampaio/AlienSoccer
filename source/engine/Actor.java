package source.engine;

import java.awt.Point;
import java.awt.Rectangle;

public class Actor extends Entity
{
    private Rectangle rectangle;

    public Actor(Transform transform)
    {
        super(transform);
        rectangle = new Rectangle(transform.x, transform.y, 50, 50);
    }

    public Actor(Transform transform, int width, int height)
    {
        super(transform);
        rectangle = new Rectangle(transform.x, transform.y, width, height);
    }

    public void collision(Actor actor)
    {
    }

    public boolean intersects(Rectangle r)
    {
        return rectangle.intersects(r);
    }

    @Override
    public Point getLocation()
    {
        return rectangle.getLocation();
    }

    public Point getSize()
    {
        return new Point((int)rectangle.getWidth(), (int)rectangle.getHeight());
    }

    @Override
    public void setLocation(int x, int y)
    {
        super.setLocation(x, y);
        rectangle.setLocation(x, y);
    }

    @Override
    public void translate(int x, int y)
    {
        super.translate(x, y);
        rectangle.translate(x, y);
    }
}
