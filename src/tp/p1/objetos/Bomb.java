package tp.p1.objetos;

import tp.p1.game.Game;


public class Bomb extends Weapon implements IExecuteRandomActions {
	private DestroyerShip ship;

	public Bomb(Game game, int fila, int col, int live, DestroyerShip ship) {
		super(game, fila, col, live);
		
		this.ship = ship;
	}
	

	//IMPLEMENTS GAMEOBJECT
	@Override
	public boolean onDelete() {
		//this.enableWeapon = false;
		ship.setActiveBomb(false);
		this.live = 0;
		return true;
	}

	@Override
	public void move() {
		//if(this.enableWeapon) {
			this.fila++;
			if(this.isOut()) {
				//this.enableWeapon = false;
				this.onDelete();
			}
		//}	
	}
	
	@Override
	public String toString() {
		//if(this.enableWeapon) {
			return ".";
		//}
		//else return " ";
	}
	
	@Override
	public String stringifierToString() {
		//if(this.enableWeapon) {
			return "B;" + this.col + "," +  this.fila + "\n";
		//}
		//else return "";
	}
	
	//OVERRIDES IGAMEFLOW
	@Override
	public boolean enableWeapon(boolean superMissile) {
		return false;
	}
	
	//OVERRIDES IATTACK
	public void performAttack(GameObject other) {
		if(/*this.enableWeapon &&*/ this.fila == other.fila && this.col == other.col && !other.equals(this)) {
			if(other.receiveBombAttack(1)) {
				this.onDelete();
			}
		}
	}
	
	public boolean receiveMissileAttack(int damage) {
		//if(this.enableWeapon) {
			this.onDelete();
			return true;
		//}
		//else return false;
	}
}
