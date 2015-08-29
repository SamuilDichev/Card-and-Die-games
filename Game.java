// Interface to allow all games to be used in the same ways.
// The code won't have to know which one has been chosen because they all use the same methods anyway.
// This helps the Factory Pattern.
public interface Game {
	public void play() throws Exception;
	public boolean hasWon();
}