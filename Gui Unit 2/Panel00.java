import javax.swing.*;
import java.awt.*;
public class Panel00 extends JPanel
{
   private JLabel label1;
   public Panel00( )
   {
      setLayout (new FlowLayout( ));
      label1 = new JLabel("My first label");
      add(label1);
   }
}
