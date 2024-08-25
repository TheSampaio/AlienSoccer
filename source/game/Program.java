package source.game;

public class Program
{
    public static void main(String[] args)
    {
        Sandbox game = new Sandbox();
        new Thread(game).start();
    }
}
