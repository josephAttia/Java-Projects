import javax.swing.*;
import java.awt.*;
public class Panel01 extends JPanel
{

   private JLabel northLabel;
   private JLabel southLabel;
   private JLabel eastLabel;
      public Panel01( )
   {
      setLayout(new BorderLayout());
      
     //North Label
     northLabel = new JLabel("North"); 
     add(northLabel);
     northLabel.setVerticalAlignment(SwingConstants.TOP);
     northLabel.setHorizontalAlignment(SwingConstants.CENTER);
     
     //South Label
     southLabel = new JLabel("South"); 
     add(southLabel);
     southLabel.setVerticalAlignment(SwingConstants.BOTTOM);
     southLabel.setHorizontalAlignment(SwingConstants.CENTER);
     
     //East Label
     eastLabel = new JLabel("East"); 
     add(eastLabel);
     eastLabel.setVerticalAlignment(SwingConstants.CENTER);
     eastLabel.setHorizontalAlignment(SwingConstants.RIGHT);

   }
}
