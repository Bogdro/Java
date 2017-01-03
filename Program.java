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
		this.width = 20;
		this.height = 20;
	}
}

class Klocek extends Rectangle2D.Float
{
	Klocek(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 20;
	}
}

class Plansza 
{
	static ArrayList<Klocek> klocki = new ArrayList<Klocek>();
	Plansza()
	{
		for (int i = 0; i < 24; i++)
		{
			Klocek kloc = new Klocek(0, i*20);
			klocki.add(kloc);
		}
		for (int i = 0; i < 24; i++)
		{
			Klocek kloc = new Klocek(620, i*20);
			klocki.add(kloc);
		}
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
				System.out.println("jestem w liscie");
				g2d.fill(cegla);
			}
		//g.fillRect(plansza);
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