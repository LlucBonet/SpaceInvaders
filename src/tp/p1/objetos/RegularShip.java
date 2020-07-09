package tp.p1.objetos;

import tp.p1.game.Game;

public class RegularShip extends AlienShip {

	private boolean explosive;
	
	public RegularShip(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live, STRENGTH, DAMAGE, POINTS);
	}
	
	public int getPOINTS() {
		return this.POINTS;
	}

	//IMPLEMENTS ALIENSHIP
	@Override
	public void moveBomb() {}

	
	//IMPLEMENTS GAMEOBJECT
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateExplosiveAlien(game)) {
			if(!this.explosive) {
				this.explosive = true;
			}
		}
	}

	@Override
	public boolean onDelete() {
		game.receivePoints(POINTS);
		AlienShip.setNumAliens(getNumAliens() - 1);
		return true;
	}

	@Override
	public String toString() {
		if(this.isAlive()) {
			if(this.explosive) {
				return "E[" + getLive() + "]";
			}
			else return "R[" + getLive() + "]"; 
		}
		else return " ";
	}

	@Override
	public String stringifierToString() {
		if(this.isAlive()) {
			String direccion = "";
			if(AlienShip.direccion) direccion = "Right";
			else direccion = "Left";
			if(this.explosive) 	{
				return "E;" + this.col + ',' + this.fila + ';'+ this.getLive() + ";" + this.STRENGTH + ";" + direccion + "\n";
			}
			else {
				return "R;" + this.col + ',' + this.fila + ';'+ this.getLive() + ";" + this.STRENGTH + ";" + direccion + "\n";
			}
		}
		else return "";
	}
	
	//OVERRIDES IGAMEFLOW
	@Override
	public boolean limite() {
		if(this.col == 0 || this.col == Game.DIM_X - 1) return true;
		else return false;
	}
	
	//OVERRIDES IATTACK
	public boolean receiveMissileAttack(int damage) {
		if(this.isAlive()) {
			this.live -= damage;
			if(!this.isAlive()) {
				if(this.explosive) {
					game.explosiveAction(this.fila, this.col);
				}
				this.onDelete();
			}
		}
		return true;
	}

}
