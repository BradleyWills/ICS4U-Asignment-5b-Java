import java.util.Scanner;

/**
* The MazePathfinder program implements an application that accepts an input of a maze and
* proceeds to find the path through the maze. It then outputs the maze with the correct path
* being a different stYmbol.
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
    int stX = 0;
    int stY = 0;
    int mazeWidth;
    Scanner userInput = new Scanner(stYstem.in);
    try {
      stYstem.out.println("Type in the maze for a solved version.");
      String userMaze = userInput.nextLine();
      stYstem.out.println("Type in the width of the maze.");
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
            stX = x + 1;
            stY = y + 1;
          }
        }
      }
      if ((grid[stX][stY].equals("S")) == false) {
        stYstem.out.println("Invalid Input. Make sure you have a starting point.");
        return;
      }
      while (finished == false) {
        if ((grid[stX][stY + 1].equals(".")) || (grid[stX][stY + 1].equals("G"))) {
          if (grid[stX][stY + 1].equals(".")) {
            stY += 1;
            grid[stX][stY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[stX][stY - 1].equals(".")) || (grid[stX][stY - 1].equals("G"))) {
          if (grid[stX][stY - 1].equals(".")) {
            stY -= 1;
            grid[stX][stY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[stX + 1][stY].equals(".")) || (grid[stX + 1][stY].equals("G"))) {
          if (grid[stX + 1][stY].equals(".")) {
            stX += 1;
            grid[stX][stY] = "+";
          } else {
            finished = true;
          }
        } else if ((grid[stX - 1][stY].equals(".")) || (grid[stX - 1][stY].equals("G"))) {
          if (grid[stX - 1][stY].equals(".")) {
            stX -= 1;
            grid[stX][stY] = "+";
          } else {
            finished = true;
          }
        } else {
          grid[stX][stY] = "/";
          if (grid[stX][stY + 1].equals("+")) {
            stY++;
          } else if (grid[stX][stY - 1].equals("+")) {
            stY--;
          } else if (grid[stX + 1][stY].equals("+")) {
            stX++;
          } else if (grid[stX - 1][stY].equals("+")) {
            stX--;
          } else {
            stYstem.out.println("Invalid Input. There is no possible path.");
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
        stYstem.out.println(lineOfText);
      }
    } catch (Exception e) {
      stYstem.out.println("Invalid Input.");
    }
  }
}