import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
public class Game extends JPanel implements ActionListener, KeyListener
{
    private boolean start = false;
    private int score = 0;
    private int bricks = 25;
    
    private Timer time;
    private int wait = 8;
    
    private int platformPosition = 310;
    
    private int ballPositionX = 120;
    private int ballPositionY = 350;
    private int ballDirectionX = -1;
    private int ballDirectionY = -2;
    
    private Bricks brickCreator;
    public Game()
    {
        brickCreator = new Bricks(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(wait, this);
        time.start();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        
        //layout
        brickCreator.draw((Graphics2D) g);
        
        //borders
        g.setColor(Color.blue);
        g.fillRect(0, 0,  3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        //platform
        g.setColor(Color.yellow);
        g.fillRect(platformPosition, 550, 100, 8);
        
        //ball
        g.setColor(Color.pink);
        g.fillOval(ballPositionX, ballPositionY, 20, 20);
        
        g.dispose();
    }
    public void actionPerformed(ActionEvent e)
    {
        time.start();
        if(start)
        {
            if(new Rectangle(ballPositionX, ballPositionY, 20, 20).intersects(new Rectangle(platformPosition, 550, 100, 8)))
            {
                ballDirectionY = -ballDirectionY;
            }
            
            ballPositionX += ballDirectionX;
            ballPositionY += ballDirectionY;
            
            if (ballPositionX < 0)
            {
                ballDirectionX = -ballDirectionX;
            }
            
            if (ballPositionY < 0)
            {
                ballDirectionY = -ballDirectionY;
            }
            
            if (ballPositionX < 670)
            {
                ballDirectionX = -ballDirectionX;
            }
        }
        repaint();
    }

    @Override public void keyTyped( KeyEvent e ){}

    public void keyPressed (KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if (platformPosition > 600)
            {
                platformPosition = 600;
            }
            else
            {
                shiftRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if (platformPosition < 10)
            {
                platformPosition = 10;
            }
            else
            {
                shiftLeft();
            }
        }
    }
    
    @Override public void keyReleased( KeyEvent e ){}
    
    public void shiftRight()
    {
        start = true;
        platformPosition += 20;
    }

    public void shiftLeft()
    {
        start = true;
        platformPosition -= 20;
    }    
}