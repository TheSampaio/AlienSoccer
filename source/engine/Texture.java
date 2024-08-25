package source.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture
{
    private BufferedImage image;

    public Texture(String filePath)
    {
        try 
        {
            image = ImageIO.read(new File(filePath));
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public int getWidth()
    {
        return image.getWidth();
    }

    public int getHeight()
    {
        return image.getHeight();
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public BufferedImage getTile(int x, int y, int width, int height)
    {
        return image.getSubimage(x, y, width, height);
    }
}
