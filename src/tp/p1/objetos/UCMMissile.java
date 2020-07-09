package tp.p1.objetos;

import tp.p1.controlador.CommandExecuteException;
import tp.p1.game.Game;

public class UCMMissile extends Weapon {
	private static int numSuperMissile;
	private boolean superMissile;
	
	public UCMMissile(Game game, int fila, int col, int live, boolean enableWeapon) {
		super(game, fila, col, live, enableWeapon);
		numSuperMissile = 0;
	}
	
	public static int getNumSuperMissile() {
		return numSuperMissile;
	}
	
	//IMPLEMENTS GAMEOBJECT
	@Override
	public boolean onDelete() {
		this.enableWeapon = false;
		this.live = 1;
		return false;
	}

	@Override
	public void move() {
		if(this.enableWeapon) {
			this.fila--;
			if(this.isOut()) {
				this.enableWeapon = false;
			}
		}
	}

	@Override
	public String toString() {
		if(this.enableWeapon) {
			return "oo";
		}
		else return " ";
	}

	
	@Override
	public String stringifierToString() {
		if(this.enableWeapon) {
			if(this.superMissile) return  "X;" + this.col + "," +  this.fila + "\n";
			else return "M;" + this.col + "," +  this.fila + "\n";		
		}
		else return "";
	}
	
	
	//OVERRIDES IGAMEFLOW
	@Override
	public boolean enableWeapon(boolean superMissile) throws CommandExecuteException {
		if(superMissile && numSuperMissile > 0 && !this.enableWeapon) {
			this.enableWeapon = true;
			numSuperMissile--;
			this.superMissile = true;
			return true;
		}
		else if(superMissile && numSuperMissile > 0 && this.enableWeapon) {
			throw new CommandExecuteException("sm");
		}
		else if(superMissile && numSuperMissile == 0) {
			throw new CommandExecuteException("noSm");
		}
		else if(!superMissile && !this.enableWeapon){
			this.enableWeapon = true;
			this.superMissile = false;
			return true;
		}
		else throw new CommandExecuteException("s");
	}
	
	@Override
	public void buySuperMissile() {
		numSuperMissile++;
	}

	//OVERRIDES IATTACK
	public void performAttack(GameObject other) {
		if(this.enableWeapon && this.fila == other.fila && this.col == other.col) {
			if(!other.equals(this)) {
				if(this.superMissile) {
					if(other.receiveMissileAttack(2)) {
						this.onDelete();
					} 
				}
				else if(!this.superMissile) {
					if(other.receiveMissileAttack(1)) {
						this.onDelete();
					}
				}
			}
		}
	}
	
	public boolean receiveBombAttack(int damage) {
		if(this.enableWeapon) {
			this.onDelete();
			return true;
		}
		else return false;
	}

}