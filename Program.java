import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

class Kulka extends Ellipse2D.Float
{
   Plansza p;
   int dx,dy;
   public int Punkty;
   
   Kulka(Plansza p,int x,int y,int dx,int dy) 
   {                                          
      this.x=x;                               
      this.y=y;                               
      this.width=10;                          
      this.height=10;                         
                                              
      this.p=p;                               
      this.dx=dx;                             
      this.dy=dy;                             
   }                                          
   
   void nextKrok()                                        
   {                                                     
      x+=dx;                                             
      y+=dy;                                             
                                                         
      if(getMinX()<0 || getMaxX()>p.getWidth())  dx=-dx; 
      if(getMinY()<0 || getMaxY()>p.getHeight()) dy=-dy; 
                                                         
      p.repaint();
		
	  if (this.intersects(p.b.getBounds2D()))
	  {
		  this.dy *= -1;
	  }
	  
	  for (Cegielki cegla:p.cegly)
	  { if (this.intersects(cegla.getBounds2D()))
		{
		  this.dy *= -1;
		  Punkty += 1;
		  p.cegly.remove(cegla);
		  break;
		}
	  }	 
		System.out.println(y);
   }                                                     
}

class SilnikKulki extends Thread
{
   Kulka a;
   
   SilnikKulki(Kulka a) 
   {                    
      this.a=a;         
      start();          
   }                    
   
   public void run()                   
   {                                  
      try                             
      {                               
         while(true)                  
         {                            
            a.nextKrok();             
            sleep(15);                
         }                            
      }                               
      catch(InterruptedException e){} 
   }                                  
}

class Belka extends Rectangle2D.Float
{
   Belka(int x)       
   {
      this.x=x;       
      this.y=200;     
      this.width=60;  
      this.height=10; 
   }                  
   
   void setX(int x) 
   {                
      this.x=x;     
   }                
}
class Cegielki extends Rectangle2D.Float
{
   Cegielki(int x, int y)       
   {
      this.x=x;       
      this.y=y;     
      this.width=20;  
      this.height=10; 
   }                                
}

class Plansza extends JPanel implements MouseMotionListener
{
   Belka b;
   Kulka a;
   ArrayList<Cegielki> cegly = new ArrayList<Cegielki>();
   SilnikKulki s;
   String Punk;
   
   Plansza()                         
   {                                 
      super();                       
      addMouseMotionListener(this);
	                                
      b=new Belka(100);              
      a=new Kulka(this,100,100,1,1); 
      s=new SilnikKulki(a); 
	  spawnCegiel();
   }

   void spawnCegiel()
   {
	   Cegielki ce;
	   for (int i=0; i<16; i++)
	   {
		   for (int j=0; j<5; j++)
		   {
		    ce = new Cegielki(30+i*22, 50+j*20);
			cegly.add(ce);
		   }
	   }
   }   
   
   public void paintComponent(Graphics g) 
   {                                      
      super.paintComponent(g);            
      Graphics2D g2d=(Graphics2D)g;       
      
		if (cegly.size() > 0 && a.y < 210)
		{
			g2d.fill(a);                        
			g2d.fill(b);
			g2d.drawString("Punkty : " + a.Punkty,10,10);
			for (Cegielki cegla:this.cegly)
			{
				g2d.fill(cegla);
			}
		}
	  
	  if (cegly.size() == 0)
	  {
		  g2d.drawString("Koniec",100,100);
		  a.y = 10;
	  }
	  if (a.y >= 210)
	  {
		  a.y = 230;
		  g2d.drawString("Przegrales",100,100);
	  }
   }                                      
   
   public void mouseMoved(MouseEvent e) 
   {                                    
      b.setX(e.getX()-50);              
      repaint();                        
   }                                    
   
   public void mouseDragged(MouseEvent e) 
   {                                      
                                          
   }                                      
}

public class Program
{
   public static void main(String[] args)                       
   {                                                           
      javax.swing.SwingUtilities.invokeLater(new Runnable()    
      {                                                        
         public void run()                                     
         {                                                     
            Plansza p;                                         
            p=new Plansza();                                   
                                                               
            JFrame jf=new JFrame();
			jf.setResizable(false);
            jf.add(p);                                         
                                                               
            jf.setTitle("Test grafiki");                       
            jf.setSize(400,370);                               
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            jf.setVisible(true);                               
         }                                                     
      });                                                      
   }                                                           
}