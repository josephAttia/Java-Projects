import javax.swing.*;
import java.awt.*;
public class Panel00modify extends JPanel
{
   public void paintComponent(Graphics g)
   {
      g.setColor(new Color(52, 73, 94));
      g.fillRect(0,0,1280,720);
      //Title
      g.setFont(new Font("Monospace",Font.BOLD, 25));
      g.setColor(new Color(236, 240, 241));
      g.drawString("Programming Motivation", 450, 30);  
      
      //#1
      g.setFont(new Font("Serif" ,Font.ITALIC, 15));
      g.setColor(Color.MAGENTA);
      g.drawString("“Talk is cheap. Show me the code.”", 450, 200);
      g.drawString("-Linus Torvalds", 450, 250);  
      
      //#2
      g.setFont(new Font("Palatino" ,Font.BOLD | Font.ITALIC, 20));
      g.setColor(new Color(52, 152, 219));
      g.drawString("“Programs must be written for people to read", 450, 340);
      g.drawString(" and only incidentally for machines to execute.”", 450, 365);
      g.drawString("-Unkown", 450, 385);  
      
       //#3
      g.setFont(new Font("Tahoma" ,Font.PLAIN, 35));
      g.setColor(new Color(231, 76, 60));
      g.drawString("“I'm not a great programmer;", 450, 450);
      g.drawString("I'm just a good programmer with great habits.”", 450, 480);
      g.drawString("-Kent Beck", 450, 510);  
      
      
      
   }
}
