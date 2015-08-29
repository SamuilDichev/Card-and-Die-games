// Import specifically only the things we need. It's good practice.
// Helps prevent namespace interference.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

// Implements my newly created interface Game.java
public class DieGame implements Game {
	private HashSet<Integer> userChoice;
	private LinearCongruentialGenerator r;
	private BufferedReader br;

	public DieGame() {
		userChoice = new HashSet<Integer>();
	}


	public void play() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		r = new LinearCongruentialGenerator();

		for (int i = 0; i < 2; i++) {
			System.out.println("Hit <RETURN> to roll the die");
			br.readLine();
			int dieRoll = (int)(r.next() * 6) + 1;

			System.out.println("You rolled " + dieRoll);
			userChoice.add(new Integer(dieRoll));
		}

		System.out.println("Numbers rolled: " + userChoice);
	}

	// Check if user has won and return bool.
	public boolean hasWon() {
		boolean won;
		if (userChoice.contains(new Integer(1))) {
			won = true;
		} else {
			won = false;
		}

		return won;
	}
}