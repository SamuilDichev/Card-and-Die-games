public class gameFactory {
	public Game createGame(String game) throws Exception {
		// .toLowerCase() ensures Factory is not case sensitive.
		if (game.toLowerCase().equals("c")) return new CardGame();
		else if (game.toLowerCase().equals("d")) return new DieGame();
		else throw new Exception("Don't know how to create a " + game);
	}
}