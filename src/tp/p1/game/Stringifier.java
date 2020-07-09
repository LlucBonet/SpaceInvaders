package tp.p1.game;

public class Stringifier extends GamePrinter {

	public Stringifier() {
		super(Game.DIM_Y, Game.DIM_X);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printGame() {
		
	}

	@Override
	public void encodeGame(Game game) {
	}

	@Override
	public String setGame(Game game) {
		return game.stringifierInfo();
	}

}
