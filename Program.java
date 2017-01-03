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
		this.width = 30;
		this.height = 30;
	}
	
	void przesunGracza(int pozX, int pozY)
	{
		this.x += pozX;
		this.y += pozY;
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
class Bombka extends Ellipse2D.Float
{
	Bombka(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
	}
	
	void ustawBombe(float bPozX, float bPozY)
	{
		this.x = bPozX;
		this.y = bPozY;
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
	static int pozX = 40, pozY = 40;	
	private int szerokoscOkna = 680;
	private int wysokoscOkna = 520;
	static Player gracz = new Player(pozX, pozY);
	static float bPozX, bPozY;
	Bombka bombka = new Bombka(bPozX, bPozY);
	static int bomba;

	
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
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
        g2d.fill(gracz);
		for (Klocek cegla:Plansza.klocki)
			{
				g2d.fill(cegla);
			}
		if (bomba == 1)
		{
			g2d.fill(bombka);
		}
    }
    public void keyTyped(KeyEvent e) {        }
	
    public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyChar())
		{
				case 'k':
						{
						System.out.println("stawiam bombke");
						bomba = 1;
						bombka.ustawBombe(gracz.x+15, gracz.y + 40);						
						}		
						break;
                case 'w':
						gracz.przesunGracza(0, -5);
                        for (Klocek klocek:Plansza.klocki)
						{
							if(gracz.intersects(klocek)) gracz.przesunGracza(0,5);
						}
						break;
				case 's':
						gracz.przesunGracza(0, 5);
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.intersects(klocek))
							{										
								gracz.przesunGracza(0 , -5);
							}
						}
                        break;
                case 'a':
						gracz.przesunGracza(-5,0);
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.intersects(klocek))
							{										
								gracz.przesunGracza(5 , 0);
							}
						}
                        break;
                case 'd':
						gracz.przesunGracza(5,0);
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.intersects(klocek))
							{										
								gracz.przesunGracza(-5 , 0);
							}
						}
                        break;
        }
                repaint();
    }
    
	public void keyReleased(KeyEvent e) {		}

}