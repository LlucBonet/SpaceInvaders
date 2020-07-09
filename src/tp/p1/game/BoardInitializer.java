package tp.p1.game;

import tp.p1.objetos.*;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	
	public GameObjectBoard initializeBoard(Game game, Level level) {
		this.level = level;
		this.game = game;
		this.board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		return board;
	}
	
	public void initialize() {
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
	}
	
	private void initializeOvni() {
		GameObject ovni = new Ovni(game, 0, Game.DIM_X, 1, 1, 0, 25);
//		GameObject sw = new Shockwave(game, 0, Game.DIM_X, 1, false);
//		board.add(sw);
		board.add(ovni);
	}
	
	private void initializeRegularAliens() {
		for(int i = 0; i < level.getNumRegularShip(); i++) {
			if(i>= 0 && i < 4) {
				GameObject regularShip = new RegularShip(game, 1, Game.DIM_X/2 - 1 + i, 2, 2, 0, 5);
				board.add(regularShip);
			}
			else if (i >= 4 && i < level.getNumRegularShip()) {
				GameObject regularShip = new RegularShip(game, 2, Game.DIM_X/2 + i - 5, 2, 2, 0, 5);
				board.add(regularShip);
			}
		}
	}
	
	private void initializeDestroyerAliens () {
		if(level.name() == "EASY") {
			for(int i = 0; i < level.getNumDestroyerShip(); i++) {
				GameObject destroyerShip = new DestroyerShip(game, 2, Game.DIM_X/2 + i, 1, 1, 1, 10);
				board.add(destroyerShip.addBomb());		
				board.add(destroyerShip);
;
			}
		}
		else if (level.name() == "HARD") {
			for(int i = 0; i < level.getNumDestroyerShip(); i++) {
				GameObject destroyerShip = new DestroyerShip(game, 3, Game.DIM_X/2 + i, 1, 1, 1, 10);
				board.add(destroyerShip.addBomb());		
				board.add(destroyerShip);
			}
		}
		else {
			for(int i = 0; i < level.getNumDestroyerShip(); i++) {
				GameObject destroyerShip = new DestroyerShip(game, 3, Game.DIM_X/2 - 1 + i, 1, 1, 1, 10);
				board.add(destroyerShip.addBomb());		
				board.add(destroyerShip);	
			}
		}
	}
}
