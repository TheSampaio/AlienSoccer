package source.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Input implements KeyListener
{
    private static final Map<Keyboard, Boolean> keys = new HashMap<>();
    private static final Map<Keyboard, Boolean> lastKeys = new HashMap<>();

    public static boolean getKeyPress(Keyboard keyCode)
    {
        return keys.getOrDefault(keyCode, false);
    }

    public static boolean getKeyRelease(Keyboard keyCode)
    {
        return !keys.getOrDefault(keyCode, false);
    }

    public static boolean getKeyTap(Keyboard keyCode)
    {
        return keys.getOrDefault(keyCode, false) && !lastKeys.getOrDefault(keyCode, false);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Keyboard key = getKeyFromKeyCode(e.getKeyCode());

        if (key != null)
            keys.put(key, true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Keyboard key = getKeyFromKeyCode(e.getKeyCode());

        if (key != null)
            keys.put(key, false);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // Don't used yet
    }

    private Keyboard getKeyFromKeyCode(int keyCode)
    {
        for (Keyboard key : Keyboard.values())
        {
            if (key.getKeyCode() == keyCode)
                return key;
        }

        return null;
    }

    public void pollEvents()
    {
        lastKeys.clear();
        lastKeys.putAll(keys);
    }
}