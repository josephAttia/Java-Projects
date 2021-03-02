import javax.swing.*;
import java.awt.*;
public class Panel04 extends JPanel
{
   public void paintComponent(Graphics g)
   {       
      //BG
      g.setColor(new Color(44, 62, 80));
      g.fillRect(0, 0, 1280, 720);
      
      
      //Ground
      g.setColor(new Color(46, 204, 113));  
      g.fillRect(0,500,1280,500); 
      
      //Snow
      g.setColor(new Color(255,255,255));
      g.fillRect(0, 500, 1280, 50);
      
      int x[] = {150,300,225};
      int y[] = {300,300,175};
      
      g.setColor(new Color(192, 57, 43));
      g.fillRect(150,300,150,200);
      
      g.setColor(new Color(47, 53, 66));
      g.fillRect(200,350,50,150);
      g.drawOval(200,225,50,50);
      g.setColor(new Color(236, 204, 104));
      g.fillPolygon(x,y,3);  
      
      g.setColor(new Color(255,255,255));
      g.fillOval(800, 100, 100, 100);	
      
      g.setColor(new Color(44, 62, 80));
      g.fillOval(850, 100, 100, 100);	
      
      ImageIcon img = new ImageIcon("santa.png");
      g.drawImage(img.getImage(), 400, 100, 300, 200, null);
      
      g.setColor(new Color(255, 255, 255));
      for(int v = 0; v <= 1280; v += 100)
         for(int b = 0; b <= 720; b += 100)
         g.fillOval(v, b, 10, 10);
                               
   }
}