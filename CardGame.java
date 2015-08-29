// Import specifically only the things we need. It's good practice.
// Helps prevent namespace interference.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

// Interface I made called Game
public class CardGame implements Game {
	private ArrayList<String> cardList;
	private HashSet<String> userChoice;
	private LinearCongruentialGenerator r;
	private BufferedReader br;

	public CardGame() {
		String cards[]={"AHrts", "2Hrts", "3Hrts", "4Hrts", "5Hrts", "6Hrts",
						"7Hrts", "8Hrts", "9Hrts", "10Hrts", "JHrts",
						"QHrts", "KHrts",
						"ADmnds", "2Dmnds", "3Dmnds", "4Dmnds", "5Dmnds",
						"6Dmnds", "7Dmnds", "8Dmnds", "9Dmnds", "10Dmnds",
						"JDmnds", "QDmnds", "KDmnds",
						"ASpds", "2Spds", "3Spds", "4Spds", "5Spds", "6Spds",
						"7Spds", "8Spds", "9Spds", "10Spds", "JSpds",
						"QSpds", "KSpds",
						"AClbs", "2Clbs", "3Clbs", "4Clbs", "5Clbs", "6Clbs",
						"7Clbs", "8Clbs", "9Clbs", "10Clbs", "JClbs",
						"QClbs", "KClbs"};


		cardList = new ArrayList<String> (Arrays.asList(cards));
		userChoice = new HashSet<String>();
	}

	public void play() throws Exception {
		// Play method will automatically shuffle the cards for you.
		cardList = shuffle();
		System.out.println(cardList);
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 2; i++) {
			System.out.println("Hit <RETURN> to choose a card");
			br.readLine();

			int cardChoice = (int) (r.next() * cardList.size());
			System.out.println("You chose " + cardList.get(cardChoice));
			userChoice.add(cardList.remove(cardChoice));
		}

		System.out.println("Cards chosen: " + userChoice);
		System.out.println("Remaining cards: " + remainingCards());
	}

	// Check if the user has won the game and return a boolean, instead of printing a msg.
	// This way a custom msg can be set based on the output in the GameApp.java
	public boolean hasWon() {
		boolean won;
		if (userChoice.contains("AHrts") || userChoice.contains("ADmnds") || userChoice.contains("ASpds") || userChoice.contains("AClbs")) {
			won = true;
		} else {
			won = false;
		}

		return won;
	}

	// Shuffles deck and returns it.
	private ArrayList<String> shuffle() {
		r = new LinearCongruentialGenerator();
		for (int i = 0; i < 100; i++) {
			// choose two random cards and swap them 100 times
			int firstIndex = ((int) (r.next() * 52));
			int secondIndex = ((int) (r.next() * 52));

			String temp = (String) cardList.get(firstIndex);
			cardList.set(firstIndex, cardList.get(secondIndex));
			cardList.set(secondIndex, temp); 
		}
		return cardList;
	}

	// Simply returns the cards remaining in the deck.
	private ArrayList<String> remainingCards() {
		return cardList;
	}
}