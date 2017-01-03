import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

class Player extends Ellipse2D.Float
{
	Player(int pozX, int pozY)
	{
		this.x = pozX;
		this.y = pozY;
		this.width = 40;
		this.height = 40;
	}
}

class Klocek extends Rectangle2D.Float
{
	Klocek(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 40;
	}
}



class Plansza 
{
	static ArrayList<Klocek> klocki = new ArrayList<Klocek>();
	Plansza()
	{
		for (int i = 0; i < 13; i++)
		{
			Klocek kloc = new Klocek(0, i*40);
			klocki.add(kloc);
		}
		for (int i = 0; i < 13; i++)
		{
			Klocek kloc = new Klocek(640, i*40);
			klocki.add(kloc);
		}
		for (int i = 0; i < 17; i++)
		{
			Klocek kloc = new Klocek(i*40, 0);
			klocki.add(kloc);
		}
		
		for (int i = 0; i < 17; i++)
		{
			Klocek kloc = new Klocek(i*40, 480);
			klocki.add(kloc);
		}
		for (int j = 0; j < 5; j++)
			for (int i = 0; i < 7; i++)
			{
				Klocek kloc = new Klocek(i*80+80, 80+80*j);
				klocki.add(kloc);
			}
			
			
	}
}

public class Program extends JFrame implements KeyListener
{
	static int pozX = 100, pozY = 0;	
	private int szerokoscOkna = 680;
	private int wysokoscOkna = 520;
	
	public Program()
	{		
			addKeyListener(this);
			setResizable(false);                                                                        
            setTitle("Bomberman");                       
            setSize(szerokoscOkna,wysokoscOkna);
			setUndecorated(true);			
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
    public static void main(String[] args)                       
    {      
		Program okno = new Program(); 
		okno.setVisible(true);
		Plansza plansza = new Plansza();
    }
	
	public void paint(Graphics g) 
	{
		Player gracz = new Player(pozX, pozY);
        super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
        g2d.fill(gracz);
		for (Klocek cegla:Plansza.klocki)
			{
				g2d.fill(cegla);
			}
    }

    public void keyTyped(KeyEvent e) {        }
	
    public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyChar())
		{
                case 'w':
                        if ( pozY >= 55)
						{							
							pozY -= 5;
						}
						break;
				case 's':
                        if (pozY <= wysokoscOkna - 45)
						{							
							pozY += 5;
						}
                        break;
                case 'a':
                        if (pozX >= 25 )
						{
							pozX -= 5;
						}
                        break;
                case 'd':
                        if (pozX <= szerokoscOkna - 45)
						{
							pozX += 5;
						}
                        break;
        }
                repaint();
    }
    
	public void keyReleased(KeyEvent e) {		}

}