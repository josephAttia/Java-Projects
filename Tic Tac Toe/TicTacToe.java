import java.util. * ;
public class TicTacToe {
   public static String[][] makeBoard() {
      String[][] board = new String[3][3];
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
            board[i][j] = "-";
         }
      }
      return board;
   }

   public static String[][] clearBoard(String[][] board) {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
            board[i][j] = "-";
         }
      }
      return board;
   }

   public static void printBoard(String board[][]) {
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[0].length; c++) {
            System.out.print(board[r][c] + "   ");
         }
         System.out.println();
      }
   
   }

   public static String switchPlayer(String currentPlayer) {
      String newPlayer = " ";
      if (currentPlayer.equals("X")) {
         newPlayer = "O";
      }
      else if (currentPlayer.equals("O")) {
         newPlayer = "X";
      }
      return newPlayer;
   }

   public static String checkWinnerRow(String[][] board) { //check rows
      int xCount = 0,
         oCount = 0;
      String winner = "";
      for (int r = 0; r < board.length; r++) {
         xCount = 0;
         oCount = 0;
         for (int c = 0; c < board[0].length; c++) {
            if (board[r][c].equals("X")) xCount++;
            if (board[r][c].equals("O")) oCount++;
         }
         if (xCount == 3) {
            winner = "X";
         }
         if (oCount == 3) {
            winner = "O";
         }
      }
      return winner;
   }

   public static String checkWinnerCol(String[][] board) { //check rows
      int xCount = 0,
         oCount = 0;
      String winner = "";
      for (int c = 0; c < board[0].length; c++) {
         xCount = 0;
         oCount = 0;
         for (int r = 0; r < board.length; r++) {
            if (board[r][c].equals("X")) xCount++;
            if (board[r][c].equals("O")) oCount++;
         }
         if (xCount == 3) winner = "X";
         if (oCount == 3) winner = "O";
      }
      return winner;
   }
   public static boolean checkSpace(String[][] board, int row, int col){
      boolean res = true;
      if(board[row - 1][col - 1].equals("X") || board[row - 1][col - 1].equals("O")){
         res = true;
      }
      else {
         res = false;
      }
      return  res;
   }
   public static String checkWinnerDag(String[][] board) { //check rows
      int xCount = 0,
         oCount = 0;
      String winner = "";
      for (int c = 0; c < board[0].length; c++) {
         xCount = 0;
         oCount = 0;
         for (int r = 0; r < board.length; r++) {
            if (board[r][r].equals("X")) xCount++;
            if (board[r][r].equals("O")) oCount++;
         }
         if (xCount == 3) winner = "X";
         if (oCount == 3) winner = "O";
      }
      return winner;
   }

   public static String checkWinnerDag2(String[][] board) { //check rows
      int xCount = 0,
         oCount = 0;
      String winner = "";
      xCount = 0;
      oCount = 0;
      int c = board[0].length - 1;
      for (int r = 0; r < board.length; r++) {
         if (board[r][c].equals("X")) xCount++;
         if (board[r][c].equals("O")) oCount++;
         c--;
      }
   
      if (xCount == 3) winner = "X";
      if (oCount == 3) winner = "O";
        
      return winner;
   }

   public static boolean isTaken(String[][] board, int row, int col){
      boolean res = true;
      if(board[row-1][col-1].equals("O") || board[row-1][col-1].equals("X")){
         res = true;
      }
      else{
         res =false;
      }
      return res;
   }


   public static boolean isFilled(String[][] board) {
      boolean res = true;
      int count = 0;
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[0].length; c++) {
            if (board[r][c].equals("X") || board[r][c].equals("O")) {
               count++;
            }
         }
      }
      if (count == 9) {
         res = true;
      }
      else {
         res = false;
      }
      return res;
   }

   public static String[][] playMove(String[][] board, int row, int col, String playerChar) {
      board[row - 1][col - 1] = playerChar;
      return board;
   }

   public static void main(String[] args) {
      String playAgain = "y";
      String[][] board = makeBoard();
   
      String player = "X";
      while (playAgain.equals("y")) {
         printBoard(board);
         Scanner sc = new Scanner(System. in );
      
         System.out.println(player + "s turn");
         int row = 0;
         System.out.print("Row #:");
         row = sc.nextInt();
      
         int column = 0;
         System.out.print("Column #:");
         column = sc.nextInt();
         if((row > 0 && row <= 3) && (column > 0 && column <= 3)){
            while(isTaken(board, row, column)){
               System.out.println("Sorry this slot is already taken");
               System.out.print("Row #:");
               row = sc.nextInt();
               System.out.print("Column #:");
               column = sc.nextInt();
            }
         }
         while ((row < 0 && row > 3) || (column < 0 && column > 3)) {
            System.out.println("Invalid input; re-enter slot number:");
            System.out.print("Row #:");
            row = sc.nextInt();
            System.out.print("Column #:");
            column = sc.nextInt();
         }
      
         if((row > 0 && row <= 3) && (column > 0 && column <= 3)){
            playMove(board, row, column, player);
            player = switchPlayer(player);
            String winnerRow = checkWinnerRow(board);
            String winnerCol = checkWinnerCol(board);
            String winnerDag = checkWinnerDag(board);
            String winnerDag2 = checkWinnerDag2(board);
         
            if (winnerRow.equals("X")) {
               System.out.println("X Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
            else if (winnerRow.equals("O")) {
               System.out.println("O Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
         
            if (winnerCol.equals("X")) {
               System.out.println("X Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
            else if (winnerCol.equals("O")) {
               System.out.println("O Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
         
            if (winnerDag.equals("X")) {
               System.out.println("X Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
            else if (winnerDag.equals("O")) {
               System.out.println("O Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
         
            if (winnerDag2.equals("X")) {
               System.out.println("X Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
            else if (winnerDag2.equals("O")) {
               System.out.println("O Won!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
            if (isFilled(board)) {
				printBoard(board);
               System.out.println("Draw!");
               clearBoard(board);
               System.out.print("Play Again:");
               playAgain = sc.next();
            }
         }
      }
   }
}
