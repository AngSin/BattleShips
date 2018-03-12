import java.util.stream.IntStream;

public class BattleShips {
  public static void main(String[] args) {
    System.out.println("Welcome to BattleShips 1.0!");
    // A blank grid
    char[][] Grid = new char[10][10];
    // 2 destroyers and 1 ship
    int[] shipLengths = {4,4,5};
    int totalShipLength = IntStream.of(shipLengths).sum();
    Player player = new Player();
    Board board = new Board();
    System.out.println("Total ship units to hit: " + totalShipLength);
    // replace existing grid with a grid that has the ships placed
    Grid = board.addShips(shipLengths, Grid);
    // display the grid and ask for player coordinates till the total number of ship units hit is not reached
    while(player.getHitCount() < totalShipLength) {
      board.display(Grid);
      Grid = player.getCoordinates(Grid);
    }
    //Display one last time to show the full grid but not ask the user for input.
    board.display(Grid);
    System.out.println("Congratulations, you sunk all the ships!");
    System.out.println("Summary: You missed " + player.getMisses() + " times.");
  }
}