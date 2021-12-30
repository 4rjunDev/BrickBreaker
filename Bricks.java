import java.awt.*;
public class Bricks
{
    public int layout[][];
    public int width;
    public int height;
    public Bricks(int row, int col)
    {
        layout = new int[row][col];
        for (int i = 0; i < layout.length; i++)
        {
            for (int j = 0; j < layout[0].length; j++)
            {
                layout[i][j] = 1;
            }
        }
        width = 540/col;
        height = 150/row;
    }
    public void draw(Graphics2D g)
    {
        for (int i = 0; i < layout.length; i++)
        {
            for (int j = 0; j < layout[0].length; j++)
            {
                if(layout[i][j] > 0)
                {
                    g.setColor(Color.white);
                    g.fillRect(j * width + 80, i * height + 50, width, height);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * width + 80, i * height + 50, width, height);
                }
            }
        }
    }
}