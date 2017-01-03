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
    }

    public void keyTyped(KeyEvent e) {        }
	
    public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyChar())
		{
                case 'w':
						System.out.println("gracz");
						System.out.println(gracz.x);
						
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.y == klocek.y +40 && gracz.x < klocek.x + 30 && gracz.x > klocek.x - 30)
							{					
								System.out.println("klocek");
								System.out.println(klocek.x);						
								gracz.przesunGracza(0 , 5);
							}
						}
						gracz.przesunGracza(0, -5);
						break;
				case 's':
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.y == klocek.y -30 && gracz.x < klocek.x + 30 && gracz.x > klocek.x - 30)
							{					
								System.out.println("klocek");
								System.out.println(klocek.x);						
								gracz.przesunGracza(0 , -5);
							}
						}
						gracz.przesunGracza(0, 5);
                        break;
                case 'a':
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.x == klocek.x +40 && gracz.y < klocek.y + 30 && gracz.y > klocek.y - 30)
							{					
								System.out.println("klocek");
								System.out.println(klocek.x);						
								gracz.przesunGracza(5 , 0);
							}
						}
						gracz.przesunGracza(-5, 0);
                        break;
                case 'd':
                        for (Klocek klocek:Plansza.klocki)
						{
							
							if (gracz.x == klocek.x -30 && gracz.y < klocek.y + 30 && gracz.y > klocek.y - 30)
							{					
								System.out.println("klocek");
								System.out.println(klocek.x);						
								gracz.przesunGracza(-5 , 0);
							}
						}
						gracz.przesunGracza(5, 0);
                        break;
        }
                repaint();
    }
    
	public void keyReleased(KeyEvent e) {		}

}