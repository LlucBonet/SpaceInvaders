package tp.p1.objetos;

import tp.p1.game.Game;

public abstract class Ship extends GameObject {
		protected int STRENGTH;
		protected int DAMAGE;
		protected int POINTS;
		
	public Ship(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live);
		this.STRENGTH = STRENGTH;
		this.DAMAGE = DAMAGE;
		this.POINTS = POINTS;
	}
}
