import javax.swing.JFrame;
public class Driver03
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lab00");
      frame.setSize(1280, 720);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel03());
      frame.setVisible(true);
   }
}
