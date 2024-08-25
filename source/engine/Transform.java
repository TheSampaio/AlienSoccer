package source.engine;

import java.awt.Point;

public class Transform
{
    public int x, y;

    public Transform(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void translate(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public Point getLocation()
    {
        return new Point(x, y);
    }
}
