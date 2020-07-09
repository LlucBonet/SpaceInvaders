package tp.p1.game;

//import tp.p1.util.MyStringUtil;

public abstract class GamePrinter {
	
	
	public GamePrinter (int rows, int cols) {

	}
	
	public abstract String setGame(Game game);
	public abstract void printGame();
	public abstract void encodeGame(Game game);

}
