package tp.p1.objetos;

import tp.p1.game.Game;
import tp.p1.objetos.GameObject;

public class DestroyerShip extends AlienShip {

	private Bomb bomb;		
	private boolean activeBomb;
	
	public DestroyerShip(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live, STRENGTH, DAMAGE, POINTS);
	//	bomb = new Bomb(game, getFila(), getCol(), 1, false);
		activeBomb = false;
	}
	
	void setActiveBomb(boolean active) {
		this.activeBomb = active;
	}

	public void moveBomb() {
//		if(!this.bomb.enableWeapon) {
//			this.bomb.fila = this.fila;
//			this.bomb.col = this.col;
//		}
	}
	
	//IMPLEMENTS GAMEOBJECT
	
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && !this.activeBomb/*!this.bomb.enableWeapon*/) {
//			this.bomb.enableWeapon = true;
			Bomb bomb = new Bomb(game, this.fila, this.col, 1, this);
			this.activeBomb = true;
			this.game.addObject(bomb);
		}
	}

	@Override
	public boolean onDelete() {	
		this.game.receivePoints(this.POINTS);
		AlienShip.setNumAliens(getNumAliens() - 1);
		return true;
	}

	@Override
	public String toString() {
		if(this.isAlive()) {
			return "D[" + getLive() + "]";
		}
		else {
			return " ";
		}
	}
	
	@Override
	public String stringifierToString() {
		if(this.isAlive()) {
			String direccion = "";
			if(AlienShip.direccion) direccion = "Right";
			else direccion = "Left";
			return "D;" + this.col + ',' + this.fila + ';' + this.getLive() + ";" + direccion + "\n";
		}
		else return "";
	}
	
	//OVERRIDES IGAMEFLOW
	@Override
	public boolean limite() {
		if(this.col == 0 || this.col == Game.DIM_X - 1) return true;
		else return false;
	}
	
	@Override
	public GameObject addBomb() {
		return bomb;
	}
//	public boolean remove() {
//		if(!this.bomb.enableWeapon) {
//			this.bomb = null;
//			return true;
//		}
//		else return false;
//	}
	
	//OVERRIDES IATTACK
	public boolean receiveMissileAttack(int damage) {
		if(this.isAlive()) {
			this.live -= damage;
			if(!this.isAlive()) {
				this.onDelete();
			}
		}
		return true;
	}
}
