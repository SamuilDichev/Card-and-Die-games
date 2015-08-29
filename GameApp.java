// Import specifically only the things we need. It's good practice.
// Helps prevent namespace interference.
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameApp {
  public static void main(String[] args) throws Exception {
    gameFactory factory = new gameFactory();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Some exception handling
    try {
      // Keep asking as long as the input is wrong.
      while (true) {
        System.out.print("Card (c) or Die (d) game? ");
        String ans = br.readLine();

        // .toLowerCase() to prevent case sensitivity
        if (ans.toLowerCase().equals("c") || ans.toLowerCase().equals("d")) {
          Game g = factory.createGame(ans);
          g.play();

          // Set custom msg
          if (g.hasWon()) {
            System.out.println("You won!");
          } else {
            System.out.println("You lost!");
          }

          // If input were wrong, this loop wouldn't have been executed. 
          // Break out of the loop if a game has been played.
          break;
        }

        else {
          System.out.println("Input not understood");
        }
      }
    }

    // Do something with it, if an exception is thrown.
    catch (Exception ex) {
      System.out.println("Ops, error: " + ex);
    }
  }
}

