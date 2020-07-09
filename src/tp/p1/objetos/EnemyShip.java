package tp.p1.objetos;

import tp.p1.game.Game;
	
public abstract class EnemyShip extends Ship {		
	public EnemyShip(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live, STRENGTH, DAMAGE, POINTS);
	}
	
}
