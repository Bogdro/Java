import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

class Player extends Rectangle2D.Float
{
	Player(int pozX, int pozY)
	{
		this.x = pozX;
		this.y = pozY;
		this.width = 20;
		this.height = 20;
	}
}



public class Program extends JFrame implements KeyListener
{

	static int pozX = 50, pozY = 50;	
	private int szerokoscOkna = 640;
	private int wysokoscOkna = 480;
	
	public Program()
	{		
			addKeyListener(this);
			setResizable(false);                                                                        
            setTitle("Bomberman");                       
            setSize(szerokoscOkna,wysokoscOkna);                               
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
    public static void main(String[] args)                       
    {      
		Program okno = new Program(); 
		okno.setVisible(true);
    }
	
	public void paint(Graphics g) 
	{
		Player gracz = new Player(pozX, pozY);
        super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
        g2d.fill(gracz);
		//g.fillRect(10,10, 20, 20);
    }

    public void keyTyped(KeyEvent e) {        }
	
    public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyChar())
		{
                case 'w':
                        if ( pozY >= 40)
						{							
							pozY -= 5;
						}
						break;
				case 's':
                        if (pozY <= wysokoscOkna - 30)
						{							
							pozY += 5;
						}
                        break;
                case 'a':
                        if (pozX >= 10 )
						{
							pozX -= 5;
						}
                        break;
                case 'd':
                        if (pozX <= szerokoscOkna - 30)
						{
							pozX += 5;
						}
                        break;
        }
                repaint();
    }
    
	public void keyReleased(KeyEvent e) {		}

	}