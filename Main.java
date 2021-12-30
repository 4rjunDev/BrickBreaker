import javax.swing.*;
public class Main extends JFrame
{
    public Main()
    {
        Game game = new Game();
        this.setBounds(10,10,700,600);
        this.setVisible(true);
        this.add(game);
        this.setTitle("Brick Breaker!");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new Main();
    }
}