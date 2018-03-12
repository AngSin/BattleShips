import java.util.Scanner;

public class Player {
  public int hits = 0;
  public int misses = 0;
  public int x, y;
  Scanner scan = new Scanner(System.in);

  public int getHitCount() {
    return hits;
  }

  public int getMisses() {
    return misses;
  }

  public char[][] getCoordinates(char[][] Grid) {
    char[][] newGrid = Grid;
    System.out.println("Please enter a square to hit (for e.g. \"B7\"): ");
    String coords = scan.nextLine();
    if (coords.length() != 2) {
      // Programmers count from 0, cmon it just makes sense this way 
      // (Also decreases some boring exception dealing for me :p that doesn't show much skill anyway)
      System.out.println("Please enter an Alphabet followed by a digit from 0 to 9");
      return getCoordinates(Grid);
    }
    System.out.println(coords);
    switch (Character.toUpperCase(coords.charAt(0)))
      {
        case 'A':
          x = 0;
          break;
        case 'B':
          x = 1;
          break;
        case 'C':
          x = 2;
          break;
        case 'D':
          x = 3;
          break;
        case 'E':
          x = 4;
          break;
        case 'F':
          x = 5;
          break;
        case 'G':
          x = 6;
          break;
        case 'H':
          x = 7;
          break;
        case 'I':
          x = 8;
          break;
        case 'J':
          x = 9;
          break;
        default:
          System.out.println("Please enter an Alphabet followed by a digit from 0 to 9");
          getCoordinates(Grid);
          break;
      }
    y = Character.getNumericValue(coords.charAt(1));

    char target = Grid[x][y];

    if (target == 'X') {
      System.out.println("You already hit that mate!");
    }
    else if (!Character.isDigit(target)) {
      newGrid[x][y] = '.';
      misses++;
      System.out.println("Miss!");
    }
    else {
      newGrid[x][y] = 'X';
      hits++;
      //check if there is any more of the same ship units around the targeted square
      if (
        (x-1 < 0 || Grid[x-1][y] != target) &&
        (x+1 > 9 || Grid[x+1][y] != target) &&
        (y-1 < 0 || Grid[x][y-1] != target) &&
        (y+1 > 9 || Grid[x][y+1] != target)
      ) {
        System.out.println("Ship sunk!");
      }
      else {
        System.out.println("Hit!");
      }
    }
    return newGrid;
  }
}