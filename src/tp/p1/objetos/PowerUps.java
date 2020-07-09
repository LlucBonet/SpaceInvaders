package tp.p1.objetos;

import tp.p1.game.Game;

public abstract class PowerUps extends Weapon {

	public PowerUps(Game game, int fila, int col, int live, boolean enableWeapon) {
		super(game, fila, col, live, enableWeapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enableWeapon(boolean superMissile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameObject addBomb() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean isSw() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void buySuperMissile() {
		// TODO Auto-generated method stub

	}

	@Override
	public String stringifierToString() {
		// TODO Auto-generated method stub
		return null;
	}

}
