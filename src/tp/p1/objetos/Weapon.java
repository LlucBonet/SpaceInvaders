package tp.p1.objetos;

import tp.p1.game.Game;

public abstract class Weapon extends GameObject { 
	protected boolean enableWeapon;
	
	public Weapon(Game game, int fila, int col, int live, boolean enableWeapon) {
		super(game, fila, col, live);
		this.enableWeapon = enableWeapon;
	}
	
	@Override
	public void computerAction() {}
}

