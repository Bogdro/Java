import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;





public class Program
{
   public static void main(String[] args)                       
   {                                                           
      javax.swing.SwingUtilities.invokeLater(new Runnable()    
      {                                                        
         public void run()                                     
         {                                                                                                                 
            JFrame jf=new JFrame();
			jf.setResizable(false);                                                                        
            jf.setTitle("Bomberman");                       
            jf.setSize(640,480);                               
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            jf.setVisible(true);                               
         }                                                     
      });                                                      
   }                                                           
}