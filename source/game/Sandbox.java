package source.game;

import javax.swing.ImageIcon;

import source.engine.Game;
import source.engine.Scene;
import source.engine.Texture;
import source.engine.Transform;

public class Sandbox extends Game
{
    private Texture texBackgrounds;
    private Texture texCharacters;
    private Texture texProps;

    public Sandbox()
    {
        super(900, 900, "Alien Soccer");
        setIconImage(new ImageIcon("data/icon/alien.png").getImage());
    }

    @Override
    public void start()
    {
        // Get scene
        Scene scene = getScene();

        // Load textures
        texBackgrounds = new Texture("data/image/background.jpg");
        texCharacters = new Texture("data/image/spritesheet-characters.png");
        texProps = new Texture("data/image/spritesheet-props.png");

        // Background
        scene.add(new Background(texBackgrounds, new Transform(0, 0)));
        
        // Constants
        final int WIDTH = getWidth();
        final int HEIGHT = getHeight();
        final int SIZE = 50;

        // Player 1
        scene.add(new Player(texCharacters, new Transform((WIDTH / 2) - (SIZE / 2), (HEIGHT / 2) - (SIZE / 2) + 125)), true);

        // Player 2
        scene.add(new Enemy(texCharacters, new Transform((WIDTH / 2) - (SIZE / 2), (HEIGHT / 2) - (SIZE / 2) - 125)), true);

        // Ball
        scene.add(new Ball(texProps, new Transform((WIDTH / 2) - 12, (HEIGHT / 2) - 12)), true);
    }
}
