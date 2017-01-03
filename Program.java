import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Program extends JFrame implements KeyListener
{
	private int pozX = 30;
    private int pozY = 50;
	
	public Program()
	{		
			 addKeyListener(this);
			setResizable(false);                                                                        
            setTitle("Bomberman");                       
            setSize(640,480);                               
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
    public static void main(String[] args)                       
    {        
		Program okno = new Program(); 
		okno.setVisible(true);
    }
	
	public void paint(Graphics g) 
	{
        super.paint(g);
        g.fillOval(pozX, pozY, 20, 20);
    }

    public void keyTyped(KeyEvent e) {        }
	
    public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyChar())
		{
                case 'w':
                        pozY -= 5;
                        break;
                case 's':
                        pozY += 5;
                        break;
                case 'a':
                        pozX -= 5;
                        break;
                case 'd':
                        pozX += 5;
                        break;
        }
                repaint();
    }
    
	public void keyReleased(KeyEvent e) {		}

	}