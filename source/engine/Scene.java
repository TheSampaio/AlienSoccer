package source.engine;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Scene
{
    private ArrayList<Actor> dynamics;
    private ArrayList<Actor> statics;
    private ArrayList<Entity> entities;
    private ArrayList<Actor[]> collisions;

    public Scene()
    {
        dynamics = new ArrayList<Actor>();
        statics = new ArrayList<Actor>();
        entities = new ArrayList<Entity>();
        collisions = new ArrayList<Actor[]>();
    }

    public void add(Actor entity, boolean dynamic)
    {
        if (dynamic)
            dynamics.add(entity);

        else
            statics.add(entity);
    }

    public void add(Entity entity)
    {
        entities.add(entity);
    }

    public void tick()
    {
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).tick();

        for (int i = 0; i < dynamics.size(); i++)
            dynamics.get(i).tick();

        for (int i = 0; i < statics.size(); i++)
            statics.get(i).tick();
    }

    public void draw(Graphics graphics)
    {
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).draw(graphics);

        for (int i = 0; i < dynamics.size(); i++)
            dynamics.get(i).draw(graphics);

        for (int i = 0; i < statics.size(); i++)
            statics.get(i).draw(graphics);
    }

    public void collison()
    {
        // Dynamic x Dynamic
        for (int i = 0; i < dynamics.size() - 1; i++)
        {
            Actor actor = dynamics.get(i);

            for (int j = i + 1; j < dynamics.size(); j++)
            {
                Actor other = dynamics.get(j);
                if (actor.intersects(
                    new Rectangle(
                        other.getLocation().x,
                        other.getLocation().y,
                        other.getSize().x,
                        other.getSize().y
                    )
                ))
                {
                    collisions.add(new Actor[] { actor, other });
                }
            }
        }

        // Dynamic x Static
        for (Actor actor : dynamics)
        {
            for (Actor other : statics)
            {
                if (other.intersects(
                    new Rectangle(
                        actor.getLocation().x,
                        actor.getLocation().y,
                        actor.getSize().x,
                        actor.getSize().y
                    )
                ))
                {
                    collisions.add(new Actor[] { actor, other });
                }
            }
        }

        if (!collisions.isEmpty())
        {
            for (Actor[] actors : collisions)
            {
                actors[0].collision(actors[1]);
                actors[1].collision(actors[0]);
            }
        }

        deletion();
    }

    public void deletion()
    {
        // collisions.sort(null);
        collisions.stream().distinct().collect(Collectors.toList());

        // TODO: Remove objects from scene here.

        collisions.clear();
    }
}
