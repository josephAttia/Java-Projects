import javax.swing.JFrame;
public class Driver02
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lab02");
      frame.setSize(450, 350);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel02());
      frame.setVisible(true);
   }
}
