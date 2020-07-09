package tp.p1.objetos;

import tp.p1.game.Game;

public class Ovni extends EnemyShip implements IExecuteRandomActions {

	private boolean enable;
//	private Shockwave sw;
	
	public Ovni(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live, STRENGTH, DAMAGE, POINTS);
		this.enable = false;
		//sw = new Shockwave(game, getFila(), getCol(), 1, false);
	}
	
	public boolean getEnable() {
		return this.enable;
	}

	
	//IMPLEMENTS GAMEOBJECT
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && this.getEnable() == false) {
			this.enable = true;
		}
	}

	@Override
	public boolean onDelete() {
		this.live = 1;
		this.enable = false;
		this.fila = 0;
		this.col = Game.DIM_X;
		this.game.receivePoints(this.POINTS);
		if(!this.game.isSw()) {
			this.game.setSw(true);
		}	
		return false;
	}

	@Override
	public void move() {
		if(this.enable) {
			this.col--;
			if(this.isOut()) {
				this.enable = false;
				this.col = Game.DIM_X;
				this.fila = 0;
			}
		}
	}

	@Override
	public String toString() {
		if(this.enable) {
			return "O[" + getLive() +"]";
		}
		else return " ";
	}
	@Override
	public String stringifierToString() {
		if(this.enable) {
			return "O;" + this.col + "," +  this.fila + ";" + this.live + "\n";
		}
		else return "";
	}
	
	//IATTACK
	
	public boolean receiveMissileAttack(int damage) {
		//if(this.enable) {
			this.live -= damage;
			if(!this.isAlive()) {
				this.onDelete();				
			}
	//	}
		return true;
	}
}
