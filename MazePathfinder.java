import java.util.Scanner;

/**
* The MazePathfinder program implements an application that accepts an input of a maze and
* proceeds to find the path through the maze. It then outputs the maze with the correct path
* being a different symbol.
*
* @author  Bradley Wills
* @version 1.0
* @since   2020-05-27
*/

public class MazePathfinder {
  
  /**
  * Accepts the maze and solves it.
  */
  
  public static void main(String[] args) {
    
    boolean finished = false;
    int sX = 0;
    int sY = 0;
    int mazeWidth;
    Scanner userInput = new Scanner(System.in);
    try {
      System.out.println("Type in the maze for a solved version.");
      String userMaze = userInput.nextLine();
      System.out.println("Type in the width of the maze.");
      // 6
      mazeWidth = userInput.nextInt();
      String[][] grid = new String[mazeWidth + 2][(userMaze.length() / mazeWidth) + 2];
      for (int a = 0; a <= mazeWidth + 1; a++) {
        for (int b = 0; b <= (userMaze.length() / mazeWidth) + 1; b++) {
          grid[a][b] = "#";
        }
      }
      for (int y = 0; y <= (userMaze.length() / mazeWidth) - 1; y++) {
        for (int x = 0; x <= mazeWidth - 1; x++) {
          grid[x + 1][y + 1] = String.valueOf(userMaze.charAt(y * mazeWidth + x));
          if (String.valueOf(userMaze.charAt(y * mazeWidth + x)).equals("S")) {
            sX = x + 1;
            sY = y + 1;
          }
        }
      }
      if (grid[sX][sY].equals("S")) {
      } else {
        System.out.println("Invalid Input. Make sure you have a starting point.");
        return;
      }
      while (finished == false) {
        if ((grid[sX][sY + 1].equals(".")) || (grid[sX][sY + 1].equals("G"))) {
          if (grid[sX][sY + 1].equals(".")) {
            sY += 1;
            grid[sX][sY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[sX][sY - 1].equals(".")) || (grid[sX][sY - 1].equals("G"))) {
          if (grid[sX][sY - 1].equals(".")) {
            sY -= 1;
            grid[sX][sY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[sX + 1][sY].equals(".")) || (grid[sX + 1][sY].equals("G"))) {
          if (grid[sX + 1][sY].equals(".")) {
            sX += 1;
            grid[sX][sY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[sX - 1][sY].equals(".")) || (grid[sX - 1][sY].equals("G"))) {
          if (grid[sX - 1][sY].equals(".")) {
            sX -= 1;
            grid[sX][sY] = "+";
          } else {
            finished = true;
          }
        } else {
          grid[sX][sY] = "/";
          if (grid[sX][sY + 1].equals("+")) {
            sY++;
          } else if (grid[sX][sY - 1].equals("+")) {
            sY--;
          } else if (grid[sX + 1][sY].equals("+")) {
            sX++;
          } else if (grid[sX - 1][sY].equals("+")) {
            sX--;
          } else {
            System.out.println("Invalid Input. There is no possible path.");
            return;
          }
        }
      }
      for (int a = 0; a <= mazeWidth + 1; a++) {
        for (int b = 0; b <= (userMaze.length() / mazeWidth) + 1; b++) {
          if (grid[a][b].equals("/")) {
            grid[a][b] = ".";
          }
        }
      }
      String lineOfText;
      for (int b = 1; b <= (userMaze.length() / mazeWidth); b++) {
        lineOfText = "";
        for (int a = 1; a <= mazeWidth; a++) {
          lineOfText += grid[a][b];
        }
        System.out.println(lineOfText);
      }
    } catch (Exception e) {
      System.out.println("Invalid Input.");
    }
  }
}