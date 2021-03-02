import java.awt.Color;

public class SandUtilities
{
  //pre : c!= null
  //post: returns the inverted color from the one sent as c
   public static Color invert(Color c)
   {
      Color invertedColor = new Color(255, 0, 0, 100);
      int r = 0, g = 0, b = 0;
      if(c != null){
         r = 255 - c.getRed();
         g = 255 - c.getGreen();
         b = 255 - c.getBlue();
         invertedColor = new Color(r, g, b, 100);
      }
      return invertedColor;  
   }
   
   //pre:   m!= null
   //post:  for each non-null element of m, changes it to its inverted color
   //       skips any color with the value skip1 and skip2, leaving them unchanged
   public static void invertColors(Color[][]m, Color skip1, Color skip2)
   {
      if(m != null){
      for(int i=0; i< m.length; i++) {
            for(int j=0; j< m[i].length; j++) {
                  if(m[i][j] != null && m[i][j] != skip1 && m[i][j] != skip2){
                     invert(m[i][j]);
                  }
               }
         }
      }
   }
   
   //pre:   m is a square 2-D array (m.length==m[0].length)
   //post:  flips the array upside down
   public static void flipUpsideDown(Object[][]m)
   {
      if(m != null){
      for(int i = 0; i < (m.length / 2); i++){
         Object[] temp = m[i];
         m[i] = m[m.length - i - 1];
         m[m.length - i - 1] = temp;
      }
      }
   }
   
   //pre:   m is a square 2-D array (m.length==m[0].length)
   //post:  rotates the array 90 degrees to the left
   public static void rotateLeft(Object[][] m) 
   {
    Object[][] newArray = new Object[m.length][m[0].length];
    for(int r = 0; r < m.length; r++)
    {
        for(int c = 0; c < m[0].length; c++)
        {
            newArray[(m.length - 1) - c][r] = m[r][c];
        }
    }
    for(int i = 0; i < newArray.length; i++){
      for(int col = 0; col < newArray[0].length; col++){
         m[i][col] = newArray[i][col];
      }
    }
   }

   //pre:   m is a square 2-D array (m.length==m[0].length)
   //post:  rotates the array 90 degrees to the right
   public static void rotateRight(Object[][] m)
   {
      int M = m.length;
      int N = m[0].length;
      Object[][] ret = new Object[N][M];
      for (int r = 0; r < M; r++) {
         for (int c = 0; c < N; c++) {
            ret[c][M-1-r] = m[r][c];
        }
    }

    for(int i = 0; i < ret.length; i++){
      for(int col = 0; col < ret[0].length; col++){
         m[i][col] = ret[i][col];
      }
    }
   }      
}