import javax.swing.*;
import java.awt.*;
public class Panel03 extends JPanel
{
   
   public void paintComponent(Graphics g)
   {
   
      ImageIcon bg = new ImageIcon("background.jpg");
      g.drawImage(bg.getImage(), 0, 0, 1280, 720, null);
   
      g.setFont(new Font("Monospace",Font.BOLD, 60));
      g.setColor(new Color(236, 240, 241));
      g.drawString("Herndon Hornets", 400, 60);
      
      //Frame
      int xPoints[] = {480, 630, 780}; 
      int yPoints[] = {200, 100, 200}; 
      g.drawPolygon(xPoints, yPoints, 3);
      //End
      
      
      //Frame
      g.setColor(new Color(52, 73, 94));
      g.fillRect(480, 200, 300, 200);
      
       //IMG
      ImageIcon img = new ImageIcon("hornet_0.png");
      g.drawImage(img.getImage(), 480, 200, 300, 200, null);
      
      g.setColor(new Color(236, 240, 241));
      for(int x = 480; x <= 780; x += 10)
         g.drawLine(x, 200, x, 400);
   
      
     
      
      
      
      g.setFont(new Font("Monospace",Font.BOLD, 60));
      g.setColor(new Color(236, 240, 241));
      g.drawString("Herndon Hornets", 400, 660);  
      
      
      
    
      
   }
   
}