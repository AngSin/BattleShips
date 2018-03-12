import java.util.Arrays;
import java.lang.Math;

public class Board {
  public void display(char[][] Board) {
    // Decided to display the board instead of hiding it so it is easier to assess and check how the ships were placed
    int Row;
    int Column;

    System.out.println("  ¦ A B C D E F G H I J");
    System.out.println("--+--------------------");
    for (Row = 0; Row <= 9; Row++)
    {
        System.out.print(Integer.toString(Row) + " ¦ ");
        for (Column = 0; Column <= 9; Column++)
        {
            System.out.print(Board[Column][Row] + " ");
        }
        System.out.println();
    }

    System.out.println("\n");
  }
  
  public char[][] addShips(int[] ships, char[][] Grid) {
    System.out.println("setting up");
    char[][] currentGrid = Grid;
    char[][] newGrid = new char[10][10];
    int x, y;
    
    for (int shipIndex = 0; shipIndex < ships.length; shipIndex++) {
      // 1 is horizontal, 0 is vertical
      double horizontal = Math.round(Math.random());
      int length = ships[shipIndex];
      if (horizontal == 0) {
        x = (int) (Math.random() * (10));
        y = (int) (Math.random() * (11 - length));
        for (int i = 0; i < length; i ++) {
          if (!Character.isDigit(currentGrid[x][y + i])) {
            // Create unique chars for the ships so they are easily distinguishable
            newGrid[x][y + i] = Character.forDigit(shipIndex, 10);
          }
          else {
            // Ensures that a ship does not overlap with another one, if it does call the method again
            // (Because of improper spacing and graphical representation in the displayBoard() method, 
            //  it may seem that ships are overlapped but they're not).
            return addShips(ships, Grid);
          }
        }
      }
      else {
        y = (int) (Math.random() * (10));
        x = (int) (Math.random() * (11 - length));
        for (int i = 0; i < length; i ++) {
          if (!Character.isDigit(currentGrid[x + i][y])) {
            newGrid[x + i][y] = Character.forDigit(shipIndex, 10);
          }
          else {
            return addShips(ships, Grid);
          }
        }
      }
      currentGrid = newGrid;
    }
    return currentGrid;
  }
}