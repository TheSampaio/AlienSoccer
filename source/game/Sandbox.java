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
        
        // Blocks
        final int WIDTH = getWidth();
        final int HEIGHT = getHeight();
        final int SIZE = 50;
        final int ROWS = HEIGHT / SIZE;
        final int COLUMNS = WIDTH / SIZE;

        // Top
        for (int i = 0; i < COLUMNS - 1; i++)
            scene.add(new Block(texProps, new Transform(SIZE * i, 0)), false);

        // Bottom
        for (int i = 0; i < COLUMNS; i++)
            scene.add(new Block(texProps, new Transform(SIZE * i, HEIGHT - SIZE)), false);

        // Right
        for (int i = 0; i < ROWS - 1; i++)
            scene.add(new Block(texProps, new Transform(WIDTH - SIZE, SIZE * i)), false);

        // Left
        for (int i = 1; i < ROWS - 1; i++)
            scene.add(new Block(texProps, new Transform(0, SIZE * i)), false);

        // Player
        scene.add(new Player(texCharacters, new Transform((WIDTH / 2) - (SIZE / 2), (HEIGHT / 2) - (SIZE / 2) + 125)), true);

        // Ball
        scene.add(new Ball(texProps, new Transform((WIDTH / 2) - 12, (HEIGHT / 2) - 12)), true);
    }
}
