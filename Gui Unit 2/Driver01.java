import javax.swing.*;
import java.awt.*;
public class Driver01
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Panel 1");
      frame.setSize(500, 500);
      frame.setLocation(200, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel01());
      frame.setVisible(true);
   }
}
